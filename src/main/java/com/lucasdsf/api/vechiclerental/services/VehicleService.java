package com.lucasdsf.api.vechiclerental.services;

import java.util.List;

import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeManufactoreResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeModelResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeYearResponse;

public interface VehicleService {

	List<CategoryDto> findCategoriesVechicle();
	List<IntegrationFipeManufactoreResponse> findAllManufactures();
	List<IntegrationFipeModelResponse> findModelByManufacture(Integer manufacturerId);
	List<IntegrationFipeYearResponse> findYearsFuels(Integer idModel, Integer idYears);

}
