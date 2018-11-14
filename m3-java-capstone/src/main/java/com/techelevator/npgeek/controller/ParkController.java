package com.techelevator.npgeek.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.JdbcParkDAO;
import com.techelevator.npgeek.model.JdbcWeatherDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

@Controller
@SessionAttributes("tempPreference")
public class ParkController {
	
	@Autowired
	private JdbcParkDAO parkDAO;
	private JdbcWeatherDAO weatherDAO;
	
	@RequestMapping("/")
	public String showParksOverview(ModelMap model) {
		List<Park> parksList = parkDAO.getAllParks();
		model.addAttribute("parksList", parksList);
		return "home";
	}
	
	@RequestMapping("/parkDetails")
	public String showParkDetails(ModelMap model, @RequestParam String parkCode) {
		Park park = parkDAO.getPark(parkCode);
		List<Weather> weatherForecast = weatherDAO.getWeatherForPark(parkCode);
		model.addAttribute("park", park);
		model.addAttribute("weatherForecast", weatherForecast);
		return "parkDetails";
	}

	@RequestMapping("/surveyResults")
	public String displaySurveyResults(ModelMap model) {
		Map<Park, Integer> surveyMap = parkDAO.surveyResults();
		model.addAttribute("surveyMap",surveyMap);
		return "surveyResults";
	}
	
	@RequestMapping(path="/toggleTemp", method=RequestMethod.POST)
	public String changeTemp (HttpServletRequest request, @RequestParam String format) {
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
	

}
