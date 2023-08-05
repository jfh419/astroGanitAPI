package com.astroganit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astroganit.api.entities.CityDetails;

public interface CityDetailsRepo extends JpaRepository<CityDetails, Integer> {

	List<CityDetails> findByPlaceStartsWith(String place);
}
