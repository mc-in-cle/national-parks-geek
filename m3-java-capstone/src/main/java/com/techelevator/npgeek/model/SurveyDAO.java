package com.techelevator.npgeek.model;

import java.util.Map;

public interface SurveyDAO {

	public void save(Survey survey);
	
	public Map<Park,Integer> surveyResults();
}
