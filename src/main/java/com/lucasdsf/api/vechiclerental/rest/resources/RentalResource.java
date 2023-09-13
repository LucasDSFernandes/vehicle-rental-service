package com.lucasdsf.api.vechiclerental.rest.resources;

import org.springframework.http.ResponseEntity;

import com.lucasdsf.api.vechiclerental.rest.response.RentalVehicleResponse;
import com.lucasdsf.api.vechiclerental.rest.response.VehiclesResponse;
import com.lucasdsf.api.vechiclerental.rest.resquest.RentalVehicleRequest;
import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface RentalResource {

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Created", response = VehiclesResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por registrar o Aluguel do carro.")
	ResponseEntity<?> registerRental(VehicleRequest vehicleRequest);

	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Api responsavel por listar todos os carros para aluguel.")
	ResponseEntity<RentalVehicleResponse> findRental(RentalVehicleRequest requesRentalVehicle);

}
