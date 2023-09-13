package com.lucasdsf.api.vechiclerental.integration.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntegrationFipeModelResponse extends IntegrationFipeResponse{
	private String marca;
	@JsonProperty("fipe_name")
	private String fipeName;
	@JsonProperty("fipe_marca")
	private String fipeMarca;
	@JsonProperty("id")
	private String idIntegrationModel;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getFipeMarca() {
		return fipeMarca;
	}
	public void setFipeMarca(String fipeMarca) {
		this.fipeMarca = fipeMarca;
	}
	public String getFipeName() {
		return fipeName;
	}
	public void setFipeName(String fipeName) {
		this.fipeName = fipeName;
	}
	public String getIdIntegrationModel() {
		return idIntegrationModel;
	}
	public void setIdIntegrationModel(String idIntegrationModel) {
		this.idIntegrationModel = idIntegrationModel;
	}
}
