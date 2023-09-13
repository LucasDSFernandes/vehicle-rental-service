package com.lucasdsf.api.vechiclerental.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeManufactoreResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeModelResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeYearResponse;
import com.lucasdsf.api.vechiclerental.services.impl.UtilServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UtilsControllerTest {


	@MockBean
	private UtilServiceImpl utilService;
	
	@Autowired
	private MockMvc mvc;
	private static final Integer ID_CATEGORY = 1;
	private static final String NM_CATEGORY = "category";
	private static final String ID_MODEL = "43";
	private static final String NM_MODEL = "modelo";
	private static final Integer ID_MANUFACTURE = 6;
	private static final String NM_MANUFACTURE = "marca";
	private static final String ID_YEAR_FUEL = "6";
	private static final String NM_YEAR_FUEL = "year fuel";

	
	@Test
	public void validateAllCategoryVechicle() throws Exception {
		BDDMockito.given(this.utilService.findCategoriesVechicle()).willReturn(getCategories());
		mvc.perform(get("/utils/categories"))
			.andExpect(status().isOk());
	}
	@Test
	public void validateAllManufactrurer() throws Exception {
		BDDMockito.given(this.utilService.findAllManufactures()).willReturn(getManufacture());
		 mvc.perform(get("/utils/manufacturers"))
				 .andExpect(status().isOk());
	}
	@Test
	public void validateAllModel() throws Exception {
		BDDMockito.given(this.utilService.findModelByManufacture(Mockito.anyInt())).willReturn(getModel());
		mvc.perform(get("/utils/manufacturers/"+Mockito.anyInt()+"/models"))
		.andExpect(status().isOk());
	}
	@Test
	public void validateAllYearFuel() throws Exception {
		BDDMockito.given(this.utilService.findYearsFuels(Mockito.anyInt(), Mockito.anyInt())).willReturn(getYearFuel());
		mvc.perform(get("/utils/manufacturers/"+Mockito.anyInt()+"/models/"+Mockito.anyInt()+"/years_fuels"))
		.andExpect(status().isOk());
	}
	private List<CategoryDto> getCategories() {
		CategoryDto category = new CategoryDto();
		List<CategoryDto> categoryList = new ArrayList<>();
		category.setId(ID_CATEGORY);
		category.setName(NM_CATEGORY);
		categoryList.add(category);
		return categoryList;
	}
	private List<IntegrationFipeModelResponse> getModel() {
		IntegrationFipeModelResponse model = new IntegrationFipeModelResponse();
		List<IntegrationFipeModelResponse> modelList = new ArrayList<>();
		model.setIdIntegrationModel(ID_MODEL);
		model.setFipeName(NM_MODEL);
		modelList.add(model);
		return modelList;
	}
	private List<IntegrationFipeManufactoreResponse> getManufacture() {
		IntegrationFipeManufactoreResponse manufacture = new IntegrationFipeManufactoreResponse();
		List<IntegrationFipeManufactoreResponse> modelList = new ArrayList<>();
//		manufacture.setIdIntegrationBrand(ID_MANUFACTURE);
//		manufacture.setFipeName(NM_MANUFACTURE);
		modelList.add(manufacture);
		return modelList;
	}
	private  List<IntegrationFipeYearResponse> getYearFuel() {
		List<IntegrationFipeYearResponse> yearList = new ArrayList<>();
		IntegrationFipeYearResponse year = new IntegrationFipeYearResponse();
		year.setIdIntegrationYear(ID_YEAR_FUEL);
		year.setFipeCodigo(NM_YEAR_FUEL);
		yearList.add(year);
		return yearList;
	}

}
