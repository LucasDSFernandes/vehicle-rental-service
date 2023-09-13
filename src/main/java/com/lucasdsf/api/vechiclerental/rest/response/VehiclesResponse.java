package com.lucasdsf.api.vechiclerental.rest.response;

import java.util.List;

import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;

public class VehiclesResponse {
	
	private List<VehicleDto> vehicles;

	public VehiclesResponse(List<VehicleDto> vehicles) {
		this.vehicles =  vehicles;
	}

	public List<VehicleDto> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDto> vehicles) {
		this.vehicles = vehicles;
	}
}
