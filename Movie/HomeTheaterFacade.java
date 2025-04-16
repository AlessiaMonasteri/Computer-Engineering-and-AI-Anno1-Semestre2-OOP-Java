package Movie;


import Movie.generics.Amplifier;
import Movie.generics.DVDPlayer;
import Movie.generics.Projector;
import Movie.generics.Screen;

public class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private Screen screen;
    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, Screen screen) {
    this.amp = amp;
    this.dvd = dvd;
    this.projector = projector;
    this.screen = screen;
    }
    public void watchMovie(String movie) {
    System.out.println("Get ready to watch a movie...");
    screen.down();
    projector.on();
    projector.wideScreenMode();
    amp.on();
    amp.setVolume(5);
    dvd.on();
    dvd.play(movie);
    }
    public void endMovie() {
    System.out.println("Shutting down the home theater...");
    dvd.stop();
    dvd.off();
    amp.off();
    projector.off();
    screen.up();
    }
   }
