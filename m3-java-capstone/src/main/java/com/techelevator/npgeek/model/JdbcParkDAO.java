package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<Park>();
		String sqlSelectAllParks = "SELECT * FROM park ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			Park park = getParkFromRow(results);
			allParks.add(park);
		}
		return allParks;
	}

	@Override
	public Park getPark(String parkCode) {
		String sqlQuery = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, parkCode);
		Park park = null;
		if (results.next()) {
			park = getParkFromRow(results);
		}
		return park;
	}
	
	@Override
	public List<Park> surveyResults() {
		List<Park> surveyResults = new ArrayList<>();
		String sqlQuery = "SELECT park.*, count(*) as ct FROM "
				+ "park INNER JOIN survey_result ON park.parkcode = survey_result.parkcode "
				+ "GROUP BY park.parkcode ORDER BY ct DESC, parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
		while (results.next()) {
			int voteCount = results.getInt("ct");
			Park p = getParkFromRow(results);
			p.setVotes(voteCount);
			surveyResults.add(p);
		}
		return surveyResults;
	}
	
	private Park getParkFromRow(SqlRowSet results) {
		Park park = new Park();
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevation(results.getInt("elevationinfeet"));
		park.setTrailMiles(results.getFloat("milesoftrail"));
		park.setNumberOfCampsites(results.getInt("numberofcampsites"));
		park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitors(results.getInt("annualvisitorcount"));
		park.setQuote(results.getString("inspirationalquote"));
		park.setQuoteSource(results.getString("inspirationalquotesource"));
		park.setParkDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		
		return park;
	}
}
