package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

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
		
		return null;
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
