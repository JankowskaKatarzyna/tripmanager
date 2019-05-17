package pl.edu.agh.mwo;

import java.util.HashMap;
import java.util.Map;

public class TripManager {

    private HashMap<String, Trip> tripList;

    public TripManager() {
        tripList = new HashMap<String, Trip>();
    }

    public void add(Trip trip) throws TripAlreadyExistsException {
        if (tripList.get(trip.getName()) != null) {
            throw new TripAlreadyExistsException();
        } else {
            tripList.put(trip.getName(), trip);
        }
    }

    public Trip findTrip(String word) {
        for (Map.Entry<String, Trip> entry : tripList.entrySet()) {
            if (entry.getValue().getName().toLowerCase().equals(word.toLowerCase()) ||
                    entry.getValue().getDescription().toLowerCase().equals(word.toLowerCase()) ||
                    word.toLowerCase() == "") {
                return entry.getValue();
            }
        }
        return null;
    }

    public HashMap<String, Trip> getTrips() {
        return tripList;
    }

    public void remove(String name) {
        tripList.remove(name);
    }
}
