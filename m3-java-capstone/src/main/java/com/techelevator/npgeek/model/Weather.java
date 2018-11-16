package com.techelevator.npgeek.model;

public class Weather {

	private String parkCode;
	private int forecastDay;
	private int low;
	private int high;
	private String forecast;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getForecastDay() {
		return forecastDay;
	}

	public void setForecastDay(int forecastDay) {
		this.forecastDay = forecastDay;
	}

	public int getLow(String scale) {
		if (scale.equalsIgnoreCase("c")) {
			int lowC = (int) (((low - 32) * 5) / 9.0);
			return lowC;
		} else {
			return low;
		}
	}

	public void setLowF(int low) {
		this.low = low;
	}

	public int getHigh(String scale) {
		if (scale.equalsIgnoreCase("c")) {
			int highC = (int) (((high - 32) * 5) / 9.0);
			return highC;
		} else {
			return high;
		}
	}

	public void setHighF(int high) {
		this.high = high;
	}


	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getMessage() {
		String message = "";
		if (forecast.equals("snow")) {
			message = message + "Forecast calls for snow. You should pack snowshoes. ";
		}
		if (forecast.equals("rain")) {
			message = message + "Forecast calls for rain. You should pack rain gear and wear waterproof shoes. ";
		}
		if (forecast.equals("thunderstorm")) {
			message = message + "Forcast calls for thunderstorms. You should seek "
					+ "shelter and avoid hiking on exposed ridges. ";
		}
		if (forecast.equals("sunny")) {
			message = message + "Forecast calls for sunshine. You should pack sunblock. ";
		}
		if (high > 75) {
			message = message + "It's gonna be a hot one. Make sure to bring an extra gallon of water. ";
		}
		if (high - low > 20) {
			message = message + "Temperature will fluctuate. Make sure to wear breathable layers. ";
		}
		if (low < 20) {
			message = message + "Beware, it's cold outside! Exercise caution when exposed to frigid temperatures. ";
		}
		return message;
	}
}
