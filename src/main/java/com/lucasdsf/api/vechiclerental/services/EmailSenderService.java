package com.lucasdsf.api.vechiclerental.services;

import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;

public interface EmailSenderService {
	void enviar(VehicleRequest request);
}
