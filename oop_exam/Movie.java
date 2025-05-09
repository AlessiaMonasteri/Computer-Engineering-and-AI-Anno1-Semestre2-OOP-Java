
public class Movie implements Media {
    private String title;
    private String director;
    private int year;
    private String genre;

    public Movie(String title, String director, int year, String genre) {
        if (title.isEmpty() || director.isEmpty() || year < 1900 || genre.isEmpty()) {
            throw new IllegalArgumentException("Invalid Data.");
        }
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return this.director;
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
        return "Movie: " + title + " | " + year + " | " + director + " | " + genre;
    }

    public void play() {
        System.out.println("Now playing movie: " + getTitle());
    }
    
}

