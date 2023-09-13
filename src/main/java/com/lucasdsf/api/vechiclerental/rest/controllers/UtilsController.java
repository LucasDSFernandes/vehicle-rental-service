package com.lucasdsf.api.vechiclerental.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeManufactoreResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeModelResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeYearResponse;
import com.lucasdsf.api.vechiclerental.rest.resources.UtilsResource;
import com.lucasdsf.api.vechiclerental.services.VehicleService;

@RestController
@RequestMapping("/utils")
@CrossOrigin(origins = "*")
public class UtilsController implements UtilsResource{
	
	@Autowired
	private VehicleService vechileService;

	@Override
	@GetMapping(path="/categories")
	public ResponseEntity<List<CategoryDto>> findCategories() {
		return ResponseEntity.ok(vechileService.findCategoriesVechicle());
	}
	
	@Override
	@GetMapping(path="/manufacturers")
	public ResponseEntity<List<IntegrationFipeManufactoreResponse>> findAllManufactures() {
		return ResponseEntity.ok(vechileService.findAllManufactures());
	}

	@Override
	@GetMapping(path="/manufacturers/{manufacturerId}/models")
	public ResponseEntity<List<IntegrationFipeModelResponse>> findModelByManufacture(@PathVariable("manufacturerId")Integer manufacturerId) {
		return ResponseEntity.ok(vechileService.findModelByManufacture(manufacturerId));
	}

	@Override
	@GetMapping(path="/manufacturers/{manufacturerId}/models/{modelId}/years_fuels")
	public ResponseEntity<List<IntegrationFipeYearResponse>> findYearsFuels(@PathVariable("modelId") Integer modelId, @PathVariable("manufacturerId") Integer manufacturerId) {
		return ResponseEntity.ok(vechileService.findYearsFuels(modelId, manufacturerId));
	}
}
