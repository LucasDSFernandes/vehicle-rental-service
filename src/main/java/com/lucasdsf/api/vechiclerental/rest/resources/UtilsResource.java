package com.lucasdsf.api.vechiclerental.rest.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeManufactoreResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeModelResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeYearResponse;
import com.lucasdsf.api.vechiclerental.rest.response.VehiclesResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface UtilsResource {
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Created", response = VehiclesResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por Listar os anos e conbustivelda FIPE.")
	ResponseEntity<List<IntegrationFipeYearResponse>> findYearsFuels(Integer modelId, Integer manufacturerId);

	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por listar todas as marca da FIPE.")
	ResponseEntity<List<IntegrationFipeManufactoreResponse>> findAllManufactures();
	
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por listar todas os modelos da FIPE.")
	ResponseEntity<List<IntegrationFipeModelResponse>> findModelByManufacture(Integer manufacturerId);

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Created", response = VehiclesResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por Listar as categorias para o cadastro de veiculos.")
	ResponseEntity<List<CategoryDto>> findCategories();
}
