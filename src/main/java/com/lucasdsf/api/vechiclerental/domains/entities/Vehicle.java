package com.lucasdsf.api.vechiclerental.domains.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lucasdsf.api.vechiclerental.converter.BooleanToStringConverter;
import com.lucasdsf.api.vechiclerental.enums.CategoryVehicleEnums;

@Entity
@Table(name = "veiculos")
public class Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_veiculos")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modelo_veiculo", nullable = false)
	private ModelVehicles model;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tp_categoria", nullable = false)
	private CategoryVehicleEnums typeCategory;
	
	@Column(name = "combustivel", nullable = true)
	private String descriptionFuel;
	
	@Column(name = "dt_inclusao", nullable = false)
	private LocalDate dateInclusion;

	@Column(name = "fg_alugado")
	@Convert(converter = BooleanToStringConverter.class)
	private boolean fgRental;
	
	@Column(name = "qt_tempo_rodado", nullable = true)
	private BigDecimal runTime;
	
	@Column(name="preco_fds_aluguel" , nullable = false)
	private BigDecimal weekdayRentalPrice;
	
	@Column(name="preco_dia_alugel" , nullable = false)
	private BigDecimal weekendayRentalPrice;
	
	@Column(name="preco_fds_fidel" , nullable = false)
	private BigDecimal weekdayRentelPriceLoyalty;
	
	@Column(name="preco_dia_fidel" , nullable = false)
	private BigDecimal weekendayRentelPriceLoyalty;
	
	
	public BigDecimal getWeekdayRentalPrice() {
		return weekdayRentalPrice;
	}

	public void setWeekdayRentalPrice(BigDecimal weekdayRentalPrice) {
		this.weekdayRentalPrice = weekdayRentalPrice;
	}

	public BigDecimal getWeekendayRentalPrice() {
		return weekendayRentalPrice;
	}

	public void setWeekendayRentalPrice(BigDecimal weekendayRentalPrice) {
		this.weekendayRentalPrice = weekendayRentalPrice;
	}

	public BigDecimal getWeekdayRentelPriceLoyalty() {
		return weekdayRentelPriceLoyalty;
	}

	public void setWeekdayRentelPriceLoyalty(BigDecimal weekdayRentelPriceLoyalty) {
		this.weekdayRentelPriceLoyalty = weekdayRentelPriceLoyalty;
	}

	public BigDecimal getWeekendayRentelPriceLoyalty() {
		return weekendayRentelPriceLoyalty;
	}

	public void setWeekendayRentelPriceLoyalty(BigDecimal weekendayRentelPriceLoyalty) {
		this.weekendayRentelPriceLoyalty = weekendayRentelPriceLoyalty;
	}

	public Long getId() {
		return id;
	}

	public ModelVehicles getModel() {
		return model;
	}

	public void setModel(ModelVehicles model) {
		this.model = model;
	}

	public CategoryVehicleEnums getTypeCategory() {
		return typeCategory;
	}

	public void setTypeCategory(CategoryVehicleEnums typeCategory) {
		this.typeCategory = typeCategory;
	}

	public String getDescriptionFuel() {
		return descriptionFuel;
	}

	public void setDescriptionFuel(String descriptionFuel) {
		this.descriptionFuel = descriptionFuel;
	}

	public BigDecimal getRunTime() {
		return runTime;
	}

	public void setRunTime(BigDecimal runTime) {
		this.runTime = runTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFgRental() {
		return fgRental;
	}

	public void setFgRental(boolean fgRental) {
		this.fgRental = fgRental;
	}

	public LocalDate getDateInclusion() {
		return dateInclusion;
	}

	public void setDateInclusion(LocalDate dateInclusion) {
		this.dateInclusion = dateInclusion;
	}

}
