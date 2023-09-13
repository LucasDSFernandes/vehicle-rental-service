package com.lucasdsf.api.vechiclerental.services.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lucasdsf.api.vechiclerental.VehicleRentalServiceApplicationTest;
import com.lucasdsf.api.vechiclerental.domains.entities.ManufactoreVehicles;
import com.lucasdsf.api.vechiclerental.domains.entities.ModelVehicles;
import com.lucasdsf.api.vechiclerental.domains.entities.Vehicle;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.domains.repositories.VehicleRepository;
import com.lucasdsf.api.vechiclerental.enums.CategoryVehicleEnums;
class AdminServiceImplTest extends VehicleRentalServiceApplicationTest {

	@Autowired
	AdminServiceImpl adminService;
	@MockBean
	VehicleRepository vehicleRepositoryMock;
	@Autowired
	VehicleRepository vehicleRepository;
	@MockBean
	Vehicle vehicle;
	@MockBean
	ModelVehicles model;
	@MockBean
	ManufactoreVehicles manufactorer;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testeCategoryAnFindNull() {
		List<Vehicle> vehicleList = new ArrayList<>();
		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleList);
		List<VehicleDto> findAllVehicleByCategory = adminService.findAllVehicleByCategory(0);
    }
	
//	@Test
//	public void testeCategoryAnFindNotEmpty() {
//		List<Vehicle> vehicleList = new ArrayList<>();
//		model.setBrand(manufactorer);
//		vehicle.setModel(model);
//		vehicleList.add(vehicle);
//		when(vehicleRepository.findByTypeCategory(any(CategoryVehicleEnums.class))).thenReturn(vehicleList);
//		List<VehicleDto> findAllVehicleByCategory = adminService.findAllVehicleByCategory(1);
//	}
}
