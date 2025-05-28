import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MediaLibrary implements Media {
    private List<Media> mediaItems = new ArrayList<>();

    public void addMedia(Media media) {
        mediaItems.add(media);
        // saveToFile(); // Salva automaticamente dopo ogni aggiunta
    }


    public void removeMedia(Media media) {
        mediaItems.remove(media);
        // saveToFile(); // Salva automaticamente dopo ogni rimozione
    }

    public List<Media> getMediaItems() {
        return mediaItems;
    }

    @Override
    public String getTitle() {
        // Esempio: restituisce l'autore del primo media disponibile nella libreria
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getTitle(); // Supponiamo che mediaItems sia la lista degli oggetti media
    }

    @Override
    public String getProhibition() {
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getProhibition();
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

    @Override
    public String getGenre() {
        // Esempio: restituisce l'autore del primo media disponibile nella libreria
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getGenre(); // Supponiamo che mediaItems sia la lista degli oggetti media
    }


public void saveToFile() {
    // Ottieni il percorso della directory che contiene il file App.java (la directory principale)
    String workingDirectory = System.getProperty("user.dir");
    
    // Crea il percorso completo
    String folderPath = workingDirectory;
    
    // Crea il percorso completo per il file 'library.txt'
    String filePath = folderPath + File.separator + "library.txt";
    
    // Scrivi gli elementi della libreria nel file, solo se il comando 12 viene eseguito
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        // Scrivi gli elementi della libreria nel file
        for (Media media : mediaItems) {
            writer.write(media.toString());
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error saving to file: " + e.getMessage());
    }
}


}


