package com.lucasdsf.api.vechiclerental.integration.sevices;

import java.util.List;

import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeManufactoreResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeModelResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipePriceResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeYearResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IntegrationFipeService{
	
	@RequestLine("GET /marcas.json")
	@Headers({ "Content-Type: application/json" })
	List<IntegrationFipeManufactoreResponse> getAllManufactors();

	@RequestLine("GET /veiculos/{manufactore}.json")
	@Headers({ "Content-Type: application/json" })
	List<IntegrationFipeModelResponse> getAllVehicleModelBrands(@Param("manufactore") Integer idIntegrationManufactore);
	
	@RequestLine("GET /veiculo/{manufactore}/{model}.json")
	@Headers({ "Content-Type: application/json" })
	List<IntegrationFipeYearResponse> getAllModelsAndYears(@Param("manufactore") Integer idIntegidIntegrationManufactorerationBrand, @Param("model") Integer idIntegrationModel);
	
	@RequestLine("GET /veiculo/{manufactore}/{model}/{year}.json")
	@Headers({ "Content-Type: application/json" })
	IntegrationFipePriceResponse getInfoVehicle(@Param("manufactore") Integer idIntegrationManufactore,@Param("model") Integer idIntegrationModel, @Param("year")String idIntegrationYaer);
}
