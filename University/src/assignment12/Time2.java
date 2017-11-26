package assignment12;

public class Time2 {

	private int _minFromMidnight;

	/**
	 * Constructor sets given hour and minute within range.
	 * 
	 * @param h
	 *            - Hour
	 * @param m
	 *            - Minute
	 */
	public Time2(int h, int m) {
		// Sets values out of range to 0
		if (h < 0 || h > 23)
			h = 0;
		if (h < 0 || m > 59)
			m = 0;

		// Calculates the minutes from midnight to given time values
		_minFromMidnight = h * 60 + m;
	}

	/**
	 * Set the instance time as a given time.
	 * 
	 * @param t
	 *            - Time to copy.
	 */
	public Time2(Time2 t) {
		_minFromMidnight = t.getHour() + t.getMinute();
	}

	/**
	 * Calculates the hour value of the instance time.
	 * 
	 * @return Number of hours.
	 */
	public int getHour() {
		return (_minFromMidnight / 60);
	}

	/**
	 * Calculates the minutes from midnight using given hour value and instance
	 * minute value.
	 * 
	 * @param num
	 *            - Hour
	 */
	public void setHour(int num) {
		if (num >= 0 && num <= 23)
			_minFromMidnight = getMinute() + num * 60;
	}

	/**
	 * Calculates the minute value of the instance time.
	 * 
	 * @return Number of minutes.
	 */
	public int getMinute() {
		return (_minFromMidnight % 60);
	}

	/**
	 * Calculates the minutes from midnight using instance hour value and given
	 * minute value.
	 * 
	 * @param num
	 *            - Minute
	 */
	public void setMinute(int num) {
		if (num >= 0 && num <= 59)
			_minFromMidnight += (num - getMinute());
	}

	/**
	 * Displays the instance time in hh:mm format.
	 */
	public String toString() {
		if (getHour() < 10) {
			if (getMinute() < 10)
				// Displays time when both values are single digit
				return "0" + getHour() + ":" + "0" + getMinute();
			else
				// Displays time when hour value is single digit
				return "0" + getHour() + ":" + getMinute();
		}

		else {
			if (getMinute() < 10)
				// Displays time when minute value is single digit
				return getHour() + ":" + "0" + getMinute();
			else
				// Displays time when both values are double digit
				return getHour() + ":" + getMinute();
		}
	}

	/**
	 * Returns how many minutes passed from midnight until instance time.
	 * 
	 * @return Number of minutes.
	 */
	public int minFromMidnight() {
		return _minFromMidnight;
	}

	/**
	 * Checks whether instance time and given time are equal.
	 * 
	 * @param other
	 *            - The time to be tested
	 * @return True if times are equal.
	 */
	public boolean equals(Time2 other) {
		return (_minFromMidnight == other.minFromMidnight());
	}

	/**
	 * Checks whether instance time is before given time.
	 * 
	 * @param other
	 *            - The time to be tested
	 * @return True if instance time is sooner.
	 */
	public boolean before(Time2 other) {
		return (_minFromMidnight < other.minFromMidnight());
	}

	/**
	 * Checks whether instance time is after given time.
	 * 
	 * @param other
	 *            - The time to be tested
	 * @return True if instance time is later.
	 */
	public boolean after(Time2 other) {
		return !before(other);
	}

	/**
	 * Calculates the difference between instance time and given time in minutes.
	 * 
	 * @param other
	 *            - Time to be tested
	 * @return Number of minutes.
	 */
	public int difference(Time2 other) {
		return (_minFromMidnight - other.minFromMidnight());
	}
}
