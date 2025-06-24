package Library;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Composite Pattern
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
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getTitle();
    }

    @Override
    public String getAuthor() {
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getAuthor();
    }

    @Override
    public String getProhibition() {
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getProhibition();
    }


    @Override
    public int getYear() {

        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getYear();
    }
    

    @Override
    public String getGenre() {
        if (mediaItems.isEmpty()) {
            throw new UnsupportedOperationException("No media in the library.");
        }
        return mediaItems.get(0).getGenre();
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
    public void play() {
        for (Media media : mediaItems) {
            media.play();
        }
    }

    @Override
    public void pause() {
        for (Media media : mediaItems) {
            media.pause();
        }
    }

    @Override
    public void stop() {
        for (Media media : mediaItems) {
            media.stop();
        }
    }

    @Override
    public boolean isPlaying() {
        // Torna true se almeno un media sta suonando
        for (Media media : mediaItems) {
            if (media.isPlaying()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPaused() {
        // Torna true se almeno un media è in pausa
        for (Media media : mediaItems) {
            if (media.isPaused()) {
                return true;
            }
        }
        return false;
    }


public void saveToFile() {
    //Ottiene il percorso della directory che contiene il file App.java (la directory principale)
    String workingDirectory = System.getProperty("user.dir");
    
    //Crea il percorso completo
    String folderPath = workingDirectory;
    
    //Crea il percorso completo per il file 'library.txt'
    String filePath = folderPath + File.separator + "library.txt";
    
    //Scrive gli elementi della libreria nel file, solo se il comando 12 viene eseguito
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


