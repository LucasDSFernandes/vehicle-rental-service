package com.lucasdsf.api.vechiclerental.integration.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntegrationFipeYearResponse extends IntegrationFipeResponse{
	private String veiculo;
	@JsonProperty("fipe_marca")
	private String fipeMarca;
	@JsonProperty("fipe_codigo")
	private String fipeCodigo;
	@JsonProperty("id")
	private String idIntegrationYear;
	
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getFipeMarca() {
		return fipeMarca;
	}
	public void setFipeMarca(String fipeMarca) {
		this.fipeMarca = fipeMarca;
	}
	public String getFipeCodigo() {
		return fipeCodigo;
	}
	public void setFipeCodigo(String fipeCodigo) {
		this.fipeCodigo = fipeCodigo;
	}
	public String getIdIntegrationYear() {
		return idIntegrationYear;
	}
	public void setIdIntegrationYear(String idIntegrationYear) {
		this.idIntegrationYear = idIntegrationYear;
	}
}
