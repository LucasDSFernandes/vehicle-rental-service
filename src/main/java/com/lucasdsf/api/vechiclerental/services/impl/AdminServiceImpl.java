package com.lucasdsf.api.vechiclerental.services.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lucasdsf.api.vechiclerental.builder.ManufactoreEntityBuilder;
import com.lucasdsf.api.vechiclerental.builder.ModelEntityBuilder;
import com.lucasdsf.api.vechiclerental.builder.VehicleDtoBuilder;
import com.lucasdsf.api.vechiclerental.builder.VehicleEntityBuilder;
import com.lucasdsf.api.vechiclerental.domains.entities.ManufactoreVehicles;
import com.lucasdsf.api.vechiclerental.domains.entities.ModelVehicles;
import com.lucasdsf.api.vechiclerental.domains.entities.Vehicle;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.domains.repositories.ManufactoreRepository;
import com.lucasdsf.api.vechiclerental.domains.repositories.ModelRepository;
import com.lucasdsf.api.vechiclerental.domains.repositories.VehicleRepository;
import com.lucasdsf.api.vechiclerental.enums.CategoryVehicleEnums;
import com.lucasdsf.api.vechiclerental.exception.ErrorException;
import com.lucasdsf.api.vechiclerental.services.AdminService;

@Component
public class AdminServiceImpl implements AdminService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private ManufactoreRepository manufactoreRepository;

	@Override
	public void registerVehicle(VehicleDto  vehicleDto) {
		try {
			ManufactoreVehicles brandEntity = ManufactoreEntityBuilder.brandBuilder()
										.description(vehicleDto.getManufacturer().getName())
										.codeIntegration(vehicleDto.getManufacturer().getId())
										.build();
			ModelVehicles modelEntity = ModelEntityBuilder.modelBuilder()
										.brand(brandEntity)
										.codeIntegration(vehicleDto.getModel().getId())
										.description(vehicleDto.getModel().getName())
										.modelYear(vehicleDto.getYearFuel().getName())
										.modelYearId(vehicleDto.getYearFuel().getId())
										.build();
			
			Vehicle vehicle = VehicleEntityBuilder.veihicleBuilder()
								.descriptionFuel(vehicleDto.getYearFuel().getName())
								.fgRental(false)
								.model(modelEntity)
								.typeCategory(CategoryVehicleEnums.findById(vehicleDto.getCategory().getId()))
								.weekdayRentalPrice(vehicleDto.getWeekdayNormal())
								.weekendayRentalPrice(vehicleDto.getWeekenddayNormal())
								.weekdayRentelPriceLoyalty(vehicleDto.getWeekdayLoyalty())
								.weekendayRentelPriceLoyalty(vehicleDto.getWeekenddayLoyalty())
								.dateInclusion(LocalDate.now())
								.build();
			
			logger.info("Criando veiculo de marca {}, modelo {}, ano conbustivel {}", vehicleDto.getManufacturer().getName(),
					vehicleDto.getModel().getName(), vehicleDto.getYearFuel().getName());
			manufactoreRepository.save(brandEntity);
			modelRepository.save(modelEntity);
			vehicleRepository.save(vehicle);
			
		} catch (ErrorException e) {
			throw new ErrorException("Erro ao registrar veiculo", e.getCause());
		} catch (Exception ex) {
			throw new ErrorException("Erro ao registrar veiculo", ex.getCause());
		}
	}

	
	@Override
	public List<VehicleDto> findAllVehicleByCategory(Integer categoryParam) {
		List<VehicleDto> vehicleList = new ArrayList<>();
			List<Vehicle> allVehicle = new ArrayList<>();
			if(Optional.ofNullable(categoryParam).isPresent() && !categoryParam.equals(0)){
				allVehicle = vehicleRepository.findByTypeCategory(CategoryVehicleEnums.findById(categoryParam));
			}else {
				allVehicle = vehicleRepository.findAll();
			}
			
			if(!allVehicle.isEmpty()){
					allVehicle.stream().forEach(vehicle-> {
					VehicleDto vehicleDtoBuilder=	VehicleDtoBuilder.veihicleBuilder()
														.yearFuel(vehicle.getDescriptionFuel())
														.yearFuelId(vehicle.getModel().getModelYear())
														.modelId(vehicle.getModel().getId().toString())
														.modelName(vehicle.getModel().getDescription())
														.manufactoreName(vehicle.getModel().getBrand().getDescription())
														.manufactorerId(vehicle.getModel().getBrand().getId().toString())
														.category(vehicle.getTypeCategory().getDesciption())
														.categoryId(vehicle.getTypeCategory().getId())
														.idVehicle(vehicle.getId())
														.weekdayNormal(vehicle.getWeekdayRentalPrice())
														.weekdayLoyalty(vehicle.getWeekdayRentelPriceLoyalty())
														.weekenddayNormal(vehicle.getWeekendayRentalPrice())
														.weekenddayLoyalty(vehicle.getWeekendayRentelPriceLoyalty())
														.build();
	
					
					vehicleList.add(vehicleDtoBuilder);
				});
			}
		return vehicleList;
	}

	
	@Override
	public void deleteVehicle(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() ->new ErrorException("Não foi possivel encontrar o veículo."));;
		try {
			logger.info("Veiculo de Marca {}, Modelo {}, Ano {}, será deletado.", vehicle.getModel().getBrand().getDescription(),
					vehicle.getModel().getDescription(),vehicle.getModel().getModelYear());
			vehicleRepository.delete(vehicle);
		}catch (ErrorException e) {
			throw new ErrorException("Erro ao deletar veiculo.", e.getCause());
		}catch (Exception ex) {
			throw new ErrorException("Erro ao deletar veiculo.", ex.getCause());
		}
	}
	
	public boolean isWeekend() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		boolean isWeekend = false;

		if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
			isWeekend = true;
		}
		
		return isWeekend;
	}
	
	public LocalDate parserStringToLocalDate(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return Optional.ofNullable(value).map(localDate -> LocalDate.parse(value, formatter)).orElse(null);
	}
	
}