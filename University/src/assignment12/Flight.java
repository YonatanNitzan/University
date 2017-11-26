package assignment12;

public class Flight {

	private final int MAX_CAPACITY = 250, MIN = 0;
	private String _origin, _destination;
	private Time1 _departure;
	private int _flightDuration, _noOfPassengers, _price;
	private boolean _isFull = false;

	/**
	 * Sets the flight with parameters.
	 * 
	 * @param origin
	 *            - Origin
	 * @param dest
	 *            - Destination
	 * @param depHour
	 *            - Departure hour
	 * @param depMinute
	 *            - Departure minute
	 * @param durTimeMinutes
	 *            - Flight duration in minutes
	 * @param noOfPass
	 *            - Number of passengers
	 * @param price
	 *            - Ticket price
	 */
	public Flight(String origin, String dest, int depHour, int depMinute, int durTimeMinutes, int noOfPass, int price) {
		_origin = origin;
		_destination = dest;
		_departure = new Time1(depHour, depMinute);

		/* Sets the flight duration with a minimum of 0 */
		if (durTimeMinutes < MIN)
			durTimeMinutes = MIN;
		_flightDuration = durTimeMinutes;

		/* Sets the number of passengers with a 0-250 range */
		if (noOfPass < MIN)
			noOfPass = MIN;
		else if (noOfPass >= MAX_CAPACITY) {
			noOfPass = MAX_CAPACITY;
			_isFull = true;
		}
		_noOfPassengers = noOfPass;

		/* Sets the price with a minimum of 0 */
		if (price < MIN)
			price = MIN;
		_price = price;
	}

	// Copy constructor
	public Flight(Flight other) {
		_origin = other.getOrigin();
		_destination = other.getDestination();
		_departure = other.getDeparture();
		_flightDuration = other.getFlightDuration();
		_noOfPassengers = other.getNoOfPassengers();
		_isFull = other.getIsFull();
		_price = other.getPrice();
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
		if (noOfPass >= MAX_CAPACITY) {
			_noOfPassengers = MAX_CAPACITY;
			_isFull = true;
		}
		else
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

	// Returns whether the flight is full
	public boolean getIsFull() {
		return _isFull;
	}

	/**
	 * Add passengers to instance flight. If the number of passengers after addition
	 * exceeds the maximum capacity, no passengers are added and false is returned.
	 * If the flight becomes full, the boolean attribute describing whether the
	 * flight if full becomes true.
	 * 
	 * @param num
	 *            - The number of passengers to be added to this flight.
	 * @return True if the passengers were added to the flight.
	 */
	public boolean addPassengers(int num) {
		if (_noOfPassengers + num > MAX_CAPACITY)
			return false;
		else {
			_noOfPassengers += num;
			return true;
		}
	}

	/**
	 * Checks if the given flight is equal to instance flight. Flights are
	 * considered equal if the origin, destination and departure times are the same.
	 * 
	 * @param other
	 *            - The flight to be compared with instance flight.
	 * @return True if the given flight is equal to instance flight.
	 */
	public boolean equals(Flight other) {
		// Checks if origin destination and departure are equal
		if (_origin == other.getOrigin() && _destination == other.getDestination()
				&& _departure == other.getDeparture())
			return true;

		return false;
	}

	/**
	 * Returns the arrival time of the instance flight.
	 * 
	 * @return The arrival time of instance flight.
	 */
	public Time1 getArrivalTime() {
		// Adds an hour when minute sum is an hour
		if (_departure.getMinute() + (_flightDuration % 60) == 60)
			return new Time1((_departure.getHour() + (_flightDuration / 60) + 1), 0);

		return new Time1((_departure.getHour() + _flightDuration / 60),
				(_departure.getMinute() + _flightDuration % 60));
	}

	/**
	 * Check if instance flight is cheaper than given flight.
	 * 
	 * @param other
	 *            - The flight whose price is to be compared with this flight's
	 *            price.
	 * @return True if instance flight is cheaper than the given flight.
	 */
	public boolean isCheaper(Flight other) {
		return _price < other.getPrice();
	}

	/**
	 * Check if instance flight lands before given flight. Note - the flights may
	 * land on different days, the method checks which flight lands first.
	 * 
	 * @param other
	 * @return
	 */
	public boolean landsEarlier(Flight other) {
		/*
		 * Checks if the sum of minutes from midnight of the departure day of both
		 * flights
		 */
		if (_departure.minFromMidnight() + _flightDuration < other.getDeparture().minFromMidnight()
				+ other.getFlightDuration())
			return true;
		return false;
	}

	/**
	 * Calculates the total earnings from instance flight.
	 * 
	 * @return The total earnings of instance flight.
	 */
	public int totalPrice() {
		return _noOfPassengers * _price;
	}

	/**
	 * Return a string representation of this flight in format: flight from (origin)
	 * to (destination) departs at (departure time). Flight (is/is not) full.
	 * 
	 * @return String representation of instance flight.
	 */
	@Override
	public String toString() {
		// Checks if the flight is full
		if (_isFull)
			return "Flight from " + _origin + " to " + _destination + " departs at " + _departure.toString()
					+ ". Flight is full.";

		return "Flight from " + _origin + " to " + _destination + " departs at " + _departure.toString()
				+ ". Flight is not full.";
	}

}