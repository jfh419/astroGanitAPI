package com.astroganit.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dailyhoroscope")
public class DailyHoroscope {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Sentence_Id")
	private int sentenceId;
	
	@Column(name="Sequence_No")
	private int sequenceNo;
	
	@Column(name="Sentence")
	private String sentence;
	
	@Column(name="Lang_Code")
	private int langCode;

	public DailyHoroscope(int id, int sentenceId, int sequenceNo, String sentence, int langCode) {
		super();
		this.id = id;
		this.sentenceId = sentenceId;
		this.sequenceNo = sequenceNo;
		this.sentence = sentence;
		this.langCode = langCode;
	}

	public DailyHoroscope(String sentence) {
		super();
		this.sentence = sentence;
	}

	public DailyHoroscope() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSentenceId() {
		return sentenceId;
	}

	public void setSentenceId(int sentenceId) {
		this.sentenceId = sentenceId;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public int getLangCode() {
		return langCode;
	}

	public void setLangCode(int langCode) {
		this.langCode = langCode;
	}
	
	

}
