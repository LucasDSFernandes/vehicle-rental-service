package com.lucasdsf.api.vechiclerental.domains.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbg_marca_veiculo")
public class ManufactoreVehicles implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_marca_veiculo")
	private Long id;
	
	@Column(name="ds_marca", nullable = false)
	private String description;

	@Column(name="cd_integracao", nullable = false)
	private String codeIntegration;
	
	@Column(name="cd_ordem_integracao", nullable = true)
	private String codeIntegrationOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCodeIntegrationOrder() {
		return codeIntegrationOrder;
	}

	public void setCodeIntegrationOrder(String codeIntegrationOrder) {
		this.codeIntegrationOrder = codeIntegrationOrder;
	}
}
