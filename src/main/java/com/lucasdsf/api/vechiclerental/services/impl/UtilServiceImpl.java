package com.lucasdsf.api.vechiclerental.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.enums.CategoryVehicleEnums;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeManufactoreResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeModelResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeYearResponse;
import com.lucasdsf.api.vechiclerental.integration.sevices.IntegrationFipeService;
import com.lucasdsf.api.vechiclerental.services.VehicleService;

@Service
public class UtilServiceImpl implements VehicleService{
	@Autowired
	IntegrationFipeService integrationFipeService;
	
	@Override
	public List<CategoryDto> findCategoriesVechicle() {
		List<CategoryDto> categories = new ArrayList<>();
		
		Stream.of(CategoryVehicleEnums.values()).forEach(category ->{
			CategoryDto categoryResponse = new CategoryDto();
			categoryResponse.setName(category.getDesciption());
			categoryResponse.setId(category.getId());
			categories.add(categoryResponse);
		});
		return categories;
	}

	@Override
	public List<IntegrationFipeManufactoreResponse> findAllManufactures() {
		return integrationFipeService.getAllManufactors();
	}


	@Override
	public List<IntegrationFipeModelResponse> findModelByManufacture(Integer idManufactore) {
		return integrationFipeService.getAllVehicleModelBrands(idManufactore);
	}

	@Override
	public List<IntegrationFipeYearResponse> findYearsFuels(Integer idModel, Integer idManufactore) {
		return integrationFipeService.getAllModelsAndYears(idManufactore, idModel);
	}
}