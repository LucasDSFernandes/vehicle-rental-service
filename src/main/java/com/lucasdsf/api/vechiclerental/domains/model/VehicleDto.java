package com.lucasdsf.api.vechiclerental.domains.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleDto {
	
	@JsonProperty("id")
	private Long idVehicle;
	private ModelDto model;
	private String email;
	private ManufacturerDto manufacturer;
	private CategoryDto category;
	private YearDto yearFuel;
	private BigDecimal weekdayNormal;
	private BigDecimal weekenddayNormal;
	private BigDecimal weekdayLoyalty;
	private BigDecimal weekenddayLoyalty;
	private BigDecimal totalNormal;
	private BigDecimal totalLoyalty;
	
	public ModelDto getModel() {
		return model;
	}
	public ManufacturerDto getManufacturer() {
		return manufacturer;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public YearDto getYearFuel() {
		return yearFuel;
	}
	public BigDecimal getWeekdayNormal() {
		return weekdayNormal;
	}
	public BigDecimal getWeekenddayNormal() {
		return weekenddayNormal;
	}
	public BigDecimal getWeekdayLoyalty() {
		return weekdayLoyalty;
	}
	public BigDecimal getTotalNormal() {
		return totalNormal;
	}
	public BigDecimal getTotalLoyalty() {
		return totalLoyalty;
	}
	public void setModel(ModelDto model) {
		this.model = model;
	}
	public void setManufacturer(ManufacturerDto manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public void setYearFuel(YearDto yearFuel) {
		this.yearFuel = yearFuel;
	}
	public void setWeekdayNormal(BigDecimal weekdayNormal) {
		this.weekdayNormal = weekdayNormal;
	}
	public void setWeekenddayNormal(BigDecimal weekenddayNormal) {
		this.weekenddayNormal = weekenddayNormal;
	}
	public void setWeekdayLoyalty(BigDecimal weekdayLoyalty) {
		this.weekdayLoyalty = weekdayLoyalty;
	}
	public void setTotalNormal(BigDecimal totalNormal) {
		this.totalNormal = totalNormal;
	}
	public void setTotalLoyalty(BigDecimal totalLoyalty) {
		this.totalLoyalty = totalLoyalty;
	}
	public BigDecimal getWeekenddayLoyalty() {
		return weekenddayLoyalty;
	}
	public void setWeekenddayLoyalty(BigDecimal weekenddayLoyalty) {
		this.weekenddayLoyalty = weekenddayLoyalty;
	}
	public Long getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
