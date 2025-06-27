package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Library.Game;
import Library.Media;
import Library.Movie;
import Library.Podcast;
import Library.Song;

public class MediaExporter {

    public static boolean exportToCSV(List<Media> mediaList) {
        String filePath = "C:\\Users\\Utente\\OneDrive\\Desktop\\Documenti\\Epicode-Laurea\\CORSI\\Anno 1\\Semestre 2\\Object Oriented Programming\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\oop_exam\\MainApp\\media_library.csv";
        //Scrive l’intestazione delle colonne nel file CSV
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Type,Title,Author,Year,Album,Console,Genre,Prohibition\n");
            //Per ogni oggetto Media nella lista avviene l'inizializzazione
            //Si aggiunge il replacement della virgola nei campi stringa per evitare
            //disallineamento nella creazione CSV
            for (Media media : mediaList) {
                String type = "";
                String title = media.getTitle().replace(",", " ");
                String author = media.getAuthor().replace(",", " ");
                int year = media.getYear();
                String album = "";
                String console = "";
                String genre = media.getGenre().replace(",", " ");
                String prohibition = "";
                //In base al tipo di media, vengono aggiunti dei campi specifici
                if (media instanceof Song) {
                    type = "Song";
                    album = ((Song) media).getAlbum().replace(",", " ");
                } else if (media instanceof Movie) {
                    type = "Movie";
                    prohibition = ((Movie) media).getProhibition();
                } else if (media instanceof Game) {
                    type = "Game";
                    console = ((Game) media).getConsole().replace(",", " ");
                    prohibition = ((Game) media).getProhibition();
                } else if (media instanceof Podcast) {
                    type = "Podcast";
                }
                //Scrive la riga nel file CSV, sostituendo i campi facoltativi che sono a null con una stringa vuota
                writer.write(String.format("%s,%s,%s,%d,%s,%s,%s,%s\n",
                        type,
                        title,
                        author,
                        year,
                        album != null ? album : "",
                        console != null ? console : "",
                        genre != null ? genre : "",
                        prohibition != null ? prohibition : ""));
            }

            return true;

        } catch (IOException e) {
            return false;
        }
    }
}




