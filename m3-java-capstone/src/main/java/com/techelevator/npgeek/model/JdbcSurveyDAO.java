package com.techelevator.npgeek.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDAO implements SurveyDAO{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Survey survey) {
		String sqlQuery = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) "
				+ "VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlQuery, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
	}

}
