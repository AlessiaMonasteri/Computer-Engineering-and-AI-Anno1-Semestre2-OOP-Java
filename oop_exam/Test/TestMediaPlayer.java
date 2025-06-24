package Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Library.MediaPlayer;
import Library.Movie;
import Utils.User;

import org.junit.Before;

//Utente maggiorenne
public class TestMediaPlayer {

    private MediaPlayer mediaPlayer;
    private Movie testMovie;
    private User currentUser;

    @Before
    public void setup() {
        mediaPlayer = new MediaPlayer();
        testMovie = new Movie("The Conjuring", "James Wan", 2013, "Horror", "VM18");
        String username = "alessia";
        String hashedPassword = "$2a$10$YxICUKNtx7iCGUwQs2EXiOW5mTNtNM7LlVkIKzCMCpr9QreQTstBm";
        int birthYear = 1999;
        currentUser = new User(username, hashedPassword, birthYear);
    }

    @Test
    public void testPlayMedia() {
        mediaPlayer.play(testMovie, currentUser);
        assertTrue(testMovie.isPlaying());
        assertFalse(testMovie.isPaused());
    }

    @Test
    public void testPauseMedia() {
        mediaPlayer.play(testMovie, currentUser);
        mediaPlayer.pause();
        assertTrue(testMovie.isPaused());
        assertFalse(testMovie.isPlaying());
    }

    @Test
    public void testStopMedia() {
        mediaPlayer.play(testMovie, currentUser);
        mediaPlayer.stop();
        assertFalse(testMovie.isPlaying());
        assertFalse(testMovie.isPaused());
    }
}

