import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UserLoader {

    public static Map<String, User> loadUsersFromFile(String filePath) {
        Map<String, User> users = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty() && line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    users.put(username, new User(username, password));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading users file: " + e.getMessage());
        }
        return users;
    }
}
