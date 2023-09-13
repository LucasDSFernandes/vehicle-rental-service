package com.lucasdsf.api.vechiclerental.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdsf.api.vechiclerental.rest.resources.RentalResource;
import com.lucasdsf.api.vechiclerental.rest.response.RentalVehicleResponse;
import com.lucasdsf.api.vechiclerental.rest.resquest.RentalVehicleRequest;
import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;
import com.lucasdsf.api.vechiclerental.services.RentalSenderService;

@RestController
@RequestMapping("/rental")
@CrossOrigin(origins = "*")
public class RentalController implements RentalResource{
	@Autowired
	RentalSenderService rentalSenderService;
	
	@Override
	@PostMapping(path="/register")
	public ResponseEntity<?> registerRental(@RequestBody VehicleRequest vehicleRequest) {
		rentalSenderService.registerRental(vehicleRequest);
		return ResponseEntity.ok(true);
	}
	@Override
	@PostMapping(path="/search")
	public ResponseEntity<RentalVehicleResponse> findRental(@RequestBody RentalVehicleRequest requesRentalVehicle) {
		return ResponseEntity.ok(rentalSenderService.findRental(requesRentalVehicle));
	}
}
