package Library;

public class Podcast implements Media{
    private String title;
    private String author;
    private int year;
    private String genre;

    private boolean playing = false;
    private boolean paused = false;

    public Podcast(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
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

    @Override
    public String getProhibition() {
        return "";
    }


    @Override
    public String toString() {
        return "Podcast: " + title + " | " + year + " | " + author + " | " + genre;
    }

     @Override
    public void play() {
        playing = true;
        paused = false;
        System.out.println("Playing podcast: " + title);
    }

    @Override
    public void pause() {
        if (playing) {
            playing = false;
            paused = true;
            System.out.println("Paused podcast: " + title);
        }
    }

    @Override
    public void stop() {
        if (playing || paused) {
            playing = false;
            paused = false;
            System.out.println("Stopped podcast: " + title);
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