import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Library.Game;
import Library.Media;
import Library.MediaFactory;
import Library.MediaIterator;
import Library.MediaLibrary;
import Library.MediaPlayer;
import Library.Movie;
import Library.Podcast;
import Library.Song;
import Utils.MediaExporter;
import Utils.PasswordPrompt;
import Utils.User;
import Utils.UserLoader;

public class App {

    public static void main(String[] args) {

/*--------------------------------------------INITIAL CONTENT--------------------------------------------- */

        //Lancio dell'applicazione
        System.out.println("Launching the Media app...");

        // Creazione della libreria multimediale usando il Composite Pattern
        MediaLibrary mediaLibrary = new MediaLibrary();

        // Aggiunta Movies
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Interstellar", "Christopher Nolan", 2014, "Sci-Fi", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Pulp Fiction", "Quentin Tarantino", 1994, "Crime", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Schindler's List", "Steven Spielberg", 1993, "Drama", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Titanic", "James Cameron", 1997, "Romance", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Avatar", "James Cameron", 2009, "Sci-Fi", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Inception", "Christopher Nolan", 2010, "Sci-Fi", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "The Revenant", "Alejandro González Iñárritu", 2015, "Drama", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "The Lion King", "Roger Allers - Rob Minkoff", 1994, "Animation", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Hereditary", "Ari Aster", 2018, "Horror", "", "", "VM 18"));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "The Conjuring", "James Wan", 2013, "Horror", "", "", "VM 18"));

        //Aggiunta Songs
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Bohemian Rhapsody", "Queen", 1975, "Rock", "A Night at the Opera", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Hotel California", "Eagles", 1976, "Rock", "Hotel California", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Smells Like Teen Spirit", "Nirvana", 1991, "Grunge", "Nevermind", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Thriller", "Michael Jackson", 1982, "Pop", "Thriller", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Stairway to Heaven", "Led Zeppelin", 1971, "Rock", "Led Zeppelin IV", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Imagine", "John Lennon", 1971, "Pop", "Imagine", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Like a Rolling Stone", "Bob Dylan", 1965, "Folk", "Highway 61 Revisited", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "La Noia", "Angelina Mango", 2024, "Pop", "Poké melodrama", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Alba", "Ultimo", 2023, "Pop", "Alba", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("song", "Amare", "La Rappresentante di Lista", 2021, "Pop", "My Mamma", "", ""));

        //Aggiunta games
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "The Legend of Zelda", "Nintendo EPD", 2017, "Adventure", "", "Nintendo Switch", "PEGI 16"));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "God of War", "Santa Monica Studio", 2018, "Action", "", "PlayStation 4", "PEGI 18"));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "Red Dead Redemption 2", "Rockstar Games", 2018, "Action", "", "PlayStation 4 / Xbox One / PC", "PEGI 18"));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "Super Mario Odyssey", "Nintendo EPD", 2017, "Platform", "", "Nintendo Switch", "PEGI 7"));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "Halo Infinite", "343 Industries", 2021, "Fps", "", "Xbox Series X/S / Xbox One / PC", "PEGI 16"));

        //Aggiunta podcast
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "The Daily", "The New York Times", 2017, "News", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Stuff You Should Know", "iHeartRadio", 2008, "Education", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Serial", "Sarah Koenig", 2014, "True crime", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Radiolab", "WNYC Studios", 2002, "Science", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Armchair Expert", "Dax Shepard", 2018, "Interview", "", "", ""));

        //Creazione di 4 liste per Film, Musica, Giochi, Podcast
        List<Media> movieLibrary = new ArrayList<>();
        List<Media> songLibrary = new ArrayList<>();
        List<Media> gameLibrary = new ArrayList<>();
        List<Media> podcastLibrary = new ArrayList<>();

        //Insert nella lista pertinente in base al tipo
        for (Media media : mediaLibrary.getMediaItems()) {
            if (media instanceof Movie) {
                movieLibrary.add(media);
            } else if (media instanceof Song) {
                songLibrary.add(media);
            } else if (media instanceof Game) {
                gameLibrary.add(media);
            } else if (media instanceof Podcast){
                podcastLibrary.add(media);
            }
        }

        //Creazione di un MediaPlayer per gestire la riproduzione
        MediaPlayer mediaPlayer = new MediaPlayer();
                
