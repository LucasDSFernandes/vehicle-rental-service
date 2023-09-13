package com.lucasdsf.api.vechiclerental.builder;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.rest.response.RentalVehicleResponse;

public class RentalResponseBuilder {
	List<VehicleDto> vehicles;
	@JsonProperty("loyalty")
	boolean fgLoyalty;
	
	public static RentalResponseBuilder rentalBuilder() {
		return new RentalResponseBuilder();
	}
	
	public RentalResponseBuilder vehicles(List<VehicleDto> vehicles) {
		this.vehicles = vehicles;
		return this;
	}
	public RentalResponseBuilder fgLoyalty(boolean fgLoyalty) {
		this.fgLoyalty = fgLoyalty;
		return this;
	}
	
	public RentalVehicleResponse build() {
		RentalVehicleResponse rentalResponse = new RentalVehicleResponse();
		Optional.ofNullable(this.fgLoyalty)
			.ifPresent(fgLoyalty -> rentalResponse.setFgLoyalty(fgLoyalty));
		Optional.ofNullable(this.vehicles)
			.ifPresent(vehicles -> rentalResponse.setVehicles(vehicles));
		return rentalResponse;
	}
}