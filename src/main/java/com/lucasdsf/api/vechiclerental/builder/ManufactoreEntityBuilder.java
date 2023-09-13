package com.lucasdsf.api.vechiclerental.builder;

import java.util.Optional;

import com.lucasdsf.api.vechiclerental.domains.entities.ManufactoreVehicles;

public class ManufactoreEntityBuilder {
	private String description;
	private String codeIntegration;
	private String codeIntegrationOrder;
	
	public static ManufactoreEntityBuilder brandBuilder() {
		return new ManufactoreEntityBuilder();
	}
	
	public ManufactoreEntityBuilder codeIntegration(String codeIntegration) {
		this.codeIntegration = codeIntegration;
		return this;
	}
	public ManufactoreEntityBuilder description(String description) {
		this.description = description;
		return this;
	}
	public ManufactoreEntityBuilder codeIntegrationOrder(String codeIntegrationOrder) {
		this.codeIntegrationOrder = codeIntegrationOrder;
		return this;
	}
	
	public ManufactoreVehicles build() {
		ManufactoreVehicles brandsVehicles = new ManufactoreVehicles();
		Optional.ofNullable(codeIntegration)
			.ifPresent(codeIntegration -> brandsVehicles.setCodeIntegration(codeIntegration));
		Optional.ofNullable(codeIntegrationOrder)
			.ifPresent(brand -> brandsVehicles.setCodeIntegrationOrder(brand));
		Optional.ofNullable(description)
			.ifPresent(description -> brandsVehicles.setDescription(description));
		return brandsVehicles;
	}
}