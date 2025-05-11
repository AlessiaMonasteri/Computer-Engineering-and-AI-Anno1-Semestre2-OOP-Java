package utilities;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import user.User;


public class Utils {

    public static String sanitize(String input) {
        return input.replaceAll("[^a-zA-Z0-9àèéìòù'\\s]", "").trim();
    }

    public static void loadUserCredentials(Map<String, User> users) throws IOException {
        // Percorso relativo al file delle credenziali (users.properties)
        File file = new File("C:\\Users\\Utente\\OneDrive\\Desktop\\Documenti\\Epicode-Laurea\\CORSI\\Anno 1\\Semestre 2\\Object Oriented Programming\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\oop_exam\\users.properties");
        
        if (!file.exists()) {
            throw new IOException("The credentials file does not exist: " + file.getAbsolutePath());
        }
        
        Properties credentials = new Properties();
        
        try (InputStream input = new FileInputStream(file)) {
            credentials.load(input);
            for (String username : credentials.stringPropertyNames()) {
                users.put(username, new User(username, credentials.getProperty(username)));
            }
        }
    }
}

