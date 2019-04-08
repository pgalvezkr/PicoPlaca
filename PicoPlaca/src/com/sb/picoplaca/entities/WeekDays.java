package com.sb.picoplaca.entities;

public enum WeekDays {

	MONDAY(1, 2), TUESDAY(3, 4), WEDNESDAY(5, 6), THURSDAY(7, 8), FRIDAY(9, 0);

	private int[] digitsNumber;
	
	private WeekDays(int... digitsNumber) {
		this.digitsNumber = digitsNumber;
	}

	public boolean isTheDay (int digit) {		
		boolean findDay= false;
		for (int i : digitsNumber) {
			if (i== digit) 
				findDay= true;
		}
		return findDay;
	}
}
