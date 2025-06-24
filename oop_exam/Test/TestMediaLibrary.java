package Test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before; 

import Library.MediaLibrary;
import Library.Movie;
import Library.Media;

public class TestMediaLibrary {

    private MediaLibrary mediaLibrary;

    @Before
    public void setup() {
        mediaLibrary = new MediaLibrary();
        mediaLibrary.addMedia(new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", ""));
    }

    @Test
    public void testAddMedia() {
        int initialSize = mediaLibrary.getMediaItems().size();
        mediaLibrary.addMedia(new Movie("Interstellar", "Christopher Nolan", 2014, "Sci-Fi", ""));
        assertEquals(initialSize + 1, mediaLibrary.getMediaItems().size());
    }

    @Test
    public void testRemoveMedia() {
        Movie media = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi", "");
        mediaLibrary.addMedia(media);
        int initialSize = mediaLibrary.getMediaItems().size();
        mediaLibrary.removeMedia(media);
        assertEquals(initialSize - 1, mediaLibrary.getMediaItems().size());
    }

    @Test
    public void testSearchByPartialTitleIgnoreCase() {
        // La media "Inception" è già aggiunta nel setup
        String searchInput = "cept"; // parte del titolo, in minuscolo
        boolean found = false;

        for (Media m : mediaLibrary.getMediaItems()) {
            if (m.getTitle().toLowerCase().contains(searchInput.toLowerCase())) {
                found = true;
                break;
            }
        }

        assertTrue("La ricerca dovrebbe trovare il titolo anche se è una parte e in minuscolo", found);
    }

}

