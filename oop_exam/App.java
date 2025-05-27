import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {


    public static void main(String[] args) {

        Map<String, User> users = UserLoader.loadUsersFromFile("C:\\Users\\Utente\\OneDrive\\Desktop\\Documenti\\Epicode-Laurea\\CORSI\\Anno 1\\Semestre 2\\Object Oriented Programming\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\oop_exam\\users.properties");

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
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "The Lion King", "Roger Allers, Rob Minkoff", 1994, "Animation", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "Hereditary", "Ari Aster", 2018, "Horror", "", "", "+18"));
        mediaLibrary.addMedia(MediaFactory.createMedia("movie", "The Conjuring", "James Wan", 2013, "Horror", "", "", "+18"));


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
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "The Legend of Zelda: Breath of the Wild", "Nintendo EPD", 2017, "adventure", "", "Nintendo Switch", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "God of War", "Santa Monica Studio", 2018, "action", "", "PlayStation 4", "+18"));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "Red Dead Redemption 2", "Rockstar Games", 2018, "action", "", "PlayStation 4 / Xbox One / PC", "+18"));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "Super Mario Odyssey", "Nintendo EPD", 2017, "platform", "", "Nintendo Switch", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("game", "Halo Infinite", "343 Industries", 2021, "fps", "", "Xbox Series X/S / Xbox One / PC", ""));

        //Aggiunta podcast
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "The Daily", "The New York Times", 2017, "news", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Stuff You Should Know", "iHeartRadio", 2008, "education", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Serial", "Sarah Koenig", 2014, "true crime", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Radiolab", "WNYC Studios", 2002, "science", "", "", ""));
        mediaLibrary.addMedia(MediaFactory.createMedia("podcast", "Armchair Expert", "Dax Shepard", 2018, "interview", "", "", ""));

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
            System.out.println("4.  Display Games");
            System.out.println("5.  Display Podcasts");
            System.out.println("6.  Search for media");
            System.out.println("7.  Add a new item");
            System.out.println("8.  Remove an existing item");
            System.out.println("9.  Play a media item");
            System.out.println("10. Pause");
            System.out.println("11. Resume");
            System.out.println("12. Stop");
            System.out.println("13. Play Next");
            System.out.println("14. Save library to file");
            System.out.println("15. Exit Program");
            
            //Per leggere la scelta dell'utente
            while (true) {
                System.out.print("\nChoose an option (1-15): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consuma newline
                    if (choice >= 1 && choice <= 15) {
                        break; // Valido
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 15.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 15.");
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

                            if (searchChoice == 5) {
                                stayInSearchMenu = false;
                                break;
                            }

                            List<Media> searchResults = new ArrayList<>();

                            switch (searchChoice) {
                                case 1:
                                    System.out.print("Enter title to search: ");
                                    String titleSearch = scanner.nextLine().trim().toLowerCase();
                                    for (Media media : mediaLibrary.getMediaItems()) {
                                        if (media.getTitle().toLowerCase().equals(titleSearch)) {
                                            searchResults.add(media);
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter author to search: ");
                                    String authorSearch = scanner.nextLine().trim().toLowerCase();
                                    for (Media media : mediaLibrary.getMediaItems()) {
                                        if (media.getAuthor().toLowerCase().equals(authorSearch)) {
                                            searchResults.add(media);
                                        }
                                    }
                                    break;
                                case 3:
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
                                    System.out.print("Enter genre to search: ");
                                    String genreSearch = scanner.nextLine().trim().toLowerCase();
                                    for (Media media : mediaLibrary.getMediaItems()) {
                                        if (media instanceof Movie && ((Movie) media).getGenre().toLowerCase().equals(genreSearch)
                                            || media instanceof Song && ((Song) media).getGenre().toLowerCase().equals(genreSearch)
                                            || media instanceof Game && ((Game) media).getGenre().toLowerCase().equals(genreSearch)
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
                                for (Media result : searchResults) {
                                    System.out.println(result);
                                }
                            } else {
                                System.out.println("No media found matching the search criteria.");
                                // Si rimane nel menu di ricerca
                            }
                        }
                        break;

                    
                    case 7:
                        // Aggiunta nuovo elemento multimediale
                        scanner.nextLine();
                        System.out.print("What type of media would you like to add? (movie/song/game/podcast): ");
                        String type = scanner.nextLine();

                        System.out.print("Title: ");
                        String title_inserted = scanner.nextLine();

                        System.out.print("Author/Director: ");
                        String author_inserted = scanner.nextLine();

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

                        System.out.print("Genre: ");
                        String genre_inserted = scanner.nextLine();

                        String album_inserted = null;
                        if (type.equalsIgnoreCase("song")) {
                            System.out.print("Album: ");
                            album_inserted = scanner.nextLine();
                            if (album_inserted.trim().isEmpty()) album_inserted = "Unknown";
                        }

                        String console_inserted = null;
                        if (type.equalsIgnoreCase("game")) {
                            System.out.print("Console: ");
                            console_inserted = scanner.nextLine();
                            if (console_inserted.trim().isEmpty()) console_inserted = "Unknown";
                        }

                        String prohibition_inserted = null;
                        if (type.equalsIgnoreCase("movie") || type.equalsIgnoreCase("game")) {
                            System.out.print("Prohibition (type eventually '+18' or Enter): ");
                            prohibition_inserted = scanner.nextLine();
                            if (prohibition_inserted.trim().isEmpty()) prohibition_inserted = "Unknown";
                        }

                        try {
                            Media nuovoMedia = MediaFactory.createMedia(
                                type.toLowerCase(),
                                title_inserted,
                                author_inserted,
                                year_inserted,
                                genre_inserted,
                                album_inserted != null ? album_inserted : "",
                                console_inserted != null ? console_inserted : "",
                                prohibition_inserted != null ? prohibition_inserted : ""
                            );
                            mediaLibrary.addMedia(nuovoMedia);

                            if (nuovoMedia instanceof Movie) {
                                movieLibrary.add((Movie) nuovoMedia);
                            } else if (nuovoMedia instanceof Song) {
                                songLibrary.add((Song) nuovoMedia);
                            } else if (nuovoMedia instanceof Game) {
                                gameLibrary.add((Game) nuovoMedia);
                            } else if (nuovoMedia instanceof Podcast) {
                                podcastLibrary.add((Podcast) nuovoMedia);
                            }
                            System.out.println("Media added successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Input error: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Media creation error: " + e.getMessage());
                        }
                        break;


                    case 8:
                        scanner.nextLine();  // Consuma il newline residuo dopo nextInt()
                        System.out.print("Insert media title to remove: ");
                        String titleToRemove = scanner.nextLine().trim().toLowerCase();

                        List<Media> mediaTrovati = new ArrayList<>();
                        for (Media m : mediaLibrary.getMediaItems()) {
                            if (m.getTitle().toLowerCase().equals(titleToRemove)) {
                                mediaTrovati.add(m);
                            }
                        }

                        if (mediaTrovati.isEmpty()) {
                            System.out.println("Media not found.");
                        } else if (mediaTrovati.size() == 1) {
                            Media toRemove = mediaTrovati.get(0);
                            mediaLibrary.removeMedia(toRemove);
                            movieLibrary.remove(toRemove);
                            songLibrary.remove(toRemove);
                            System.out.println("Media removed successfully!");
                        } else {
                            System.out.println("Multiple media items found with the same title:");
                            for (int i = 0; i < mediaTrovati.size(); i++) {
                                System.out.println((i + 1) + ". " + mediaTrovati.get(i));
                            }
                            System.out.print("Choose the number of the media to remove: ");

                            int choice2;
                            try {
                                choice2 = Integer.parseInt(scanner.nextLine().trim());
                                if (choice2 > 0 && choice2 <= mediaTrovati.size()) {
                                    Media daRimuovere = mediaTrovati.get(choice2 - 1);
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
                        scanner.nextLine(); //Consuma il newline rimasto
                        System.out.print("Insert the title of the media to play: ");
                        String titleToPlay = scanner.nextLine().trim().toLowerCase();
                    
                        List<Media> mediaFoundToPlay = new ArrayList<>();
                        for (Media m : mediaLibrary.getMediaItems()) {
                            if (m.getTitle().toLowerCase().equals(titleToPlay)) {
                                mediaFoundToPlay.add(m);
                            }
                        }
                    
                        if (mediaFoundToPlay.isEmpty()) {
                            System.out.println("Media not found.");
                        } else if (mediaFoundToPlay.size() == 1) {
                            mediaPlayer.play(mediaFoundToPlay.get(0));
                        } else {
                            System.out.println("Multiple media items found with the same title:");
                            for (int i = 0; i < mediaFoundToPlay.size(); i++) {
                                System.out.println((i + 1) + ". " + mediaFoundToPlay.get(i));
                            }
                            System.out.print("Choose the number of the media to play: ");
                            int sceltaPlay = scanner.nextInt();
                            scanner.nextLine(); // Consuma invio
                    
                            if (sceltaPlay > 0 && sceltaPlay <= mediaFoundToPlay.size()) {
                                mediaPlayer.play(mediaFoundToPlay.get(sceltaPlay - 1));
                            } else {
                                System.out.println("Invalid selection.");
                            }
                        }
                            break;

                    case 10:
                        mediaPlayer.pause();
                        break;

                    case 11:
                        mediaPlayer.resume();
                        break;

                    case 12:
                        mediaPlayer.stop();
                        break;

                    case 13:
                        mediaPlayer.next(mediaLibrary.getMediaItems());
                        break;

                    case 14:  // Salva la libreria su file con nome fisso
                        String workingDirectory = System.getProperty("user.dir");
                        String fileName = "library.txt";
                        String fullPath = workingDirectory + System.getProperty("file.separator") + fileName;

                        mediaLibrary.saveToFile();
                        System.out.println("\nLibrary saved to: " + fullPath);
                        break;

                    case 15:
                        System.out.println("Exiting program...");
                        break;
                }
            } while (choice != 15);

        scanner.close();
    }
    }

