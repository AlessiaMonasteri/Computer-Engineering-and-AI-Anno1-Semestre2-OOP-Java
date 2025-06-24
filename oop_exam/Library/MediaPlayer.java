package Library;

import java.util.List;

import Utils.User;

public class MediaPlayer {

    private Media currentMedia;
    private boolean isPlaying = false;
    private boolean isPaused = false;

    public void play(Media media, User user) {
        if (media == null || user == null) return;

        int userAge = user.getAge();
        String restriction = media.getProhibition();
        if (restriction != null && !restriction.isEmpty()) {
            String ageStr = restriction.replaceAll("[^0-9]", "");
            try {
                int minAge = Integer.parseInt(ageStr);
                if (userAge < minAge) {
                    System.out.println("Access denied: restricted to " + minAge + "+");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid restriction format");
            }
        }

        currentMedia = media;
        isPlaying = true;
        isPaused = false;

        if (currentMedia instanceof Movie) {
            ((Movie) currentMedia).play();
        }

        System.out.println("Playing: " + media.getTitle());
    }

    public void pause() {
        if (currentMedia != null && isPlaying && !isPaused) {
            isPlaying = false;
            isPaused = true;

            if (currentMedia instanceof Movie) {
                ((Movie) currentMedia).pause();
            }
        }
    }

    public void stop() {
        if (currentMedia != null) {
            isPlaying = false;
            isPaused = false;

            if (currentMedia instanceof Movie) {
                ((Movie) currentMedia).stop();
            }
        }
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


