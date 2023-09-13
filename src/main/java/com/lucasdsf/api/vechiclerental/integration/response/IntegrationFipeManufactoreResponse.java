package com.lucasdsf.api.vechiclerental.integration.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntegrationFipeManufactoreResponse extends IntegrationFipeResponse{
	private Integer order;
	@JsonProperty("fipe_name")
	private String fipeName;
	@JsonProperty("id")
	private Integer idIntegrationBrand;
	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getFipeName() {
		return fipeName;
	}
	public void setFipeName(String fipeName) {
		this.fipeName = fipeName;
	}
	public Integer getIdIntegrationBrand() {
		return idIntegrationBrand;
	}
	public void setIdIntegrationBrand(Integer idIntegrationBrand) {
		this.idIntegrationBrand = idIntegrationBrand;
	}
}
