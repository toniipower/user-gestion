package com.arelance.gestor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arelance.gestor.entities.Role;

@Repository
public interface RoleRespository extends JpaRepository<Role, Long> {
    
}
