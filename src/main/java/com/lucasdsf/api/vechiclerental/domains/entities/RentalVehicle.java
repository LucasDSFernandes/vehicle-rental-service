package com.lucasdsf.api.vechiclerental.domains.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "tbg_aluguel")
public class RentalVehicle implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_aluguel")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario" , nullable = false)
	private User user;
	
	@Column(name="qt_dias_alugado" , nullable = false)
	private Long amountDaysRented;

	@Column(name="preco_alugel" , nullable = false)
	private BigDecimal price;
	
	@Column(name="dt_init_aluguel" , nullable = false)
	private LocalDate dtStartRental;
	
	@Column(name="dt_fin_aluguel" , nullable = false)
	private LocalDate dtEndRental;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDtStartRental() {
		return dtStartRental;
	}

	public void setDtStartRental(LocalDate dtStartRental) {
		this.dtStartRental = dtStartRental;
	}

	public LocalDate getDtEndRental() {
		return dtEndRental;
	}

	public void setDtEndRental(LocalDate dtEndRental) {
		this.dtEndRental = dtEndRental;
	}

	public Long getAmountDaysRented() {
		return amountDaysRented;
	}

	public void setAmountDaysRented(Long amountDaysRented) {
		this.amountDaysRented = amountDaysRented;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
