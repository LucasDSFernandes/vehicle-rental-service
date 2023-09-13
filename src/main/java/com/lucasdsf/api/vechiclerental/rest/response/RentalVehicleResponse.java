package com.lucasdsf.api.vechiclerental.rest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;

public class RentalVehicleResponse {
	private List<VehicleDto> vehicles;
	@JsonProperty("loyalty")
	boolean fgLoyalty;
	
	public RentalVehicleResponse(){}
	
	public RentalVehicleResponse(boolean fgLoyalty, List<VehicleDto>  vehicles){
		this.fgLoyalty = fgLoyalty;
		this.setVehicles(vehicles);
	}
	public boolean isFgLoyalty() {
		return fgLoyalty;
	}
	public void setFgLoyalty(boolean fgLoyalty) {
		this.fgLoyalty = fgLoyalty;
	}

	public List<VehicleDto> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDto> vehicles) {
		this.vehicles = vehicles;
	}

}
