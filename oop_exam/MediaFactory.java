public class MediaFactory {
    public static Media createMedia(String type, String title, String creator, int year, String genre, String album, String console, String prohibition) {
        switch (type.toLowerCase()) {
            case "movie":
                return new Movie(title, creator, year, genre, prohibition);
            case "song":
                return new Song(title, creator, year, genre, album);
            case "game":
                return new Game(title, creator, year, genre, console, prohibition);
            case "podcast":
                return new Podcast(title, creator, year, genre);
            default:
                throw new IllegalArgumentException("Type not supported: " + type);
        }
    }
}
