package com.lucasdsf.api.vechiclerental.builder;

import java.util.Optional;

import com.lucasdsf.api.vechiclerental.domains.entities.User;
import com.lucasdsf.api.vechiclerental.domains.entities.Vehicle;

public class UserEntityBuilder {
	private String email;
	private boolean fgLoyalty;
	private Vehicle vehicle;	
	
	public static UserEntityBuilder userBuilder() {
		return new UserEntityBuilder();
	}
	
	public UserEntityBuilder fgLoyalty(boolean fgLoyalty) {
		this.fgLoyalty = fgLoyalty;
		return this;
	}
	public UserEntityBuilder email(String email) {
		this.email = email;
		return this;
	}
	public UserEntityBuilder vehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	
	public User build() {
		User user = new User();
		Optional.ofNullable(this.email)
			.ifPresent(email -> user.setEmail(email));
		Optional.ofNullable(this.fgLoyalty)
			.ifPresent(fgLoyalty -> user.setFgLoyalty(fgLoyalty));
		Optional.ofNullable(this.vehicle)
			.ifPresent(vehicle -> user.setVehicle(vehicle));
		return user;
	}

}


