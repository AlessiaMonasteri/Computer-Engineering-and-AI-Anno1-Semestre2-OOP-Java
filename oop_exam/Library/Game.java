package Library;

public class Game implements Media {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String prohibition;
    private String console;

    private boolean playing = false;
    private boolean paused = false;

    public Game(String title, String author, int year, String genre, String console, String prohibition) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.prohibition = prohibition;
        this.console = console;
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

    public String getConsole() {
        return console;
    }

    @Override
    public String toString() {
        return "Game: " + title + " | " + year + " | " + author + " | " + console + " | " + genre + " | " + prohibition;
    }

    @Override
    public void play() {
        playing = true;
        paused = false;
        System.out.println("Launching game: " + title + " on " + console);
    }

    @Override
    public void pause() {
        if (playing) {
            playing = false;
            paused = true;
            System.out.println("Paused game: " + title);
        }
    }

    @Override
    public void stop() {
        if (playing || paused) {
            playing = false;
            paused = false;
            System.out.println("Stopped game: " + title);
        }
    }

    @Override
    public boolean isPlaying() {
        playing = true;
        paused = false;
        return playing;
    }

    @Override
    public boolean isPaused() {
        paused = true;
        playing = false;
        return paused;
    }
    
}


