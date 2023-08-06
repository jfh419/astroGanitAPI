package com.astroganit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.astroganit.api.entities.Suvichar;

public interface SuvicharRepo extends JpaRepository<Suvichar, Integer>{

	@Query(nativeQuery = true,value = "select * from ( SELECT * FROM suvichar where  day_value=:daysValue and lang_code=:langCode union SELECT * FROM suvichar where  day_value!=:daysValue and lang_code=:langCode ) as A  where A.day_night = :dayNightValue union select * from ( SELECT * FROM suvichar where  day_value=:daysValue and lang_code=:langCode union SELECT * FROM suvichar where  day_value!=:daysValue and lang_code=:langCode ) as A  where A.day_night !=:dayNightValue")
	public List<Suvichar> getURL(@Param("dayNightValue") String dayNightValue,@Param("daysValue") String daysValue,@Param("langCode") String langCode);

}
