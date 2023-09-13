package com.lucasdsf.api.vechiclerental.domains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdsf.api.vechiclerental.domains.entities.ModelVehicles;

@Repository
public interface ModelRepository extends JpaRepository<ModelVehicles, Long>{
}
