package com.lucasdsf.api.vechiclerental.rest.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.rest.response.VehiclesResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface AdminResource {
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Created", response = VehiclesResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por Listar Todos os carros.")
	ResponseEntity<List<VehicleDto>> findAllVehicleByCategory(Integer category);

	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por Registrar um carro")
    ResponseEntity<?> registerVehicle(@RequestBody VehicleDto vehicle);
	
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por deletar um carro")
    ResponseEntity<?> deleteVehicle( Long idVehicle);

}
