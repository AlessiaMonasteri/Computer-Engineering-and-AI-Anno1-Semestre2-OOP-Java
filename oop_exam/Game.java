
public class Game implements Media {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String prohibition;
    private String console;

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

    public void play() {
        System.out.println("Now playing movie: " + getTitle());
    }
    
}


