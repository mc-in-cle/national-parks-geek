package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDAO implements WeatherDAO{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherForPark(String parkCode) {
		List<Weather> weatherForecast = new ArrayList<Weather>();
		String sqlQuery = "SELECT * FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, parkCode);
		while (results.next()) {
			Weather w = getWeatherFromRow(results);
			weatherForecast.add(w);
		}
		return weatherForecast;
	}
	
	private Weather getWeatherFromRow(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setForecastDay(results.getInt("fivedayforecastvalue"));
		weather.setLowF(results.getInt("low"));
		weather.setHighF(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));
		return weather;
	}

}
