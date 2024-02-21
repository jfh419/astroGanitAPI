package com.astroganit.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astroganit.api.entities.OTP;

public interface OTPRepo extends JpaRepository<OTP, Integer> {
	
	Optional<OTP> findByMobileAndOtp(String mobile,String otp);
	
	Optional<OTP> findByMobile(String mobile);

}
