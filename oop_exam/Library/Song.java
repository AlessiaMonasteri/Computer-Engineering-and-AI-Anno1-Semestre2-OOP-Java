package Library;

public class Song implements Media {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String album;

    private boolean playing = false;
    private boolean paused = false;

    public Song(String title, String author, int year, String genre, String album) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.album = album;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public String getGenre() {
        return this.genre;
    }

    public String getAlbum() {
    return album;
    }


    @Override
    public String getProhibition() {
        return "";
    }

    @Override
    public String toString() {
        return "Song: " + title + " | " + year + " | " + author + " | " + genre + " | " + album;
    }

    @Override
    public void play() {
        playing = true;
        paused = false;
        System.out.println("Playing song: " + title);
    }

    @Override
    public void pause() {
        if (playing) {
            playing = false;
            paused = true;
            System.out.println("Paused song: " + title);
        }
    }

    @Override
    public void stop() {
        if (playing || paused) {
            playing = false;
            paused = false;
            System.out.println("Stopped song: " + title);
        }
    }

    @Override
    public boolean isPlaying() {
        return playing;
    }

    @Override
    public boolean isPaused() {
        return paused;
    }
    
}

