package com.lucasdsf.api.vechiclerental.builder;

import java.math.BigDecimal;

import com.lucasdsf.api.vechiclerental.domains.model.CategoryDto;
import com.lucasdsf.api.vechiclerental.domains.model.ManufacturerDto;
import com.lucasdsf.api.vechiclerental.domains.model.ModelDto;
import com.lucasdsf.api.vechiclerental.domains.model.VehicleDto;
import com.lucasdsf.api.vechiclerental.domains.model.YearDto;

public class VehicleDtoBuilder {
	private Long idVehicle;
	private String modelId;
	private String modelName;
	private String manufactorerId;
	private String manufactoreName;
	private Integer categoryId;
	private String category;
	private String yearFuelId;
	private String yearFuel;
	private BigDecimal weekdayNormal;
	private BigDecimal weekenddayNormal;
	private BigDecimal weekdayLoyalty;
	private BigDecimal weekenddayLoyalty;
	private BigDecimal totalNormal;
	private BigDecimal totalLoyalty;
	
	public static VehicleDtoBuilder veihicleBuilder() {
		return new VehicleDtoBuilder();
	}
	
	public VehicleDtoBuilder idVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
		return this;
	}
	public VehicleDtoBuilder modelName(String modelName) {
		this.modelName = modelName;
		return this;
	}
	public VehicleDtoBuilder modelId(String modelId) {
		this.modelId = modelId;
		return this;
	}
	public VehicleDtoBuilder manufactoreName(String manufactoreName) {
		this.manufactoreName = manufactoreName;
		return this;
	}
	public VehicleDtoBuilder manufactorerId(String manufactorerId) {
		this.manufactorerId = manufactorerId;
		return this;
	}
	public VehicleDtoBuilder categoryId(Integer categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	public VehicleDtoBuilder category(String category) {
		this.category = category;
		return this;
	}
	public VehicleDtoBuilder yearFuelId(String yearFuelId) {
		this.yearFuelId = yearFuelId;
		return this;
	}
	public VehicleDtoBuilder yearFuel(String yearFuel) {
		this.yearFuel = yearFuel;
		return this;
	}
	public VehicleDtoBuilder weekdayNormal(BigDecimal weekdayNormal) {
		this.weekdayNormal = weekdayNormal;
		return this;
	}
	public VehicleDtoBuilder weekenddayNormal(BigDecimal weekenddayNormal) {
		this.weekenddayNormal = weekenddayNormal;
		return this;
	}
	public VehicleDtoBuilder weekdayLoyalty(BigDecimal weekdayLoyalty) {
		this.weekdayLoyalty = weekdayLoyalty;
		return this;
	}
	public VehicleDtoBuilder weekenddayLoyalty(BigDecimal weekenddayLoyalty) {
		this.weekenddayLoyalty = weekenddayLoyalty;
		return this;
	}
	public VehicleDtoBuilder totalLoyalty(BigDecimal totalLoyalty) {
		this.totalLoyalty = totalLoyalty;
		return this;
	}
	public VehicleDtoBuilder totalNormal(BigDecimal totalNormal) {
		this.totalNormal = totalNormal;
		return this;
	}
	public VehicleDto build() {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setIdVehicle(idVehicle);
		
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(categoryId);	
		categoryDto.setName(category);
		vehicle.setCategory(categoryDto);
		
		ManufacturerDto manufactorerDto = new ManufacturerDto();
		manufactorerDto.setId(manufactorerId);	
		manufactorerDto.setName(manufactoreName);
		vehicle.setManufacturer(manufactorerDto);
		
		ModelDto modelDto = new ModelDto();
		modelDto.setId(modelId);	
		modelDto.setName(modelName);
		vehicle.setModel(modelDto);
	
		YearDto yearDto = new YearDto();
		yearDto.setId(yearFuelId);	
		yearDto.setName(yearFuel);
		vehicle.setYearFuel(yearDto);		
		
		vehicle.setTotalLoyalty(totalLoyalty);
		vehicle.setTotalNormal(totalNormal);
		vehicle.setWeekdayLoyalty(weekdayLoyalty);
		vehicle.setWeekdayNormal(weekdayNormal);
		vehicle.setWeekenddayNormal(weekenddayNormal);
		vehicle.setWeekenddayLoyalty(weekdayLoyalty);
		vehicle.setWeekenddayLoyalty(weekenddayLoyalty);
		return vehicle;
	}
}