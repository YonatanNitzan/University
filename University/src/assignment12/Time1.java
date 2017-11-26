package assignment12;

public class Time1 {

	private int _hour, _minute;

	/**
	 * Constructor sets given hour and minute within range.
	 * 
	 * @param h
	 *            - Hour
	 * @param m
	 *            - Minute
	 */
	public Time1(int h, int m) {
		// Sets the hour within a 0-23 range
		if (h > 23)
			_hour = 23;
		else if (h < 0)
			_hour = 0;
		else
			_hour = h;

		// Sets the minutes within a 0-59 range
		if (m > 59)
			_minute = 59;
		else if (m < 0)
			_minute = 0;
		else
			_minute = m;
	}

	/**
	 * Set the instance time as a given time.
	 * 
	 * @param t
	 *            - Time to copy.
	 */
	public Time1(Time1 t) {
		_hour = t.getHour();
		_minute = t.getMinute();
	}

	/**
	 * Gets the hour of instance time.
	 * 
	 * @return Number of hours.
	 */
	public int getHour() {
		return _hour;
	}

	/**
	 * Sets the hour of instance time.
	 * 
	 * @param num
	 *            - hour
	 */
	public void setHour(int num) {
		if (num >= 0 && num <= 23)
			_hour = num;
	}

	/**
	 * Gets the minute of instance time.
	 * 
	 * @return Number of minutes.
	 */
	public int getMinute() {
		return _minute;
	}

	/**
	 * Sets the minute of instance time.
	 * 
	 * @param num
	 *            - minute
	 */
	public void setMinute(int num) {
		if (num >= 0 && num <= 59)
			_minute = num;
	}

	/**
	 * Displays the instance time in hh:mm format.
	 */
	public String toString() {
		if (_hour < 10) {
			if (_minute < 10)
				// Displays time when both values are single digit
				return "0" + _hour + ":" + "0" + _minute;
			else
				// Displays time when hour value is single digit
				return "0" + _hour + ":" + _minute;
		}

		else {
			if (_minute < 10)
				// Displays time when minute value is single digit
				return _hour + ":" + "0" + _minute;
			else
				// Displays time when both values are double digit
				return _hour + ":" + _minute;
		}
	}

	/**
	 * Calculates how many minutes passed from midnight until instance time.
	 * 
	 * @return Number of minutes.
	 */
	public int minFromMidnight() {
		return (_hour * 60 + _minute);
	}

	/**
	 * Checks whether instance time and given time are equal.
	 * 
	 * @param other
	 *            - The time to be tested
	 * @return True if times are equal.
	 */
	public boolean equals(Time1 other) {
		return ((_hour == other.getHour()) && (_minute == other.getMinute()));
	}

	/**
	 * Checks whether instance time is before given time.
	 * 
	 * @param other
	 *            - The time to be tested
	 * @return True if instance time is sooner.
	 */
	public boolean before(Time1 other) {
		return (minFromMidnight() < other.minFromMidnight());
	}

	/**
	 * Checks whether instance time is after given time.
	 * 
	 * @param other
	 *            - The time to be tested
	 * @return True if instance time is later.
	 */
	public boolean after(Time1 other) {
		return !before(other);
	}

	/**
	 * Calculates the difference between instance time and given time in minutes.
	 * 
	 * @param other
	 *            - Time to be tested
	 * @return Number of minutes.
	 */
	public int difference(Time1 other) {
		return (minFromMidnight() - other.minFromMidnight());
	}
}
