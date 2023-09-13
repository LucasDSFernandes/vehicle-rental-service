package com.lucasdsf.api.vechiclerental.builder;

import java.util.Optional;

import com.lucasdsf.api.vechiclerental.domains.entities.ManufactoreVehicles;
import com.lucasdsf.api.vechiclerental.domains.entities.ModelVehicles;

public class ModelEntityBuilder {
	private ManufactoreVehicles brand;
	private String description;
	private String codeIntegration;
	private String modelYear;
	private String modelYearId;;
	
	public static ModelEntityBuilder modelBuilder() {
		return new ModelEntityBuilder();
	}
	
	public ModelEntityBuilder brand(ManufactoreVehicles brand) {
		this.brand = brand;
		return this;
	}
	public ModelEntityBuilder modelYearId(String modelYearId) {
		this.modelYearId = modelYearId;
		return this;
	}
	public ModelEntityBuilder description(String description) {
		this.description = description;
		return this;
	}
	public ModelEntityBuilder codeIntegration(String codeIntegration) {
		this.codeIntegration = codeIntegration;
		return this;
	}
	public ModelEntityBuilder modelYear(String modelYear) {
		this.modelYear = modelYear;
		return this;
	}
	
	public ModelVehicles build() {
		ModelVehicles modelVehicles = new ModelVehicles();
		Optional.ofNullable(this.brand)
			.ifPresent(brand -> modelVehicles.setBrand(brand));
		Optional.ofNullable(this.codeIntegration)
			.ifPresent(codeIntegration -> modelVehicles.setCodeIntegration(codeIntegration));
		Optional.ofNullable(this.description)
			.ifPresent(description -> modelVehicles.setDescription(description));
		Optional.ofNullable(this.modelYear)
			.ifPresent(modelYear -> modelVehicles.setModelYear(modelYear));
		Optional.ofNullable(this.modelYearId)
			.ifPresent(modelYearId -> modelVehicles.setModelYearId(modelYearId));
		return modelVehicles;
	}

}


