import java.util.List;

public class MediaPlayer {
    private Media currentMedia = null;
    private boolean isPlaying = false;
    private boolean isPaused = false;



    // Riproduzione del media
    public void play(Media media) {
        if (media == null) {
            System.out.println("No media selected.");
            return;
        }
        currentMedia = media;
        isPlaying = true;
        isPaused = false;
        System.out.println("Playing: " + media.getTitle());
    }

    // Pausa del media
    public void pause() {
        if (isPlaying && !isPaused) {
            isPaused = true;
            System.out.println("Paused: " + currentMedia.getTitle());
        } else {
            System.out.println("Nothing to pause.");
        }
    }

    // Ripresa riproduzione
    public void resume() {
        if (isPlaying && isPaused) {
            isPaused = false;
            System.out.println("Resumed: " + currentMedia.getTitle());
        } else {
            System.out.println("Nothing to resume.");
        }
    }

    // Stop riproduzione
    public void stop() {
        if (isPlaying) {
            System.out.println("Stopped: " + currentMedia.getTitle());
            isPlaying = false;
            isPaused = false;
            currentMedia = null;
        } else {
            System.out.println("Nothing is playing.");
        }
    }

    // Riproduzione del prossimo media
    public void next(List<Media> mediaList) {
        if (currentMedia == null) {
            System.out.println("No media is currently playing. Starting from the beginning...");
            if (!mediaList.isEmpty()) {
                currentMedia = mediaList.get(0);
                System.out.println("Now playing: " + currentMedia.getTitle());
            } else {
                System.out.println("The media library is empty.");
            }
        } else {
            int index = mediaList.indexOf(currentMedia);
            if (index != -1 && index < mediaList.size() - 1) {
                currentMedia = mediaList.get(index + 1);
                System.out.println("Now playing: " + currentMedia.getTitle());
            } else {
                System.out.println("You have reached the end of the media list.");
            }
        }
    }
    
}