/*--------------------------------------------LOGIN--------------------------------------------- */

        //Carica dai due files le credenziali degli utenti e le loro età e li organizza in una map
        Map<String, User> users = UserLoader.loadUsersFromFile(
        "C:\\Users\\Utente\\OneDrive\\Desktop\\Documenti\\Epicode-Laurea\\CORSI\\Anno 1\\Semestre 2\\Object Oriented Programming\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\oop_exam\\Utils\\users_hash.properties",
        "C:\\Users\\Utente\\OneDrive\\Desktop\\Documenti\\Epicode-Laurea\\CORSI\\Anno 1\\Semestre 2\\Object Oriented Programming\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\oop_exam\\Utils\\users_ages.properties"
    );

        //Numero tentativi per l'accesso
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        int loginAttempts = 3;
        User user = null;
        
        //Se l'utente non ha effettuato il login correttamente e ci sono ancora tentatovi di accesso disponibii
        while (!loggedIn && loginAttempts > 0) {
            System.out.print("Username: ");
            String inputUsername = scanner.nextLine().trim();
            //Acquisizione della password mascherata
            String inputPassword = PasswordPrompt.getPassword("Enter your password:", scanner);
            //Verifica dell'utente
            user = users.get(inputUsername);
            //Se esiste un utente con quello username e la password è corretta
            // Sanitize input
            if (!inputUsername.matches("^[a-zA-Z0-9_]{3,20}$")) {
                System.out.println("Invalid username format.");
                continue;
            }
            if (user != null && user.checkPassword(inputPassword)) {
                System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
                //se non viene inserita l'età, invece di mostrare un numero molto negativo (che non avrebbe senso), mostra Unknown age come msg iniziale. 
                //Non è comunque permesso guardare contenuti VM18
                //vedi riga 20 UserLoader.java
                if (user.getAge()<0){
                   System.out.println("User age: Unknown age"); 
                } else {
                System.out.println("User age: " + user.getAge());
                }
                loggedIn = true;
            } else {
                loginAttempts--;
                System.out.println("Invalid credentials. Attempts remaining: " + loginAttempts);
            }
        }
        //Uscita dal programma a causa di troppi tentativi
        if (!loggedIn) {
            System.out.println("Too many failed login attempts. Exiting program.");
            scanner.close();
            return;
        }
