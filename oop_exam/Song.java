

public class Song implements Media {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String album;

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

    @Override
    public String getProhibition() {
        return "";
    }

    @Override
    public String toString() {
        return "Song: " + title + " | " + year + " | " + author + " | " + genre + " | Album: " + album;
    }

    public void play() {
        System.out.println("Now playing song: " + getTitle());
    }
    
}

