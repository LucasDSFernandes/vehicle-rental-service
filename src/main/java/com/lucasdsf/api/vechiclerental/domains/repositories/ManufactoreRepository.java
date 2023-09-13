package com.lucasdsf.api.vechiclerental.domains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdsf.api.vechiclerental.domains.entities.ManufactoreVehicles;

@Repository
public interface ManufactoreRepository extends JpaRepository<ManufactoreVehicles, Long>{
}
