package com.lucasdsf.api.vechiclerental.services.impl;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdsf.api.vechiclerental.builder.RentalResponseBuilder;
import com.lucasdsf.api.vechiclerental.builder.UserEntityBuilder;
import com.lucasdsf.api.vechiclerental.builder.VehicleDtoBuilder;
import com.lucasdsf.api.vechiclerental.domains.entities.RentalVehicle;
import com.lucasdsf.api.vechiclerental.domains.entities.User;
import com.lucasdsf.api.vechiclerental.domains.entities.Vehicle;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.domains.repositories.RentalRepository;
import com.lucasdsf.api.vechiclerental.domains.repositories.UserRepository;
import com.lucasdsf.api.vechiclerental.domains.repositories.VehicleRepository;
import com.lucasdsf.api.vechiclerental.exception.ErrorException;
import com.lucasdsf.api.vechiclerental.rest.response.RentalVehicleResponse;
import com.lucasdsf.api.vechiclerental.rest.resquest.RentalVehicleRequest;
import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;
import com.lucasdsf.api.vechiclerental.services.EmailSenderService;
import com.lucasdsf.api.vechiclerental.services.RentalSenderService;

@Service
public class RentalSenderServiceImpl implements RentalSenderService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public void registerRental(VehicleRequest request ) {
		RentalVehicle rentalVehicle = new RentalVehicle();
		RentalVehicleRequest rental = request.getSearch();
		
		VehicleDto vehicle = request.getVehicle();
		if (Optional.ofNullable(request.getSearch().getEmail()).isPresent() && !request.getSearch().getEmail().isEmpty()) {
			emailSenderService.enviar(request);
		}
		
		try{
			Long amoutDay = getAmoutDay(rental.getInitialDate(),rental.getEndDate());
			if(amoutDay <= 0L){
				throw new Exception("Data do aluguel inicial não pode ser igual ou inferior da data final.");
			}
			rentalVehicle.setAmountDaysRented(amoutDay);
			rentalVehicle.setDtEndRental(rental.getEndDate());
			rentalVehicle.setDtStartRental(rental.getInitialDate());
			BigDecimal totalLoyalty = vehicle.getTotalLoyalty();
			BigDecimal price = new BigDecimal("0");
			
			if(totalLoyalty.compareTo(BigDecimal.ZERO) >= 0) {
				price =	price.add(totalLoyalty);
			}else {
				price = price.add(vehicle.getTotalNormal());
			}
			rentalVehicle.setPrice(price);
			rentalVehicle.setUser(getInfoUsertoSave(request));
			
			logger.info("Criando alugem do veiculo de marca {}, modelo {}, ano {}", vehicle.getManufacturer().getName(),
					vehicle.getModel().getName(), vehicle.getYearFuel().getName());
			rentalRepository.save(rentalVehicle);
		} catch (ErrorException e) {
			throw new ErrorException("Erro ao registrar veiculo", e.getCause());
		} catch (Exception ex) {
			throw new ErrorException("Erro ao registrar veiculo", ex.getCause());
		}
	}
	
	@Override
	public RentalVehicleResponse findRental(RentalVehicleRequest rental) {
		List<VehicleDto> vehicleResponse = new ArrayList<>();
		List<Vehicle> vehicles  = vehicleRepository.findByDateInclusionBetween(rental.getInitialDate(), rental.getEndDate());
		try {
			if(getAmoutDay(rental.getInitialDate(), rental.getEndDate()) <=0){
				 throw new Exception("Data do aluguel inicial não pode ser igual ou inferior da data final.");
			}
		
			vehicles.forEach(vehicle-> {
				BigDecimal priceAmountDay = getPrice(vehicle.getWeekendayRentalPrice(), vehicle.getWeekdayRentalPrice(), 
						rental.getInitialDate(), rental.getEndDate());
				VehicleDtoBuilder vehicleResponseBuilder=VehicleDtoBuilder.veihicleBuilder()
													.idVehicle(vehicle.getId())
													.yearFuel(vehicle.getDescriptionFuel())
													.yearFuelId(vehicle.getModel().getModelYear())
													.modelId(vehicle.getModel().getId().toString())
													.modelName(vehicle.getModel().getDescription())
													.manufactoreName(vehicle.getModel().getBrand().getDescription())
													.manufactorerId(vehicle.getModel().getBrand().getId().toString())
													.category(vehicle.getTypeCategory().getDesciption())
													.categoryId(vehicle.getTypeCategory().getId())
													.totalNormal(priceAmountDay);

				if(isFgLoyalty(rental.getEmail())) {
					vehicleResponseBuilder.totalLoyalty(getPrice(vehicle.getWeekendayRentelPriceLoyalty(), vehicle.getWeekdayRentelPriceLoyalty(), 
							rental.getInitialDate(), rental.getEndDate()));
				}	
				vehicleResponse.add(vehicleResponseBuilder.build());
		});
		}catch (Exception e) {
			throw new ErrorException(e.getMessage(), e.getCause());
		}
		return RentalResponseBuilder.rentalBuilder()
				.fgLoyalty(isFgLoyalty(rental.getEmail()))
				.vehicles(vehicleResponse)
				.build();
	}

	private BigDecimal getPrice(BigDecimal price, BigDecimal priceWeekend, LocalDate dtInit, LocalDate dtEnd) {
		BigDecimal priceAmount = BigDecimal.ZERO;
		
		while(dtInit.isBefore(dtEnd)){
			if(isWeekend(dtInit)) {
				priceAmount = priceAmount.add(priceWeekend);
			}else {
				priceAmount = priceAmount.add(price);
			}
			dtInit = dtInit.plusDays(1);
		}
		
		return priceAmount;
	}

	private User getInfoUsertoSave(VehicleRequest request) {
		Vehicle vihicleEntity = vehicleRepository.findById(request.getVehicle().getIdVehicle())
				.orElseThrow(()-> new EntityNotFoundException("Veiculo não encontrado."));
		
		User user = userRepository.findByEmail(request.getSearch().getEmail());
		if(!Optional.ofNullable(user).isPresent()) {
			user = UserEntityBuilder.userBuilder()
					.email(request.getSearch().getEmail())
					.fgLoyalty(isFgLoyalty(request.getSearch().getEmail()))
					.vehicle(vihicleEntity)
					.build();
			userRepository.save(user);
		}
			
		return user;
	}

	private boolean isFgLoyalty(String email) {
		boolean fgLoyalty = false;
		if(Optional.ofNullable(email).isPresent()  && !email.isEmpty()){
			fgLoyalty = true;
		}
		
		return fgLoyalty;
	}

	public LocalDate parserStringToLocalDate(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return Optional.ofNullable(value).map(localDate -> LocalDate.parse(value, formatter)).orElse(null);
	}

	public LocalDateTime parserStringToLocalDateTime(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return Optional.ofNullable(value).map(localDate -> LocalDateTime.parse(value, formatter)).orElse(null);
	}

	public Long getAmoutDay(LocalDate dtInit, LocalDate dtEnd) {
		Period periodo = Period.between(dtInit,dtEnd);
		return Long.valueOf(periodo.getDays());
	}

	public boolean isWeekend(LocalDate validDate) {
		boolean isWeekend = false;
		DayOfWeek dayOfWeek = validDate.getDayOfWeek();
		if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
			isWeekend = true;
		}
		return isWeekend;
	}
}
