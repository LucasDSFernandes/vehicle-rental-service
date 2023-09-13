package com.lucasdsf.api.vechiclerental.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.domains.model.ManufacturerDto;
import com.lucasdsf.api.vechiclerental.domains.model.ModelDto;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.domains.model.YearDto;
import com.lucasdsf.api.vechiclerental.services.impl.AdminServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AdminControllerTest	{

	@MockBean
	private AdminServiceImpl adminService;
	@Autowired
	private MockMvc mvc;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void vehicleByCategoryExist() throws Exception {
		BDDMockito.given(this.adminService.findAllVehicleByCategory(Mockito.anyInt())).willReturn(Mockito.anyList());
		 mvc.perform(get("/admin/vehicles"))
				 .andExpect(status().isOk());
	}
	
	@Test
	public void validateDeleteVehicle() throws Exception {
		this.adminService.deleteVehicle(Mockito.anyLong());
		mvc.perform(delete("/admin/vehicle/{id}", Mockito.anyLong())
		.contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void validateRegisterVehicle() throws Exception {
		this.adminService.registerVehicle(Mockito.any(VehicleDto.class));
		mvc.perform(post("/admin/vehicle").accept(MediaType.APPLICATION_JSON)
				.content(getRequestRegisterContent())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
		.andExpect(status().isOk());
	}
	
	private String getRequestRegisterContent() throws JsonProcessingException {
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
		vehicle.setYearFuel(yearFuel);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return mapper.writeValueAsString(vehicle);	
	}



}
