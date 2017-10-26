package assignment12;

public class Time1 {

	private int _hour, _minute;

	public Time1(int h, int m) {
		_hour = h;
		_minute = m;
	}

	public Time1(Time1 t) {
		_hour = t.getHour();
		_minute = t.getMinute();
	}

	public int getHour() {
		return _hour;
	}

	public void setHour(int num) {
		if (num >= 0 && num <= 23)
			_hour = num;
	}

	public int getMinute() {
		return _minute;
	}

	public void setMinute(int num) {
		if (num >= 0 && num <= 59)
			_minute = num;
	}

	public String toString() {
		if (_hour < 10) {
			if (_minute < 10)
				return "0" + _hour + ":" + "0" + _minute;
			else
				return "0" + _hour + ":" + _minute;
		}

		else {
			if (_minute < 10)
				return _hour + ":" + "0" + _minute;
			else
				return _hour + ":" + _minute;
		}
	}

	public int minFromMidnight() {
		return (_hour * 60 + _minute);
	}

	public boolean equals(Time1 other) {
		return ((_hour == other.getHour()) && (_minute == other.getMinute()));
	}

	public boolean before(Time1 other) {
		if (_hour < other.getHour())
			return true;
		else if (_hour > other.getHour())
			return false;
		else {
			if (_minute < other.getMinute())
				return true;
			else
				return false;
		}
	}

	public boolean after(Time1 other) {
		return !before(other);
	}

	public int difference(Time1 other) {
		return (minFromMidnight() - other.minFromMidnight());
	}
}
