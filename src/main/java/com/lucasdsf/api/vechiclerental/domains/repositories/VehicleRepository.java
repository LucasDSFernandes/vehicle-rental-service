package com.lucasdsf.api.vechiclerental.domains.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucasdsf.api.vechiclerental.domains.entities.Vehicle;
import com.lucasdsf.api.vechiclerental.enums.CategoryVehicleEnums;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByTypeCategory (CategoryVehicleEnums typeCategory);
	
	@Query(value="select v from Vehicle v where v.dateInclusion between ?1 and ?2 order by v.weekdayRentalPrice, v.typeCategory asc")
	List<Vehicle> findByDateInclusionBetween(LocalDate dateInit, LocalDate dateEnd);
}
