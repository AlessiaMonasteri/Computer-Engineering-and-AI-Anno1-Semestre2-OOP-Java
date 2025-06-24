package Library;

//L’interfaccia assicura che ogni tipo di contenuto fornisca almeno queste informazioni (comuni a tutti i type)
public interface Media {
    String getTitle();
    String getGenre();
    int getYear();
    String getAuthor();
    String getProhibition();

    void play();
    void stop();

    boolean isPlaying();
    boolean isPaused();
}
