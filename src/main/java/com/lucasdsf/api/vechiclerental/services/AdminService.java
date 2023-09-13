package com.lucasdsf.api.vechiclerental.services;

import java.util.List;

import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.rest.resquest.VehicleRequest;

public interface AdminService {
	void registerVehicle(VehicleDto vehicle);
	void deleteVehicle(Long id);
	List<VehicleDto> findAllVehicleByCategory(Integer category);
}
