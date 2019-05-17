package pl.edu.agh.mwo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripManagerTest {

    TripManager tripManager;
    Trip trip;

    @Before
    public void setUp() {
        tripManager = new TripManager();
        trip = new Trip("nazwa", "opis");
    }

    @Test
    public void testAdd() throws TripAlreadyExistsException {
        assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
    }

    @Test(expected = TripAlreadyExistsException.class)
    public void testAddTripTwice() throws TripAlreadyExistsException {
        assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
        tripManager.add(trip);
    }

    @Test
    public void testRemoveTrip() throws Exception {
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
        tripManager.remove(trip.getName());
        assertEquals(0, tripManager.getTrips().size());
        //fail("chcemy zespuc");
    }

    @Test
    public void testFindTripWhenTheNameMatchesKeyword() throws Exception {
        tripManager.add(trip);
        Trip choosenTrip = tripManager.findTrip(trip.getName());
        assertTrue(choosenTrip.getName().toLowerCase().equals(trip.getName().toLowerCase()));
    }

    @Test
    public void testFindTripWhenTheDescriptionMatchesKeyword() throws Exception {
        tripManager.add(trip);
        Trip choosenTrip = tripManager.findTrip(trip.getDescription());
        assertTrue(choosenTrip.getDescription().toLowerCase().equals(trip.getDescription().toLowerCase()));
    }

    @Test
    public void testFindTripWhenTheKeywordIsNull() throws Exception {
        tripManager.add(trip);
        Trip choosenTrips = tripManager.findTrip("");
        assertTrue(choosenTrips.getName().toLowerCase().equals(trip.getName().toLowerCase()));
    }


}
