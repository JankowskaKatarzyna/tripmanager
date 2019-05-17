package pl.edu.agh.mwo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhotoTest {

    private static String word = "Hawana";

    @Test
    public void testAddNewPhotoWithGivenComment() {
        Photo photo = new Photo();
        photo.setComment("Hawana");
        assertEquals(photo.getComment(), word);

    }
}
