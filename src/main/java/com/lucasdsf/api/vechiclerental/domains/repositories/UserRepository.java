package com.lucasdsf.api.vechiclerental.domains.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucasdsf.api.vechiclerental.domains.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByEmail(String email);
}
