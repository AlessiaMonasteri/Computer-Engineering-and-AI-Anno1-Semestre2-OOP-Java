package Utils;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UserLoader {

    public static Map<String, User> loadUsersFromFile(String userPath, String agePath) {

        Map<String, User> users = new HashMap<>();
        Map<String, Integer> ages = AgeLoader.loadAgesFromFile(agePath);

        try (Scanner scanner = new Scanner(new File(userPath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty() && line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    //Il default dell'anno di nascita è settato su un numero molto grande (3000),
                    //in modo tale che se non viene inserito nessun anno per cercare di bypassare il controllo VM18,
                    //l'età calcolata sarà un numero molto negativo (che comparità come Unknown Age)
                    int birthYear = ages.getOrDefault(username,3000);
                    users.put(username, new User(username, password, birthYear));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading users file: " + e.getMessage());
        }
        return users;
    }
}


