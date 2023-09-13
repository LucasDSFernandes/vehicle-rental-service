package com.lucasdsf.api.vechiclerental.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lucasdsf.api.vechiclerental.config.MessageConstantsProperties;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.exception.ErrorException;
import com.lucasdsf.api.vechiclerental.rest.resquest.RentalVehicleRequest;
import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;
import com.lucasdsf.api.vechiclerental.services.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void enviar(VehicleRequest request) {

		try{
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(MessageConstantsProperties.SENDER);
			RentalVehicleRequest rental = request.getSearch();
			simpleMailMessage.setTo(rental.getEmail());
			simpleMailMessage.setSubject("Aluguel de Veiculo");
			VehicleDto vehicle = request.getVehicle();
			simpleMailMessage.setText(getBody(vehicle.getManufacturer().getName(), vehicle.getModel().getName(), vehicle.getYearFuel().getName()
						, vehicle.getCategory().getName(), vehicle.getTotalLoyalty(), request.getSearch().getInitialDate(), request.getSearch().getEndDate()));
			logger.info("Enviando email para {}",  request.getSearch().getEmail() );
			javaMailSender.send(simpleMailMessage);
		} catch (ErrorException e) {
			throw new ErrorException("Erro ao enviar email ao destinatario", e.getCause());
		} catch (Exception e) {
			throw new ErrorException("Erro ao enviar email ao destinatario", e.getCause());
		}
	}

	private String getBody(String manufacture, String model, String year,
			String catogory, BigDecimal price, LocalDate dtInit, LocalDate dtEnd) {
		return String.format("Parabens! "
				+ "\n\n O alugem do carro foi registrado."
				+ "\n Segue a baixo as informações:"
				+ "\n\n Marca: %s "
				+ "\n Modelo: %s "
				+ "\n Ano Conbustivel: %s "
				+ "\n Categoria: %s "
				+ "\n Preço: R$ %s "
				+ "\n Data inicial: %s "
				+ "\n Data final entrega: %s "
				+ "\n\n Obrigado por escolher a gente!", manufacture, model, year, catogory, price, dtInit, dtEnd);
	}
	public LocalDate parserStringToLocalDate(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return Optional.ofNullable(value).map(localDate -> LocalDate.parse(value, formatter)).orElse(null);
	}
}
