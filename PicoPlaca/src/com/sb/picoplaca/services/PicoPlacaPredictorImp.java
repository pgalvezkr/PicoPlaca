package com.sb.picoplaca.services;

import java.util.Calendar;
import java.util.Date;

import com.sb.picoplaca.entities.Schedule;
import com.sb.picoplaca.entities.WeekDays;
import com.sb.picoplaca.exceptions.PicoPlacaException;
import com.sb.picoplaca.utils.Constants;

public class PicoPlacaPredictorImp implements PicoPlacaPredictor {

	@Override
	public boolean predictor(String plate, String date, String time) throws PicoPlacaException {
		int lastDigit = getLastDigitPlate(plate);
		if (lastDigit != Constants.ERROR_PLATE && validateDateFormat(date) && validateTimeFormat(time)) {
			Date dateD = new Date(date);
			Calendar dateC = Calendar.getInstance();
			dateC.setTime(dateD);
			if (evaluateDay(lastDigit, dateC)) {
				Schedule schedule = new Schedule();
				if (schedule.validateSchedule(this.getHours(time), this.getMinutes(time))) {
					System.out.println("You can be on the road");
				} else {
					throw new PicoPlacaException("HEY! YOU CAN NOT BE ON THE REOAD.");
				}
			} else {
				System.out.println("You don´t have pico y placa today.");
			}
		} else
			System.out.println("Incorrect plate, the format is AAA-1234.");
		return false;
	}

	private boolean validateDateFormat(String date) throws PicoPlacaException{
		boolean correctFormat = date.trim().matches(Constants.DATEFORMAT_PATTERN);
		if (!correctFormat)		
				throw new PicoPlacaException(//
						"The date format is incorrect. Please enter the date with the format: dd/mm/yyyy for example (08/04/2019)");		
		return correctFormat;
	}

	private boolean validateTimeFormat(String time) throws PicoPlacaException{
		boolean correctFormat = time.trim().matches(Constants.TIME24HOURS_PATTERN);
		if (!correctFormat)
			throw new PicoPlacaException(
					"The time format is incorrect. Please enter the time with the format: hh:mm for example (17:55)");
		return correctFormat;
	}

	private int getLastDigitPlate(String plate) {
		return (7 <= plate.length() && 8 >= plate.length())
				? Integer.parseInt(plate.substring(plate.length() - 1, plate.length()))
				: Constants.ERROR_PLATE;
	}

	private String getHours(String time) {
		String[] splitTimes = time.split(":");
		return splitTimes[0];
	}

	private String getMinutes(String time) {
		String[] splitTimes = time.split(":");
		return splitTimes[1];
	}

	private boolean evaluateDay(int lastDigit, Calendar nowDate) {
		boolean isTheDay = false;
		switch (nowDate.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			isTheDay = WeekDays.MONDAY.isTheDay(lastDigit);
			break;
		case 2:
			isTheDay = WeekDays.TUESDAY.isTheDay(lastDigit);
			break;
		case 3:
			isTheDay = WeekDays.WEDNESDAY.isTheDay(lastDigit);
			break;
		case 4:
			isTheDay = WeekDays.THURSDAY.isTheDay(lastDigit);
			break;
		case 5:
			isTheDay = WeekDays.FRIDAY.isTheDay(lastDigit);
			break;
		default:
			break;
		}
		return isTheDay;
	}

}
