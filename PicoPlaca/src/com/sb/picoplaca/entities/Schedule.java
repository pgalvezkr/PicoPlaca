package com.sb.picoplaca.entities;

import java.util.Calendar;

public class Schedule {

	private Calendar startTimeMoring;

	private Calendar endTimeMorning;

	private Calendar startTimeAfternoon;

	private Calendar endTimeAfternoon;

	public Schedule() {
		this.setTimeInTheAfternoon();
		this.setTimeInTheMoring();
	}

	private void setTimeInTheMoring() {
		this.startTimeMoring = Calendar.getInstance();
		this.endTimeMorning = Calendar.getInstance();

		this.startTimeMoring.set(Calendar.HOUR_OF_DAY, 7);
		this.startTimeMoring.set(Calendar.MINUTE, 0);

		this.endTimeMorning.set(Calendar.HOUR_OF_DAY, 9);
		this.endTimeMorning.set(Calendar.MINUTE, 30);
	}

	private void setTimeInTheAfternoon() {
		this.startTimeAfternoon = Calendar.getInstance();
		this.endTimeAfternoon = Calendar.getInstance();

		this.startTimeAfternoon.set(Calendar.HOUR_OF_DAY, 16);
		this.startTimeAfternoon.set(Calendar.MINUTE, 0);

		this.endTimeAfternoon.set(Calendar.HOUR_OF_DAY, 19);
		this.endTimeAfternoon.set(Calendar.MINUTE, 30);
	}
	
	public boolean validateSchedule (String hour, String minute) {
		Calendar timeC = Calendar.getInstance();
		timeC.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hour));
		timeC.set(Calendar.MINUTE, Integer.valueOf(minute));
		if (canRoadOnMorning(timeC) && canRoadOnAfternoon(timeC)) {
			return true;
		}else 
			return false;
		
	}
	
	private boolean canRoadOnMorning (Calendar time) {
		if (time.getTimeInMillis()>this.startTimeMoring.getTimeInMillis() &&
				time.getTimeInMillis()<this.endTimeMorning.getTimeInMillis()) {
			return false;
		}else
			return true;
	}
	
	private boolean canRoadOnAfternoon (Calendar time) {
		if (time.getTimeInMillis()>this.startTimeAfternoon.getTimeInMillis() &&
				time.getTimeInMillis()<this.endTimeAfternoon.getTimeInMillis()) {
			return false;
		}else
			return true;
	}
}
