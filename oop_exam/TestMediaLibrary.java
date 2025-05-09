import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before; 

public class TestMediaLibrary {

    private MediaLibrary mediaLibrary;

    @Before
    public void setup() {
        mediaLibrary = new MediaLibrary();
        mediaLibrary.addMedia(new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi"));
    }

    @Test
    public void testAddMedia() {
        int initialSize = mediaLibrary.getMediaItems().size();
        mediaLibrary.addMedia(new Movie("Interstellar", "Christopher Nolan", 2014, "Sci-Fi"));
        assertEquals(initialSize + 1, mediaLibrary.getMediaItems().size());
    }

    @Test
    public void testRemoveMedia() {
        Movie media = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi");
        mediaLibrary.addMedia(media);
        int initialSize = mediaLibrary.getMediaItems().size();
        mediaLibrary.removeMedia(media);
        assertEquals(initialSize - 1, mediaLibrary.getMediaItems().size());
    }
}

