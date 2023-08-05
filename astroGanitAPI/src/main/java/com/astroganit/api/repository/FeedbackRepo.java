package com.astroganit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astroganit.api.entities.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}