/*--------------------------------------------MENU--------------------------------------------- */

        int choice;
        //Voci del menu
        do {
            System.out.println("\nMENU\n");
            System.out.println("1.  Display all items in the library");
            System.out.println("2.  Display Movies");
            System.out.println("3.  Display Songs");
            System.out.println("4.  Display Games");
            System.out.println("5.  Display Podcasts");
            System.out.println("6.  Search for media");
            System.out.println("7.  Add a new item");
            System.out.println("8.  Remove an existing item");
            System.out.println("9.  Play");
            System.out.println("10. Pause");
            System.out.println("11. Stop");
            System.out.println("12. Play Next");
            System.out.println("13. Export CSV");
            System.out.println("14. Exit Program");
            
            //Per leggere la scelta dell'utente
            while (true) {
                System.out.print("\nChoose an option (1-14): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consuma newline
                    if (choice >= 1 && choice <= 15) {
                        break; // Valido
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 14.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 14.");
                    scanner.nextLine(); // Consuma input errato
                }
            }

                //Costrutto switch per eseguire azioni in base alla scelta dell'utente
                switch (choice) {
                    case 1:
                        //Ordinamento per type dopo l'inserimento di un item
                        mediaLibrary.getMediaItems().sort(Comparator.comparing(media -> {
                        if (media instanceof Movie) return 1;
                        else if (media instanceof Song) return 2;
                        else if (media instanceof Game) return 3;
                        else if (media instanceof Podcast) return 4;
                        else return 5;
                        }));

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
                        //Mostra tutte i giochi nella libreria
                        System.out.println("Games in the library:");
                        for (Media game : gameLibrary) {
                            System.out.println(game);
                        }
                        break;
                    case 5: 
                        //Mostra tutti i podcast nella libreria
                        System.out.println("Podcasts in the library:");
                        for (Media podcast : podcastLibrary) {
                            System.out.println(podcast);
                        }
                        break;
                    case 6:
                        //Ricerca di un media
                        boolean stayInSearchMenu = true;
                        while (stayInSearchMenu) {
                            System.out.println("\nSearch media by:");
                            System.out.println("1. Title");
                            System.out.println("2. Author");
                            System.out.println("3. Year");
                            System.out.println("4. Genre");
                            System.out.println("5. Back to main menu");

                            int searchChoice;
                            while (true) {
                                //Per leggere la scelta dell'utente
                                System.out.print("Enter your choice (1-5): ");
                                if (scanner.hasNextInt()) {
                                    searchChoice = scanner.nextInt();
                                    scanner.nextLine(); // Consuma il newline
                                    if (searchChoice >= 1 && searchChoice <= 5) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                                    }
                                } else {
                                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                                    scanner.nextLine(); // Pulisce l'input errato
                                }
                            }
                            //Uscita dal sottomenu di ricerca
                            if (searchChoice == 5) {
                                stayInSearchMenu = false;
                                break;
                            }
                            //Creazione lista per l'output di ricerca
                            List<Media> searchResults = new ArrayList<>();

                            switch (searchChoice) {
                                case 1:
                                    //Ricerca per titolo
                                    System.out.print("Enter title to search: ");
                                    String titleSearch = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();
                                    for (Media media : mediaLibrary.getMediaItems()) {
                                        if (media.getTitle().toLowerCase().contains(titleSearch)) {
                                            searchResults.add(media);
                                        }
                                    }
                                    break;
                                case 2:
                                    //Ricerca per autore
                                    System.out.print("Enter author to search: ");
                                    String authorSearch = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();
                                    for (Media media : mediaLibrary.getMediaItems()) {
                                        if (media.getAuthor().toLowerCase().contains(authorSearch)) {
                                            searchResults.add(media);
                                        }
                                    }
                                    break;
                                case 3:
                                    //Ricerca per anno
                                    System.out.print("Enter year to search: ");
                                    if (scanner.hasNextInt()) {
                                        int yearSearch = scanner.nextInt();
                                        scanner.nextLine(); // Consuma newline
                                        for (Media media : mediaLibrary.getMediaItems()) {
                                            if (media.getYear() == yearSearch) {
                                                searchResults.add(media);
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid year format.");
                                        scanner.nextLine(); // Pulisce input errato
                                    }
                                    break;
                                case 4:
                                    //Ricerca per genere
                                    System.out.print("Enter genre to search: ");
                                    String genreSearch = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();
                                    for (Media media : mediaLibrary.getMediaItems()) {
                                        if (media instanceof Movie && ((Movie) media).getGenre().toLowerCase().contains(genreSearch)
                                            || media instanceof Song && ((Song) media).getGenre().toLowerCase().contains(genreSearch)
                                            || media instanceof Game && ((Game) media).getGenre().toLowerCase().contains(genreSearch)
                                            || media instanceof Podcast && ((Podcast) media).getGenre().toLowerCase().contains(genreSearch)) {
                                            searchResults.add(media);
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid search option.");
                                    continue;
                            }

                            if (!searchResults.isEmpty()) {
                                System.out.println("Search results:");
                                //forEach per scorrere gli elementi della collection
                                //per ogni oggetto result di tipo Media contenuto nella collezione searchResults
                                for (Media result : searchResults) {
                                    System.out.println(result);
                                }
                            } else {
                                //Si rimane nel menu di ricerca
                                System.out.println("No media found matching the search criteria.");
                            }
                        }
                        break;

                    case 7:
                        //Aggiunta di un nuovo media
                        boolean validType = false;
                        String type = "";

                        //validità del tipo di media inserito
                        while (!validType) {
                            System.out.print("What type of media would you like to add? (movie/song/game/podcast): ");
                            type = scanner.nextLine().trim().toLowerCase();
                            if (type.equals("movie") || type.equals("song") || type.equals("game") || type.equals("podcast")) {
                                validType = true;
                            } else {
                                System.out.println("Invalid type! Please enter one of the following: movie, song, game, podcast.");
                            }
                        }

                        //Insert del campo Title (comune per tutti i tipi di media)
                        System.out.print("Title: ");
                        String title_inserted = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();


                        //Insert del campo Autore/Direttore (comune per tutti i tipi di media)
                        System.out.print("Author/Director: ");
                        String author_inserted = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();

                        //Insert del campo Anno (comune per tutti i tipi di media)
                        int year_inserted = 0;
                        boolean validYear = false;
                        while (!validYear) {
                            System.out.print("Year: ");
                            if (scanner.hasNextInt()) {
                                year_inserted = scanner.nextInt();
                                scanner.nextLine();
                                if (year_inserted >= 1900 && year_inserted <= 2100) {
                                    validYear = true;
                                } else {
                                    System.out.println("Invalid year. Please enter a year between 1900 and 2100.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a valid integer for the year.");
                                scanner.nextLine();
                            }
                        }

                        //Insert del campo Genere (comune per tutti i tipi di media)
                        System.out.print("Genre: ");
                        String genre_inserted = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();

                        //Insert del campo Album (presente solo nelle Songs)
                        String album_inserted = null;
                        if (type.equalsIgnoreCase("song")) {
                            System.out.print("Album: ");
                            album_inserted = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();
                            if (album_inserted.trim().isEmpty()) album_inserted = "Unknown";
                        }

                        //Insert del campo Console (presente solo nei Games)
                        String console_inserted = null;
                        if (type.equalsIgnoreCase("game")) {
                            System.out.print("Console: ");
                            console_inserted = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();
                            if (console_inserted.trim().isEmpty()) console_inserted = "Unknown";
                        }

                        //Insert del campo Prohibition (presente solo nei Film o nei Games)

                        String prohibitionInserted = null;
                        int min = 0, max = 0, prohibitionChoice;
                        String submenuGame = "Choose the PEGI:\n1. PEGI 3\n2. PEGI 7\n3. PEGI 12\n4. PEGI 16\n5. PEGI 18\n";
                        if (type.equalsIgnoreCase("game")) {
                            min = 1; max = 5;
                            System.out.println(submenuGame);
                            do {
                                System.out.print("Insert a valid number between " + min + " and " + max + ":\n");
                                while (!scanner.hasNextInt()) {
                                    //controlla che venga inserito un numero nel range
                                    System.out.println("Insert a valid number between " + min + " and " + max + ":");
                                    //Scarta l'input errato
                                    scanner.next(); 
                                    continue;
                                }
                            prohibitionChoice = scanner.nextInt();
                        } while (prohibitionChoice < min || prohibitionChoice > max);
                                                if (type.equalsIgnoreCase("game")) {
                            switch (prohibitionChoice) {
                                case 1:
                                    prohibitionInserted = "PEGI 3";
                                    break;
                                case 2:
                                    prohibitionInserted = "PEGI 7";
                                    break;
                                case 3:
                                    prohibitionInserted = "PEGI 12";
                                    break;
                                case 4:
                                    prohibitionInserted = "PEGI 16";
                                    break;
                                case 5:
                                    prohibitionInserted = "PEGI 18";
                                    break;
                            }
                        } 
                        } 

                        if (type.equalsIgnoreCase("movie")) {
                            min = 1; max = 4;
                            String submenuMovie = "Choose the VM:\n1. VM 14\n2. VM 16\n3. VM 18\n4. No restriction\n";
                            System.out.print(submenuMovie);
                            do {
                                System.out.print("Insert a valid number between " + min + " and " + max + ":\n");
                                while (!scanner.hasNextInt()) {
                                    //controlla che venga inserito un numero nel range
                                    System.out.println("Insert a valid number between " + min + " and " + max + ":");
                                    //Scarta l'input errato
                                    scanner.next(); 
                                    continue;
                                }
                            prohibitionChoice = scanner.nextInt();
                            } while (prohibitionChoice < min || prohibitionChoice > max);
                                                    if (type.equalsIgnoreCase("movie")){
                            switch (prohibitionChoice) {
                                case 1:
                                    prohibitionInserted = "VM14";
                                    break;
                                case 2:
                                    prohibitionInserted = "VM16";
                                    break;
                                case 3:
                                    prohibitionInserted = "VM18";
                                    break;
                                case 4:
                                    prohibitionInserted = null;
                                    break;
                            }
                        }
                        }

                        //Aggiunta alla libreria
                        try {
                            Media newMedia = MediaFactory.createMedia(
                                type.toLowerCase(),
                                title_inserted,
                                author_inserted,
                                year_inserted,
                                genre_inserted,
                                album_inserted != null ? album_inserted : "",
                                console_inserted != null ? console_inserted : "",
                                prohibitionInserted != null ? prohibitionInserted : ""
                            );
                            mediaLibrary.addMedia(newMedia);

                            if (newMedia instanceof Movie) {
                                movieLibrary.add((Movie) newMedia);
                            } else if (newMedia instanceof Song) {
                                songLibrary.add((Song) newMedia);
                            } else if (newMedia instanceof Game) {
                                gameLibrary.add((Game) newMedia);
                            } else if (newMedia instanceof Podcast) {
                                podcastLibrary.add((Podcast) newMedia);
                            }
                            System.out.println("Media added successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Input error: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Media creation error: " + e.getMessage());
                        }
                        break;

                    //Rimozione di un media dalla libreria in base al titolo
                    case 8:
                        System.out.print("Insert media title to remove: ");
                        String titleToRemove = scanner.nextLine().trim().toLowerCase();
                        List<Media> mediaFound = new ArrayList<>();
                        for (Media m : mediaLibrary.getMediaItems()) {
                            if (m.getTitle().toLowerCase().equals(titleToRemove)) {
                                mediaFound.add(m);
                            }
                        }

                        if (mediaFound.isEmpty()) {
                            System.out.println("Media not found.");
                        } else if (mediaFound.size() == 1) {
                            Media toRemove = mediaFound.get(0);
                            mediaLibrary.removeMedia(toRemove);
                            movieLibrary.remove(toRemove);
                            songLibrary.remove(toRemove);
                            System.out.println("Media removed successfully!");
                        } else {
                            System.out.println("Multiple media items found with the same title:");
                            for (int i = 0; i < mediaFound.size(); i++) {
                                System.out.println((i + 1) + ". " + mediaFound.get(i));
                            }
                            System.out.print("Choose the number of the media to remove: ");

                            int removeChoice;
                            try {
                                removeChoice = Integer.parseInt(scanner.nextLine().trim());
                                if (removeChoice > 0 && removeChoice <= mediaFound.size()) {
                                    Media daRimuovere = mediaFound.get(removeChoice - 1);
                                    mediaLibrary.removeMedia(daRimuovere);
                                    movieLibrary.remove(daRimuovere);
                                    songLibrary.remove(daRimuovere);
                                    System.out.println("Media removed successfully!");
                                } else {
                                    System.out.println("Invalid selection.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                            }
                        }
                        break;

                        case 9:
                            // Riproduzione del media
                            System.out.print("Insert the title of the media to play: ");
                            String title = scanner.nextLine()
                                                .replaceAll("[^a-zA-Z0-9\\s]", "")
                                                .trim()
                                                .toLowerCase();

                            // Creazione della lista dei found da riprodurre
                            List<Media> mediaFoundToPlay = new ArrayList<>();
                            for (Media m : mediaLibrary.getMediaItems()) {
                                if (m.getTitle().equalsIgnoreCase(title)) {
                                    mediaFoundToPlay.add(m);
                                }
                            }

                            if (mediaFoundToPlay.isEmpty()) {
                                System.out.println("Media not found.");
                            } else if (mediaFoundToPlay.size() == 1) {
                                Media selectedMedia = mediaFoundToPlay.get(0);

                                int requiredAge = User.getRequiredAge(selectedMedia.getProhibition());
                                if (user.getAge() < requiredAge) {
                                    System.out.printf(
                                        "Access denied: You must be at least %d years old to play this content.%n",
                                        requiredAge
                                    );
                                } else {
                                    mediaPlayer.play(selectedMedia, user);
                                }

                            } else {
                                // Caso in cui ho più titoli uguali
                                System.out.println("Multiple media items found with the same title:");
                                for (int i = 0; i < mediaFoundToPlay.size(); i++) {
                                    System.out.println((i + 1) + ". " + mediaFoundToPlay.get(i));
                                }

                                System.out.print("Choose the number of the media to play: ");
                                int playChoice = scanner.nextInt();
                                scanner.nextLine(); // consuma invio

                                if (playChoice > 0 && playChoice <= mediaFoundToPlay.size()) {
                                    Media selectedMedia = mediaFoundToPlay.get(playChoice - 1);

                                    int requiredAge = User.getRequiredAge(selectedMedia.getProhibition());
                                    if (user.getAge() < requiredAge) {
                                        System.out.printf(
                                            "Access denied: You must be at least %d years old to play this content.%n",
                                            requiredAge
                                        );
                                    } else {
                                        mediaPlayer.play(selectedMedia, user);
                                    }
                                } else {
                                    System.out.println("Invalid selection.");
                                }
                            }
                            break;

                    case 10:
                        //Pausa del media
                        mediaPlayer.pause();
                        break;

                    case 11:
                        //Stop del media
                        mediaPlayer.stop();
                        break;

                    case 12:
                        //Riproduzione elemento succesivo
                        //NB: si procede in avanti nella libreria principale
                        //Quindi ad esempio è possibile passare dalla riproduzione di un film a una canzone
                        mediaPlayer.next(mediaLibrary.getMediaItems());
                        break;

                    case 13:
                        //Export
                        if (MediaExporter.exportToCSV(mediaLibrary.getMediaItems())) {
                            System.out.println("Export completed successfully.");
                        } else {
                            System.out.println("Export failed. Check file path or permissions.");
                        }
                        break;

                    case 14:
                        //Uscita dal programma
                        System.out.println("Exiting program...");
                        break;
                }
            } while (choice != 14);

        scanner.close();
    }
}


