package com.lucasdsf.api.vechiclerental.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.rest.resources.AdminResource;
import com.lucasdsf.api.vechiclerental.services.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController implements AdminResource{

	@Autowired
	private AdminService adminService;
	
	@Override
	@GetMapping(value = "/vehicles")
	public ResponseEntity<List<VehicleDto>> findAllVehicleByCategory(@RequestParam(required = false, value ="category") Integer category) {
		return ResponseEntity.ok(adminService.findAllVehicleByCategory(category));
	}

	@Override
	@PostMapping(value = "/vehicle")
	public ResponseEntity<?> registerVehicle(VehicleDto vehicle) {
		adminService.registerVehicle(vehicle);
		return ResponseEntity.ok(true);
	}

	@Override
	@DeleteMapping(value = "/vehicle/{id}")
		public ResponseEntity<?> deleteVehicle(@PathVariable("id")  Long idVehicle) {
		adminService.deleteVehicle(idVehicle);
		return ResponseEntity.ok(true);
	}
}
