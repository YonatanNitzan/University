package assignment13;

import assignment12.Flight;
import assignment12.Time1;

public class Airport {

	private Flight[] _flightsSchedule;
	private int _noOfFlights = 0;
	private String _airport;
	private final int MAX_FLIGHTS = 200;
	
	public Airport(String city) {
		_airport = city;
		_noOfFlights = 0;
		_flightsSchedule = new Flight[MAX_FLIGHTS];
	}

	public boolean addFlight(Flight f) {
		// Checks if flight leaves from or arrives at the airport
		if (f.getOrigin() == _airport || f.getDestination() == _airport) {
			// Checks whether there's available space for the flight
			if (_noOfFlights + 1 <= MAX_FLIGHTS) {
				_flightsSchedule[_noOfFlights] = f;
				_noOfFlights++;
				return true;
			}

			else
				return false;
		}

		return false;
	}

	public boolean removeFlight(Flight f) {
		for (int i = 0; i < _noOfFlights; i++) {
			if (f.equals(_flightsSchedule[i])) {
				for (int j = i; j <= _noOfFlights - 1; j++)
					_flightsSchedule[j] = _flightsSchedule[j + 1];
				
				_noOfFlights--;
				return true;
			}
		}

		return false;
	}

	public Time1 firstFlightFromDestination(String place) {
		Flight earliest = null;

		for (Flight fl : _flightsSchedule)
			if (fl != null && fl.getOrigin() == place) {
				earliest = fl;
				break;
			}

		for (Flight fl : _flightsSchedule)
			if (fl != null && fl.getOrigin() == place && earliest != null)
				if (fl.landsEarlier(earliest))
					earliest = fl;

		return earliest.getDeparture();
	}

	public String toString() {
		String holder = "\nThe flights for airport " + _airport + " today are:\n";

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				holder += fl.toString() + "\n";

		return holder;
	}

	public int howManyFullFlights() {
		int counter = 0;

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (fl.getIsFull())
					counter++;

		return counter;
	}
	
	public int howManyFlightsToDestination(String city) {
		int counter = 0;

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (fl.getDestination() == city)
					counter++;

		return counter;
	}

	public int howManyFlightsBetween(String city1, String city2) {
		int counter = 0;

		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (fl.getOrigin() == city1 && fl.getDestination() == city2
						|| fl.getOrigin() == city2 && fl.getDestination() == city1)
					counter++;

		return counter;
	}
	
	public String mostPopularDestination() {
		String holder = "None.";
		
		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (howManyFlightsToDestination(holder)
						< howManyFlightsToDestination(fl.getDestination()))
					holder = fl.getDestination();
				
		return holder;
	}
	
	public Flight mostExpensiveTicket() {
		Flight holder = _flightsSchedule[0];
		
		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (holder.getPrice()
						< fl.getPrice())
					holder = fl;
				
		return holder;
	}

	public Flight longestFlight() {
		Flight holder = _flightsSchedule[0];
		
		for (Flight fl : _flightsSchedule)
			if (fl != null)
				if (holder.getFlightDuration()
						< fl.getFlightDuration())
					holder = fl;
				
		return holder;
	}
}