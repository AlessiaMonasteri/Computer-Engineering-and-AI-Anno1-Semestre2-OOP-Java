import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {


    public static void main(String[] args) {

        Map<String, User> users = new HashMap<>();
        users.put("admin", new User("admin", "admin123"));
        users.put("giovanni", new User("giovanni", "password1"));
        users.put("elisa", new User("elisa", "ciao123"));


        //Lancio dell'applicazione
        System.out.println("Launching the Media app...");

        // Creazione della libreria multimediale usando il Composite Pattern
        MediaLibrary mediaLibrary = new MediaLibrary();

        // Aggiunta degli items alla libreria
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Interstellar", "Christopher Nolan", 2014, "Sci-Fi", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Pulp Fiction", "Quentin Tarantino", 1994, "Crime", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Schindler's List", "Steven Spielberg", 1993, "Drama", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Titanic", "James Cameron", 1997, "Romance", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Avatar", "James Cameron", 2009, "Sci-Fi", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Inception", "Christopher Nolan", 2010, "Sci-Fi", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "The Revenant", "Alejandro González Iñárritu", 2015, "Drama", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "The Lion King", "Roger Allers, Rob Minkoff", 1994, "Animation", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Black Panther", "Ryan Coogler", 2018, "Action", null));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Gravity", "Alfonso Cuarón", 2013, "Sci-Fi", null));


        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Bohemian Rhapsody", "Queen", 1975, "Rock", "A Night at the Opera"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Hotel California", "Eagles", 1976, "Rock", "Hotel California"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Smells Like Teen Spirit", "Nirvana", 1991, "Grunge", "Nevermind"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Thriller", "Michael Jackson", 1982, "Pop", "Thriller"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Stairway to Heaven", "Led Zeppelin", 1971, "Rock", "Led Zeppelin IV"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Imagine", "John Lennon", 1971, "Pop", "Imagine"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Like a Rolling Stone", "Bob Dylan", 1965, "Folk", "Highway 61 Revisited"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "La Noia", "Angelina Mango", 2024, "Pop", "Poké melodrama"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Alba", "Ultimo", 2023, "Pop", "Alba"));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Amare", "La Rappresentante di Lista", 2021, "Pop", "My Mammma"));

        //Creazione di 2 liste per Film e Musica
        List<Media> movieLibrary = new ArrayList<>();
        List<Media> songLibrary = new ArrayList<>();

        //Insert nella lista pertinente in base al tipo
        for (Media media : mediaLibrary.getMediaItems()) {
            if (media instanceof Movie) {
                movieLibrary.add(media);
            } else if (media instanceof Song) {
                songLibrary.add(media);
            }
        }

        // Creazione di  un MediaPlayer per gestire la riproduzione
        MediaPlayer mediaPlayer = new MediaPlayer();
        
        //Creazione della variabile choice per scegliere l'input utente
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        int loginAttempts = 3;

        while (!loggedIn && loginAttempts > 0) {
            System.out.print("Username: ");
            String inputUsername = scanner.nextLine().trim();
            String inputPassword = PasswordPrompt.getPassword("Enter your password:", scanner);

        

            User user = users.get(inputUsername);

            if (user != null && user.getPassword().equals(inputPassword)) {
                System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
                loggedIn = true;
            } else {
                loginAttempts--;
                System.out.println("Invalid credentials. Attempts remaining: " + loginAttempts);
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed login attempts. Exiting program.");
            scanner.close();
            return;
        }

        int choice;
        //Voci del menu
        do {
            System.out.println("\nMENU\n");
            System.out.println("1.  Display all items in the library");
            System.out.println("2.  Display Movies");
            System.out.println("3.  Display Songs");
            System.out.println("4.  Search for media");
            System.out.println("5.  Add a new item");
            System.out.println("6.  Remove an existing item");
            System.out.println("7.  Play a media item");
            System.out.println("8.  Pause");
            System.out.println("9.  Resume");
            System.out.println("10. Stop");
            System.out.println("11. Play Next");
            System.out.println("12. Save library to file");
            System.out.println("13. Exit Program");
            System.out.print("\nChoose an option (1-13): ");
            
            //Per leggere la scelta dell'utente
            choice = scanner.nextInt();
            
            //Costrutto switch per eseguire azioni in base alla scelta dell'utente
            switch (choice) {
                case 1:
                    //Utilizzo dell'Iterator Pattern per scorrere la libreria
                    MediaIterator iterator = new MediaIterator(mediaLibrary.getMediaItems());
                    System.out.println("Library Contents:");
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;
                case 2:
                    //Mostra tutti i film nella libreria
                    System.out.println("Movies in the library:");
                    for (Media movie : movieLibrary) {
                        System.out.println(movie);
                    }
                    break;
                case 3: 
                    //Mostra tutte le canzoni nella libreria
                    System.out.println("Songs in the library:");
                    for (Media song : songLibrary) {
                        System.out.println(song);
                    }
                    break;
                case 4:
                    // Ricerca media per titolo, autore, anno o genere
                    System.out.println("Search media by:\n1. Title\n2. Author\n3. Year\n4. Genre");
                    System.out.print("Enter your choice (1-4): ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();  // Consuma invio
                
                    List<Media> searchResults = new ArrayList<>();
                
                    switch (searchChoice) {
                        case 1: // Ricerca per titolo
                            System.out.print("Enter title to search: ");
                            String titleSearch = scanner.nextLine().trim().toLowerCase();
                            for (Media media : mediaLibrary.getMediaItems()) {
                                if (media.getTitle().toLowerCase().contains(titleSearch)) {
                                    searchResults.add(media);
                                }
                            }
                            break;
                        case 2: // Ricerca per autore
                            System.out.print("Enter author to search: ");
                            String authorSearch = scanner.nextLine().trim().toLowerCase();
                            for (Media media : mediaLibrary.getMediaItems()) {
                                if (media.getAuthor().toLowerCase().contains(authorSearch)) {
                                    searchResults.add(media);
                                }
                            }
                            break;
                        case 3: // Ricerca per anno
                            System.out.print("Enter year to search: ");
                            int yearSearch = scanner.nextInt();
                            scanner.nextLine();  // Consuma invio
                            for (Media media : mediaLibrary.getMediaItems()) {
                                if (media.getYear() == yearSearch) {
                                    searchResults.add(media);
                                }
                            }
                            break;
                        case 4: // Ricerca per genere
                            System.out.print("Enter genre to search: ");
                            String genreSearch = scanner.nextLine().trim().toLowerCase();
                            for (Media media : mediaLibrary.getMediaItems()) {
                                if (media instanceof Movie && ((Movie) media).getGenre().toLowerCase().contains(genreSearch)) {
                                    searchResults.add(media);
                                } else if (media instanceof Song && ((Song) media).getGenre().toLowerCase().contains(genreSearch)) {
                                    searchResults.add(media);
                                }
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                
                    if (searchResults.isEmpty()) {
                        System.out.println("No media found matching the search criteria.");
                    } else {
                        System.out.println("Search results:");
                        for (Media result : searchResults) {
                            System.out.println(result);
                        }
                    }
                    break;
                
                case 5:
                    System.out.print("What type of media would you like to add? (movie/song): ");
                    String tipo = scanner.nextLine();
                
                    System.out.print("Title: ");
                    String titolo = scanner.nextLine();
                
                    System.out.print("Author/Director: ");
                    String autore = scanner.nextLine();
                
                    System.out.print("Year: ");
                    int anno = scanner.nextInt();
                    scanner.nextLine();
                
                    System.out.print("Genre: ");
                    String genere = scanner.nextLine();
                
                    String album = null;
                    if (tipo.equalsIgnoreCase("song")) {
                        System.out.print("Album: ");
                        album = scanner.nextLine();
                    }
                
                    Media nuovoMedia = MediaFactory.createMedia(tipo.toLowerCase(), titolo, autore, anno, genere, album);
                    if (nuovoMedia != null) {
                        mediaLibrary.addMedia(nuovoMedia);
                        if (nuovoMedia instanceof Movie) movieLibrary.add(nuovoMedia);
                        if (nuovoMedia instanceof Song) songLibrary.add(nuovoMedia);
                        System.out.println("Media added successfully!");
                    } else {
                        System.out.println("Invalid type of media.");
                    }
                    break;
                case 6:
                    System.out.print("Insert media title to remove: ");
                    String titoloDaRimuovere = scanner.nextLine().trim().toLowerCase();
                    
                    List<Media> mediaTrovati = new ArrayList<>();
                    for (Media m : mediaLibrary.getMediaItems()) {
                        if (m.getTitle().toLowerCase().equals(titoloDaRimuovere)) {
                            mediaTrovati.add(m);
                        }
                    }
                    
                    if (mediaTrovati.isEmpty()) {
                        System.out.println("Media not found.");
                    } else if (mediaTrovati.size() == 1) {
                        Media daRimuovere = mediaTrovati.get(0);
                        mediaLibrary.removeMedia(daRimuovere);
                        movieLibrary.remove(daRimuovere);
                        songLibrary.remove(daRimuovere);
                        System.out.println("Media removed successfully!");
                    } else {
                        System.out.println("Multiple media items found with the same title:");
                        for (int i = 0; i < mediaTrovati.size(); i++) {
                            System.out.println((i + 1) + ". " + mediaTrovati.get(i));
                        }
                        System.out.print("Choose the number of the media to remove: ");
                        int scelta = scanner.nextInt();
                        scanner.nextLine(); // Consuma invio
                    
                        if (scelta > 0 && scelta <= mediaTrovati.size()) {
                            Media daRimuovere = mediaTrovati.get(scelta - 1);
                            mediaLibrary.removeMedia(daRimuovere);
                            movieLibrary.remove(daRimuovere);
                            songLibrary.remove(daRimuovere);
                            System.out.println("Media removed successfully!");
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    }                
                        break;

                case 7:
                System.out.print("Insert the title of the media to play: ");
                String titleToPlay = scanner.nextLine().trim().toLowerCase();
            
                List<Media> mediaTrovatiDaRiprodurre = new ArrayList<>();
                for (Media m : mediaLibrary.getMediaItems()) {
                    if (m.getTitle().toLowerCase().equals(titleToPlay)) {
                        mediaTrovatiDaRiprodurre.add(m);
                    }
                }
            
                if (mediaTrovatiDaRiprodurre.isEmpty()) {
                    System.out.println("Media not found.");
                } else if (mediaTrovatiDaRiprodurre.size() == 1) {
                    mediaPlayer.play(mediaTrovatiDaRiprodurre.get(0));
                } else {
                    System.out.println("Multiple media items found with the same title:");
                    for (int i = 0; i < mediaTrovatiDaRiprodurre.size(); i++) {
                        System.out.println((i + 1) + ". " + mediaTrovatiDaRiprodurre.get(i));
                    }
                    System.out.print("Choose the number of the media to play: ");
                    int sceltaPlay = scanner.nextInt();
                    scanner.nextLine(); // Consuma invio
            
                    if (sceltaPlay > 0 && sceltaPlay <= mediaTrovatiDaRiprodurre.size()) {
                        mediaPlayer.play(mediaTrovatiDaRiprodurre.get(sceltaPlay - 1));
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
                    break;

                case 8:
                    mediaPlayer.pause();
                    break;

                case 9:
                    mediaPlayer.resume();
                    break;

                case 10:
                    mediaPlayer.stop();
                    break;

                case 11:
                    mediaPlayer.next(mediaLibrary.getMediaItems());
                    break;

                case 12:  // Salva la libreria su file con nome fisso
                    String workingDirectory = System.getProperty("user.dir");
                    String fileName = "library.txt";
                    String fullPath = workingDirectory + System.getProperty("file.separator") + fileName;

                    mediaLibrary.saveToFile(fullPath);
                    System.out.println("\nLibrary saved to: " + fullPath);
                    break;

                case 13:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, retry.");
            }

        } while (choice != 13);

        scanner.close();
    }
}
