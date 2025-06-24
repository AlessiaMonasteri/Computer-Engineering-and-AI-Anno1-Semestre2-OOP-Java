package Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Library.MediaPlayer;
import Library.Song;

import org.junit.Before;


public class TestMediaPlayer {

    private MediaPlayer mediaPlayer;
    private Song testSong;

    @Before
    public void setup() {
        mediaPlayer = new MediaPlayer();
        testSong = new Song("Title", "Author", 2020, "Album", "Pop");
    }

    @Test
    public void testPlayMedia() {
        mediaPlayer.play(testSong);
        assertTrue(testSong.isPlaying());
        assertFalse(testSong.isPaused());
    }

    @Test
    public void testPauseMedia() {
        mediaPlayer.play(testSong);
        mediaPlayer.pause();
        assertTrue(testSong.isPaused());
        assertFalse(testSong.isPlaying());
    }

    @Test
    public void testStopMedia() {
        mediaPlayer.play(testSong);
        mediaPlayer.stop();
        assertFalse(testSong.isPlaying());
        assertFalse(testSong.isPaused());
    }
}

