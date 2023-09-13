package com.lucasdsf.api.vechiclerental.services;

import com.lucasdsf.api.vechiclerental.rest.response.RentalVehicleResponse;
import com.lucasdsf.api.vechiclerental.rest.resquest.RentalVehicleRequest;
import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;

public interface RentalSenderService {
	void registerRental(VehicleRequest vehicleRequest);
	RentalVehicleResponse findRental(RentalVehicleRequest requesEmailSender);
}
