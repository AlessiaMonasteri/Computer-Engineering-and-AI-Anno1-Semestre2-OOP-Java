import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MediaLibrary implements Media {
    private List<Media> mediaItems = new ArrayList<>();

    public void addMedia(Media media) {
        mediaItems.add(media);
    }

    public void removeMedia(Media media) {
        mediaItems.remove(media);
    }

    public List<Media> getMediaItems() {
        return mediaItems;
    }

    @Override
    public String getTitle() {
        return "Media Library";
    }

    @Override
    public String getGenre() {
        return "Various";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Media Library:\n");
        for (Media media : mediaItems) {
            sb.append(media).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int getYear() {
        // Esempio: restituisce l'anno del primo media disponibile nella libreria
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getYear(); // Supponiamo che mediaItems sia la lista degli oggetti media
    }
    

    @Override
    public String getAuthor() {
        // Esempio: restituisce l'autore del primo media disponibile nella libreria
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getAuthor(); // Supponiamo che mediaItems sia la lista degli oggetti media
    }


    public void saveToFile(String filename) {
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "library.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Media media : mediaItems) {
                writer.write(media.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
}


