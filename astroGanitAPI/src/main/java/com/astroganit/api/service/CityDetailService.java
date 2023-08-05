package com.astroganit.api.service;

import java.util.List;

import com.astroganit.api.payload.CityDetailsDto;

public interface CityDetailService {

	List<CityDetailsDto> getCities(String place);
}
