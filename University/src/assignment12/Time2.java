package assignment12;

public class Time2 {

	private int _minFromMidnight;

	public Time2(int h, int m) {
		if (h < 0 || h > 23)
			h = 0;
		if (h < 0 || m > 59)
			m = 0;

		_minFromMidnight = h * 60 + m;
	}

	public Time2(Time2 t) {
		_minFromMidnight = t.getHour() + t.getMinute();
	}

	public int getHour() {
		return (_minFromMidnight / 60);
	}

	public void setHour(int num) {
		if (num >= 0 && num <= 23)
			_minFromMidnight = getMinute() + num * 60;
	}

	public int getMinute() {
		return (_minFromMidnight % 60);
	}

	public void setMinute(int num) {
		if (num >= 0 && num <= 59)
			_minFromMidnight += (num - getMinute());
	}

	public String toString() {
		if (getHour() < 10) {
			if (getMinute() < 10)
				return "0" + getHour() + ":" + "0" + getMinute();
			else
				return "0" + getHour() + ":" + getMinute();
		}

		else {
			if (getMinute() < 10)
				return getHour() + ":" + "0" + getMinute();
			else
				return getHour() + ":" + getMinute();
		}
	}

	public int minFromMidnight() {
		return _minFromMidnight;
	}

	public boolean equals(Time2 other) {
		return (_minFromMidnight == other.minFromMidnight());
	}

	public boolean before(Time2 other) {
		return (_minFromMidnight < other.minFromMidnight());
	}

	public boolean after(Time2 other) {
		return !before(other);
	}

	public int difference(Time2 other) {
		return (_minFromMidnight - other.minFromMidnight());
	}
}
