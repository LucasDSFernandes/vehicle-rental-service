package com.lucasdsf.api.vechiclerental.domains.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lucasdsf.api.vechiclerental.converter.BooleanToStringConverter;

@Entity
@Table(name = "tbg_usuario")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="fg_fidelidade", nullable = false)
	@Convert(converter = BooleanToStringConverter.class)
	private boolean fgLoyalty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_veiculos" , nullable = false)
	private Vehicle vehicle;	

	public boolean isFgLoyalty() {
		return fgLoyalty;
	}
	public void setFgLoyalty(boolean fgLoyalty) {
		this.fgLoyalty = fgLoyalty;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}