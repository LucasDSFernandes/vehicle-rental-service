package com.lucasdsf.api.vechiclerental.rest.response;

import java.util.List;

import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeManufactoreResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeModelResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipePriceResponse;
import com.lucasdsf.api.vechiclerental.integration.response.IntegrationFipeYearResponse;

public class IntegrationResponse {
	List<IntegrationFipeManufactoreResponse> manufactore;
	List<IntegrationFipeModelResponse> model;
	List<IntegrationFipeYearResponse> years;
	IntegrationFipePriceResponse price;
	
	public List<IntegrationFipeManufactoreResponse> getManufactore() {
		return manufactore;
	}
	public List<IntegrationFipeModelResponse> getModel() {
		return model;
	}
	public List<IntegrationFipeYearResponse> getYears() {
		return years;
	}
	public IntegrationFipePriceResponse getPrice() {
		return price;
	}
	public void setManufactore(List<IntegrationFipeManufactoreResponse> manufactore) {
		this.manufactore = manufactore;
	}
	public void setModel(List<IntegrationFipeModelResponse> model) {
		this.model = model;
	}
	public void setYears(List<IntegrationFipeYearResponse> years) {
		this.years = years;
	}
	public void setPrice(IntegrationFipePriceResponse price) {
		this.price = price;
	}
}
