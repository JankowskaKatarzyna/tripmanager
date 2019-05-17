package pl.edu.agh.mwo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TripManagerTest {

    TripManager tripManager;
    Trip trip;

    private static final String name = "nazwa";
    private static final String description = "opis";

    @Before
    public void setUp() {
        tripManager = new TripManager();
        trip = new Trip("nazwa", "opis");
    }

    @Test
    public void testAddTrip() throws TripAlreadyExistsException {
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
        assertTrue(choosenTrip.getName().toLowerCase().equals(name.toLowerCase()));
    }

    @Test
    public void testFindTripWhenTheDescriptionMatchesKeyword() throws Exception {
        tripManager.add(trip);
        Trip choosenTrip = tripManager.findTrip(trip.getDescription());
        assertTrue(choosenTrip.getDescription().toLowerCase().equals(description.toLowerCase()));
    }

    @Test
    public void testFindTripWhenTheKeywordIsNull() throws Exception {
        tripManager.add(trip);
        Trip choosenTrip = tripManager.findTrip("");
        assertTrue(choosenTrip.getName().toLowerCase() != null);
    }

    @Test
    public void testFindTripIsNullWhenKeywordDoNotMatch() throws NullPointerException, TripAlreadyExistsException {
        tripManager.add(trip);
        Trip choosenTrip = tripManager.findTrip("Las Vegas");
        assertNull(choosenTrip);
    }
}
