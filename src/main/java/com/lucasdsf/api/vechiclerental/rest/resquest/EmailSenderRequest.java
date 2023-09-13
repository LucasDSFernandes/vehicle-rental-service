package com.lucasdsf.api.vechiclerental.rest.resquest;

import java.math.BigDecimal;
import java.util.List;

public class EmailSenderRequest {
	private List<String> recipients;
	private String category;
	private String email;
	private String manufacture;
	private String model;
	private String year;
	private BigDecimal price;
	private String dtInit;
	private String dtEnd;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDtInit() {
		return dtInit;
	}
	public void setDtInit(String dtInit) {
		this.dtInit = dtInit;
	}
	public String getDtEnd() {
		return dtEnd;
	}
	public void setDtEnd(String dtEnd) {
		this.dtEnd = dtEnd;
	}
	public List<String> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
