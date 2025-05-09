

public class Song implements Media {
    private String title;
    private String artist;
    private int year;
    private String genre;
    private String album;

    public Song(String title, String artist, int year, String genre, String album) {
        if (title.isEmpty() || artist.isEmpty() || year < 1900 || genre.isEmpty()) {
            throw new IllegalArgumentException("Invalid Data.");
        }
        this.title = title;
        this.artist = artist;
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
        return this.artist;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Song: " + title + " | " + year + " | " + artist + " | " + genre + " | Album: " + album;
    }

    public void play() {
        System.out.println("Now playing song: " + getTitle());
    }
    
}

