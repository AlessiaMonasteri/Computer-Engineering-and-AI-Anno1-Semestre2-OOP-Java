package Library;
public class Movie implements Media {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String prohibition;

    private boolean playing = false;
    private boolean paused = false;

    public Movie(String title, String author, int year, String genre, String prohibition) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.prohibition = prohibition;
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

    public String getProhibition() {
        return prohibition;
    }

    @Override
    public String toString() {
        return "Movie: " + title + " | " + year + " | " + author + " | " + genre + " | " + prohibition;
    }

    @Override
    public void play() {
        playing = true;
        paused = false;
        System.out.println("Playing movie: " + title);
    }

    @Override
    public void pause() {
        if (playing) {
            this.playing = false;
            this.paused = true;
            System.out.println("Paused movie: " + title);
        }
    }

    @Override
    public void stop() {
        if (playing || paused) {
            this.playing = false;
            this.paused = false;
            System.out.println("Stopped movie: " + title);
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public boolean isPaused() {
        return paused;
    }
    
}

