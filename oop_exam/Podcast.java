
public class Podcast implements Media{
    private String title;
    private String author;
    private int year;
    private String genre;

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

        public void play() {
        System.out.println("Now playing podcast: " + getTitle());
    }

}