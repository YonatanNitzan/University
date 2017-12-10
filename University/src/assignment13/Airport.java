package assignment13;

import assignment12.Flight;
import assignment12.Time1;

public class Airport {

	private Flight[] _flightsSchedule;
	private int _noOfFlights = 0;
	private String _airport;
	private final int MAX_FLIGHTS = 200;

	/**
	 * Constructor creates {@code Airport} instance with a given city location.
	 * 
	 * @param city
	 *            - the city the airport is in
	 */
	public Airport(String city) {
		_airport = city;
		_noOfFlights = 0;
		_flightsSchedule = new Flight[MAX_FLIGHTS];
	}

	/**
	 * Attempts to add a flight. The flight is added if it departs from or lands at
	 * the airport's location, and if there available space in the flight schedule.
	 * Returns true if the flight was added successfully.
	 * 
	 * @param f
	 *            - the flight to be added
	 * @return Whether the flight was added
	 */
	public boolean addFlight(Flight f) {
		// Checks if flight leaves from or arrives at the airport
		if (f.getOrigin() == _airport || f.getDestination() == _airport) {
			// Checks whether there's available space for the flight
			if (_noOfFlights + 1 <= MAX_FLIGHTS) {
				_flightsSchedule[_noOfFlights] = f;

				// Updates the flights count
				_noOfFlights++;
				return true;
			}
		}

		// Returns false if the flight was not added
		return false;
	}

	/**
	 * Removes a given flight from the flights schedule if it was previously on it.
	 * Returns true if the flight was successfully removed.
	 * 
	 * @param f
	 *            - the flight to be removed
	 * @return Whether the flight was removed.
	 */
	public boolean removeFlight(Flight f) {
		// Runs through the flights schedule
		for (int i = 0; i < _noOfFlights; i++) {
			// Checks if the given flight is on the schedule
			if (f.equals(_flightsSchedule[i])) {
				// Moves every object on the schedule after the removed flight back one space
				for (int j = i; j <= _noOfFlights - 1; j++)
					_flightsSchedule[j] = _flightsSchedule[j + 1];

				// Updates the flights count
				_noOfFlights--;
				return true;
			}
		}

		// Returns false if the flight was not removed
		return false;
	}

	/**
	 * Finds the first flight that leaves from a given location within the flights
	 * schedule.
	 * 
	 * @param place
	 *            - the location the flights departure from
	 * @return The departure time of the first flight.
	 */
	public Time1 firstFlightFromDestination(String place) {
		Flight earliest = null; // A holder variable for the earliest flight

		// Finds the first flight in the schedule to leave from the given place,
		for (Flight fl : _flightsSchedule)
			if (fl != null && fl.getOrigin() == place) {
				earliest = fl;
				break;
			}

		// Finds the earliest
		for (Flight fl : _flightsSchedule)
			if (fl != null && fl.getOrigin() == place && earliest != null)
				if (fl.landsEarlier(earliest))
					earliest = fl;

		// Returns null if there are no flights from the given place
		return earliest.getDeparture();
	}

	/**
	 * Checks how many flights from the airport are heading to a given destination.
	 * 
	 * @param city
	 *            - the destination the flights are heading to
	 * @return The number of flights heading to the given city.
	 */
	public int howManyFlightsToDestination(String city) {
		int counter = 0;

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (fl.getDestination() == city)
					counter++;

		return counter;
	}

	/**
	 * Checks how many flights in the flights schedule are between two given
	 * locations.
	 * 
	 * @param city1
	 *            - the first location
	 * @param city2
	 *            - the second location
	 * @return The number of flights between the two given cities.
	 */
	public int howManyFlightsBetween(String city1, String city2) {
		int counter = 0;

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				/*
				 * Checks for a flight from the first city to the second, or from the second to
				 * the first
				 */
				if (fl.getOrigin() == city1 && fl.getDestination() == city2
						|| fl.getOrigin() == city2 && fl.getDestination() == city1)
					counter++;

		return counter;
	}

	/**
	 * Checks how many full flights are in the flights schedule.
	 * 
	 * @return The number of full flights.
	 */
	public int howManyFullFlights() {
		int counter = 0;

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (fl.getIsFull())
					counter++;

		return counter;
	}

	/**
	 * Finds the destination with the most arriving flights within the flights
	 * schedule.
	 * 
	 * @return The name of the most popular destination.
	 */
	public String mostPopularDestination() {
		String holder = "None."; // Holder variable to the destination

		// Finds the destination with the most arriving flights
		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (howManyFlightsToDestination(holder) < howManyFlightsToDestination(fl.getDestination()))
					holder = fl.getDestination();

		return holder;
	}

	/**
	 * Finds the flight with the most expensive ticket.
	 * 
	 * @return The flight with the most expensive ticket.
	 */
	public Flight mostExpensiveTicket() {
		Flight holder = _flightsSchedule[0];

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (holder.getPrice() < fl.getPrice())
					holder = fl;

		return holder;
	}

	/**
	 * Finds the flight with the longest duration.
	 * 
	 * @return The longest flight.
	 */
	public Flight longestFlight() {
		Flight holder = _flightsSchedule[0];

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (holder.getFlightDuration() < fl.getFlightDuration())
					holder = fl;

		return holder;
	}

	/**
	 * Prints a list of all the flights in the airport's flights schedule.
	 */
	public String toString() {
		// Header
		String holder = "\nThe flights for airport " + _airport + " today are:\n";

		// Adds all the flights to the list
		for (Flight fl : _flightsSchedule)
			if (fl != null)
				holder += fl.toString() + "\n";

		// Returns the list
		return holder;
	}
}