package com.astroganit.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astroganit.api.entities.User;


public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
