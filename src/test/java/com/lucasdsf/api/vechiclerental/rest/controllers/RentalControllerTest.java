package com.lucasdsf.api.vechiclerental.rest.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.domains.model.ManufacturerDto;
import com.lucasdsf.api.vechiclerental.domains.model.ModelDto;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.domains.model.YearDto;
import com.lucasdsf.api.vechiclerental.rest.response.RentalVehicleResponse;
import com.lucasdsf.api.vechiclerental.rest.resquest.RentalVehicleRequest;
import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;
import com.lucasdsf.api.vechiclerental.services.impl.RentalSenderServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class RentalControllerTest {

	@MockBean
	private RentalSenderServiceImpl rentalService;
	@Autowired
	private MockMvc mvc;
	
	String writeValueAsString = null;
 
	@Test
	public void validateSearchRental() throws Exception {
		BDDMockito.given(this.rentalService.findRental(Mockito.any(RentalVehicleRequest.class))).willReturn(getResponseRental());
		mvc.perform(MockMvcRequestBuilders.post("/rental/search")
				.accept(MediaType.APPLICATION_JSON)
				.content(getRequestContent())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	
	@Test
	public void validateRegisterRental() throws Exception {
		this.rentalService.registerRental(Mockito.any(VehicleRequest.class));
		 mvc.perform(MockMvcRequestBuilders.post("/rental/register")
				 .accept(MediaType.APPLICATION_JSON)
				 .content(this.getRequestRegister())
				 .contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(status().isOk());
	}

	private RentalVehicleResponse getResponseRental() {
		RentalVehicleResponse response = new RentalVehicleResponse();
		response.setFgLoyalty(true);
		List<VehicleDto> vehicles = new ArrayList<>();
		VehicleDto vehicle = new VehicleDto();
		
		ManufacturerDto manufacturer = new ManufacturerDto();
		vehicle.setManufacturer(manufacturer);
		
		ModelDto model = new ModelDto();
		model.setId("1");
		model.setName("model");
		vehicle.setModel(model);
		
		CategoryDto category = new CategoryDto();
		category.setId(1);
		category.setName("cat");
		vehicle.setCategory(category);
		
		YearDto yearFuel = new YearDto();
		vehicle.setYearFuel(yearFuel );
		vehicles.add(vehicle);
		response.setVehicles(vehicles);
		
		return response;
	}
	private String getRequestContent() throws JsonProcessingException {
		RentalVehicleRequest request = new RentalVehicleRequest();
		request.setEmail("email@gmail.com");
		request.setEndDate(LocalDate.now());
		request.setInitialDate(LocalDate.now());
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper.writeValueAsString(request);	
	}
	private String getRequestRegister() throws JsonProcessingException {
		VehicleRequest request = new VehicleRequest();
		
		RentalVehicleRequest search = new RentalVehicleRequest();
		search.setEmail("email");
		request.setSearch(search);
		
		VehicleDto vehicle = new VehicleDto();
		
		ManufacturerDto manufacturer = new ManufacturerDto();
		vehicle.setManufacturer(manufacturer);
		
		ModelDto model = new ModelDto();
		model.setId("1");
		model.setName("model");
		vehicle.setModel(model);
		
		CategoryDto category = new CategoryDto();
		category.setId(1);
		category.setName("cat");
		vehicle.setCategory(category);
		
		YearDto yearFuel = new YearDto();
		vehicle.setYearFuel(yearFuel );
		
		request.setVehicle(vehicle);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper.writeValueAsString(request);	
	}
}
