package com.lucasdsf.api.vechiclerental.rest.resquest;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RentalVehicleRequest {
	private LocalDate initialDate;
	private LocalDate endDate;
	private String email;
	private BigDecimal priceAmount;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(BigDecimal priceAmount) {
		this.priceAmount = priceAmount;
	}
	public LocalDate getInitialDate() {
		return initialDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
