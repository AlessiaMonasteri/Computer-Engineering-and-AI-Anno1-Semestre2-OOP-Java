package Movie;

import java.util.concurrent.TimeUnit;
import Movie.generics.Amplifier;
import Movie.generics.DVDPlayer;
import Movie.generics.Projector;
import Movie.generics.Screen;

public class App {
    public static void main(String[] args) throws InterruptedException{
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            new Amplifier(), 
            new DVDPlayer(), 
            new Projector(),
            new Screen());
        homeTheater.watchMovie("Interstellar");
        TimeUnit.SECONDS.sleep(5);
        homeTheater.endMovie();
    }
}
