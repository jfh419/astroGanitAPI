package com.astroganit.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.astroganit.api.entities.DailyHoroscope;
import com.astroganit.api.payload.DailyHorosocpeSentence;
@Repository
public interface DailHoroscopeRepository extends JpaRepository<DailyHoroscope, Integer>{

	public DailyHoroscope findBySequenceNoAndSentenceId(int seq,int sId);
	
	@Query("Select new com.astroganit.api.payload.DailyHorosocpeSentence(DH.sentence) From DailyHoroscope DH where DH.sequenceNo=:seq and DH.sentenceId=:sId")
	public DailyHorosocpeSentence getSentence(int seq,int sId);
	
}
