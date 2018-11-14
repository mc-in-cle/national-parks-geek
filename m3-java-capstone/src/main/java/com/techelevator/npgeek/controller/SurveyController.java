package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.JdbcSurveyDAO;
import com.techelevator.npgeek.model.Survey;

@Controller
public class SurveyController {
	
	@Autowired
	JdbcSurveyDAO surveyDAO;
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey() {
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurvey(@RequestParam String parkCode, String email, String state, String activityLevel) {
		Survey survey = new Survey();
		survey.setParkCode(parkCode);
		survey.setEmail(email);
		survey.setState(state);
		survey.setActivityLevel(activityLevel);
		surveyDAO.save(survey);
		return "redirect:/surveyResults";
	}
	

}
