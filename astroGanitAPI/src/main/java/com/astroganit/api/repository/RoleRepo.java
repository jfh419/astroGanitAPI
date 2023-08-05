package com.astroganit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astroganit.api.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
