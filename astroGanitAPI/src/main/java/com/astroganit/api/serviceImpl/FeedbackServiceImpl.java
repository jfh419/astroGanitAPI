package com.astroganit.api.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astroganit.api.entities.Feedback;
import com.astroganit.api.payload.FeedbackDto;
import com.astroganit.api.repository.FeedbackRepo;
import com.astroganit.api.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private ModelMapper mm;
	@Autowired
	private FeedbackRepo feedbackRepo;
	@Override
	public FeedbackDto createFeedBack(FeedbackDto feedbackDto) {
		Feedback feedback = this.mm.map(feedbackDto, Feedback.class);
		feedback.setCreatedDate(new Date());
		Feedback saveFeedback = this.feedbackRepo.save(feedback);
		return this.mm.map(saveFeedback, FeedbackDto.class);
	}

}
