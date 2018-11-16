package com.techelevator.npgeek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.JdbcParkDAO;
import com.techelevator.npgeek.model.JdbcSurveyDAO;
import com.techelevator.npgeek.model.Survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Controller
public class SurveyController {
	
	@Autowired
	JdbcSurveyDAO surveyDAO;
	
	@Autowired
	JdbcParkDAO parksDAO;
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurvey(ModelMap model) {
		String[] usStates = {
				"Alabama",
				"Alaska",
				"Arizona",
				"Arkansas",
				"California",
				"Colorado",
				"Connecticut",
				"Delaware",
				"District of Columbia",
				"Florida",
				"Georgia",
				"Hawaii",
				"Idaho",
				"Illinois",
				"Indiana",
				"International",
				"Iowa",
				"Kansas",
				"Kentucky",
				"Louisiana",
				"Maine",
				"Maryland",
				"Massachusetts",
				"Michigan",
				"Minnesota",
				"Mississippi",
				"Missouri",
				"Montana",
				"Nebraska",
				"Nevada",
				"New Hampshire",
				"New Jersey",
				"New Mexico",
				"New York",
				"North Carolina",
				"North Dakota",
				"Ohio",
				"Oklahoma",
				"Oregon",
				"Other US Territory",
				"Pennsylvania",
				"Puerto Rico",
				"Rhode Island",
				"South Carolina",
				"South Dakota",
				"Tennessee",
				"Texas",
				"Utah",
				"Vermont",
				"Virginia",
				"Washington",
				"West Virginia",
				"Wisconsin",
				"Wyoming"

		};
		model.addAttribute("usStates", usStates);
		model.addAttribute("parksList", parksDAO.getAllParks());
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurvey(@Valid @ModelAttribute("survey") Survey formValues, BindingResult result,
			RedirectAttributes flash
	) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			flash.addFlashAttribute("survey", formValues);
			return "redirect:/survey";
		}
		surveyDAO.save(formValues);
		return "redirect:/surveyResults";
	}
	

}
