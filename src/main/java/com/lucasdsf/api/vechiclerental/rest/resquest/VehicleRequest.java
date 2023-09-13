package com.lucasdsf.api.vechiclerental.rest.resquest;

import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;

public class VehicleRequest {
	private VehicleDto vehicle;
	private RentalVehicleRequest search;

	public VehicleDto getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDto vehicle) {
		this.vehicle = vehicle;
	}

	public RentalVehicleRequest getSearch() {
		return search;
	}

	public void setSearch(RentalVehicleRequest search) {
		this.search = search;
	}
}
