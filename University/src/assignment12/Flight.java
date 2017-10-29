package assignment12;

public class Flight {

	private final int MAX_CAPACITY = 250, MIN = 0;
	private String _origin, _destination;
	private Time1 _departure;
	private int _flightDuration, _noOfPassengers, _price;
	private boolean _isFull = false;

	// Specific constructor
	public Flight(String origin, String dest, int depHour, int depMinute, int durTimeMinutes, int noOfPass, int price) {
		_origin = origin;
		_destination = dest;
		_departure = new Time1(depHour, depMinute);

		/* Sets the flight duration with a minimum of 0 */
		if (durTimeMinutes < MIN)
			durTimeMinutes = MIN;
		_flightDuration = durTimeMinutes;

		/* Sets the number of passengers with a minimum of 0 and a max of 250 */
		if (noOfPass < MIN)
			noOfPass = MIN;
		else if (noOfPass > MAX_CAPACITY) {
			noOfPass = MAX_CAPACITY;
			_isFull = true;
		}
		_noOfPassengers = noOfPass;

		/* Sets the price with a minimum of 0 */
		if (price < MIN)
			price = MIN;
		_price = price;
	}// End constructor

	// Copy constructor
	public Flight(Flight other) {

	}

	// Returns the origin of the flight
	public String getOrigin() {
		return _origin;
	}

	// Sets the origin of the flight
	public void setOrigin(String origin) {
		_origin = origin;
	}

	// Returns the destination of the flight
	public String getDestination() {
		return _destination;
	}

	// Sets the destination of the flight
	public void setDestination(String dest) {
		_destination = dest;
	}

	// Returns the departure time of the flight
	public Time1 getDeparture() {
		return _departure;
	}

	// Sets the departure time of the flight
	public void setDeparture(Time1 departureTime) {
		_departure = departureTime;
	}

	// Returns the duration of the flight in minutes
	public int getFlightDuration() {
		return _flightDuration;
	}

	// Sets the duration of the flight in minutes
	public void setFlightDuration(int durTimeMinutes) {
		_flightDuration = durTimeMinutes;
	}

	// Returns the number of passengers on the flight
	public int getNoOfPassengers() {
		return _noOfPassengers;
	}

	// Sets the number of passengers on the flight
	public void setNoOfPassengers(int noOfPass) {
		_noOfPassengers = noOfPass;
	}

	// Returns the price of the flight
	public int getPrice() {
		return _price;
	}

	// Sets the price of the price
	public void setPrice(int _price) {
		this._price = _price;
	}

	//Returns whether the flight is full
	public boolean getIsFull() {
		return _isFull;
	}

	public boolean addPassengers(int num) {
		if (_noOfPassengers + num > MAX_CAPACITY)
			return false;
		else {
			_noOfPassengers += num;
			return true;
		}
	}

	public boolean equals(Flight other) {
		if (_origin == other.getOrigin() && _destination == other.getDestination() && _departure == other.getDeparture()
				&& _flightDuration == other.getFlightDuration() && _noOfPassengers == other.getNoOfPassengers()
				&& _price == other.getPrice())
			return true;
		return false;
	}

	public Time1 getArrivalTime() {
		if (_departure.getMinute() + (_flightDuration % 60) == 60)
			return new Time1((_departure.getHour() + (_flightDuration / 60) + 1), 0);
		return new Time1((_departure.getHour() + _flightDuration / 60),
				(_departure.getMinute() + _flightDuration % 60));
	}

	public boolean isCheaper(Flight other) {
		return _price < other.getPrice();
	}

	public boolean landsEarlier(Flight other) {
		if (_departure.minFromMidnight() + _flightDuration < other.getDeparture().minFromMidnight()
				+ other.getFlightDuration())
			return true;
		return false;
	}

	public int totalPrice() {
		return _noOfPassengers * _price;
	}

	public String toString() {
		if (_isFull)
			return "Flight from " + _origin + " to " + _destination + " departs at " + _departure.toString()
					+ ". Flight is full.";
		return "Flight from " + _origin + " to " + _destination + " departs at " + _departure.toString()
				+ ". Flight is not full.";
	}

}