package com.lucasdsf.api.vechiclerental.integration.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntegrationFipePriceResponse extends IntegrationFipeResponse{
	@JsonProperty("fipe_name")
	private String fipeName;
	@JsonProperty("fipe_codigo")
	private String fipeCodigo;
	private String combustivel;
	@JsonProperty("ano_modelo")
	private String anoModelo;
	@JsonProperty("id")
	private String idIntegrationPrice;
	private String preco;		
	private BigDecimal time;		
	private String veiculo;	
	private String referencia;
	
	public String getFipeName() {
		return fipeName;
	}
	public void setFipeName(String fipeName) {
		this.fipeName = fipeName;
	}
	public String getFipeCodigo() {
		return fipeCodigo;
	}
	public void setFipeCodigo(String fipeCodigo) {
		this.fipeCodigo = fipeCodigo;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getIdIntegrationPrice() {
		return idIntegrationPrice;
	}
	public void setIdIntegrationPrice(String idIntegrationPrice) {
		this.idIntegrationPrice = idIntegrationPrice;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public BigDecimal getTime() {
		return time;
	}
	public void setTime(BigDecimal time) {
		this.time = time;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}	
}
