
public class Movie implements Media {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String prohibition;

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

    public void play() {
        System.out.println("Now playing movie: " + getTitle());
    }
    
}

