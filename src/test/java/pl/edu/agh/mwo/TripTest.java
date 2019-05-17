package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class TripTest {

	private static final String DESCRIPTION = "Boston";

	@Test
	public void testConstructor() {
		Trip trip = new Trip("nazwa", "opis");

		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}

	@Test
	public void testAddPhoto() {
		Trip trip = new Trip("USA", "New York");
		Photo photo = new Photo();
		photo.setComment("New York");

		assertEquals(0, trip.getPhotos().size());
		trip.addPhoto(photo);
		assertEquals(1, trip.getPhotos().size());
	}

	@Test
	public void getPhotos() {
		Collection<Photo> photos = new ArrayList<>();
		Trip trip = new Trip("USA", "New York");
		Photo photo = new Photo();
		photo.setComment("Berlin");
		trip.addPhoto(photo);
		photos.add(photo);

		assertEquals(photos, trip.getPhotos());

	}

	@Test
	public void addDescription() {
		Trip trip = new Trip("USA", "New York");
		trip.setDescription("Boston");

		assertEquals(DESCRIPTION, trip.getDescription());
	}


}
