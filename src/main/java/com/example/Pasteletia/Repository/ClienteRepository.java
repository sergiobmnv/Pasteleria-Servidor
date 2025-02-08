package com.example.Pasteletia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Pasteletia.Entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
	

}
