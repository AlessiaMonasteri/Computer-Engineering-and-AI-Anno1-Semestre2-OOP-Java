package Library;

import java.util.List;
import Utils.User;

public class MediaPlayer {

    private Media currentMedia;
    private boolean isPlaying = false;
    private boolean isPaused = false;

public void play(Media media, User user) {
    if (media == null || user == null) return;

    currentMedia = media;
    isPlaying = true;
    isPaused  = false;

    if (currentMedia instanceof Movie m) {
        m.play();
    } else if (currentMedia instanceof Song s) {
        s.play();
    } else if (currentMedia instanceof Game g) {
        g.play();
    } else if (currentMedia instanceof Podcast p) {
        p.play();
    } else {
        System.out.println("Media type not managed");
        return;
    }
}

    public void stop() {
        if (currentMedia != null && isPlaying && !isPaused) {
            isPlaying = false;
            isPaused = false;
            currentMedia.stop();
        } else {System.out.println("Nothing to stop");}
    }

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


