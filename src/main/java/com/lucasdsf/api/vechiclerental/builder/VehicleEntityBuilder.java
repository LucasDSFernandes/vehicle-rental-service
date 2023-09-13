package com.lucasdsf.api.vechiclerental.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.lucasdsf.api.vechiclerental.domains.entities.ModelVehicles;
import com.lucasdsf.api.vechiclerental.domains.entities.Vehicle;
import com.lucasdsf.api.vechiclerental.enums.CategoryVehicleEnums;

public class VehicleEntityBuilder {
	private boolean fgRental;
	private String descriptionFuel;
	private LocalDate dateInclusion;
	private ModelVehicles model;
	private CategoryVehicleEnums typeCategory;
	private BigDecimal runTime;
	private BigDecimal weekdayRentalPrice;
	private BigDecimal weekendayRentalPrice;
	private BigDecimal weekdayRentelPriceLoyalty;
	private BigDecimal weekendayRentelPriceLoyalty;
	
	public static VehicleEntityBuilder veihicleBuilder() {
		return new VehicleEntityBuilder();
	}
	
	public VehicleEntityBuilder fgRental(boolean fgRental) {
		this.fgRental = fgRental;
		return this;
	}
	public VehicleEntityBuilder dateInclusion(LocalDate dateInclusion) {
		this.dateInclusion = dateInclusion;
		return this;
	}
	public VehicleEntityBuilder descriptionFuel(String descriptionFuel) {
		this.descriptionFuel = descriptionFuel;
		return this;
	}
	public VehicleEntityBuilder model(ModelVehicles model) {
		this.model = model;
		return this;
	}
	public VehicleEntityBuilder typeCategory(CategoryVehicleEnums typeCategory) {
		this.typeCategory = typeCategory;
		return this;
	}
	public VehicleEntityBuilder runTime(BigDecimal runTime) {
		this.runTime = runTime;
		return this;
	}
	public VehicleEntityBuilder weekdayRentalPrice(BigDecimal weekdayRentalPrice) {
		this.weekdayRentalPrice = weekdayRentalPrice;
		return this;
	}
	public VehicleEntityBuilder weekendayRentalPrice(BigDecimal weekendayRentalPrice) {
		this.weekendayRentalPrice = weekendayRentalPrice;
		return this;
	}
	public VehicleEntityBuilder weekdayRentelPriceLoyalty(BigDecimal weekdayRentelPriceLoyalty) {
		this.weekdayRentelPriceLoyalty = weekdayRentelPriceLoyalty;
		return this;
	}
	public VehicleEntityBuilder weekendayRentelPriceLoyalty(BigDecimal weekendayRentelPriceLoyalty) {
		this.weekendayRentelPriceLoyalty = weekendayRentelPriceLoyalty;
		return this;
	}
	
	public Vehicle build() {
		Vehicle vehicle = new Vehicle();
		Optional.ofNullable(this.fgRental)
			.ifPresent(fgRental -> vehicle.setFgRental(fgRental));
		Optional.ofNullable(this.fgRental)
		.ifPresent(fgRental -> vehicle.setFgRental(fgRental));
		Optional.ofNullable(this.model)
			.ifPresent(model -> vehicle.setModel(model));
		Optional.ofNullable(this.typeCategory)
			.ifPresent(typeCategory -> vehicle.setTypeCategory(typeCategory));
		Optional.ofNullable(this.weekdayRentalPrice)
			.ifPresent(weekdayRentalPrice -> vehicle.setWeekdayRentalPrice(weekdayRentalPrice));
		Optional.ofNullable(this.weekendayRentalPrice)
			.ifPresent(weekendayRentalPrice -> vehicle.setWeekendayRentalPrice(weekendayRentalPrice));
		Optional.ofNullable(this.weekdayRentelPriceLoyalty)
			.ifPresent(weekdayRentelPriceLoyalty -> vehicle.setWeekdayRentelPriceLoyalty(weekdayRentelPriceLoyalty));
		Optional.ofNullable(this.weekendayRentelPriceLoyalty)
			.ifPresent(weekendayRentelPriceLoyalty -> vehicle.setWeekendayRentelPriceLoyalty(weekendayRentelPriceLoyalty));
		Optional.ofNullable(this.runTime)
			.ifPresent(runTime -> vehicle.setRunTime(runTime));
		Optional.ofNullable(descriptionFuel)
			.ifPresent(descriptionFuel -> vehicle.setDescriptionFuel(descriptionFuel));
		Optional.ofNullable(dateInclusion)
		.ifPresent(dateInclusion -> vehicle.setDateInclusion(dateInclusion));
		
		return vehicle;
	}

}


