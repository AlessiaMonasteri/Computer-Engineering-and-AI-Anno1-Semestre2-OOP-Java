public class MediaFactory {
    public static Media createMedia(String type, String title, String creator, int year, String genre, String album) {
        switch (type.toLowerCase()) {
            case "movie":
                return new Movie(title, creator, year, genre);
            case "song":
                return new Song(title, creator, year, genre, album);
            default:
                throw new IllegalArgumentException("Type not supported: " + type);
        }
    }
}
