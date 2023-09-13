package com.lucasdsf.api.vechiclerental.domains.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucasdsf.api.vechiclerental.domains.entities.RentalVehicle;
import com.lucasdsf.api.vechiclerental.domains.entities.Vehicle;

@Repository
public interface RentalRepository extends CrudRepository<RentalVehicle, Long>{
		Vehicle findByDtStartRentalAndDtEndRental (String dtStartRental, String dtEndRental);
}
