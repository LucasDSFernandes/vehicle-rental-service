package com.lucasdsf.api.vechiclerental.domains.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbg_modelo_veiculo")
public class ModelVehicles implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_modelo_veiculo")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_marca_veiculo", nullable = false)
	private ManufactoreVehicles brand;
	
	@Column(name="ds_modelo", nullable = false)
	private String description;

	@Column(name = "ano_fuel", nullable = false)
	private String modelYear;
	
	@Column(name = "cd_integracao_year", nullable = false)
	private String modelYearId;

	@Column(name="cd_integracao", nullable = true)
	private String codeIntegration;

	public Long getId() {	
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ManufactoreVehicles getBrand() {
		return brand;
	}

	public void setBrand(ManufactoreVehicles brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCodeIntegration() {
		return codeIntegration;
	}

	public void setCodeIntegration(String codeIntegration) {
		this.codeIntegration = codeIntegration;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getModelYearId() {
		return modelYearId;
	}

	public void setModelYearId(String modelYearId) {
		this.modelYearId = modelYearId;
	}
}
