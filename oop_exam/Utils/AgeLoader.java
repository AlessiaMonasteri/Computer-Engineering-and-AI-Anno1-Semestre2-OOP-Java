package Utils;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AgeLoader {
    //Carica da un file di testo del tipo nomeUtente = annoNascita con le date di nascita degli utenti
    public static Map<String, Integer> loadAgesFromFile(String filePath) {
        //E costruisce una Map<String, Integer> dove la chiave è il nome utente (username) e il valore è l’anno di nascita (birthYear)
        Map<String, Integer> ages = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (!line.isEmpty() && line.contains("=")) {
                    //Divide la riga in due parti: prima del = e dopo, limitando la divisione a massimo due elementi
                    String[] parts = line.split("=", 2);

                    String username = parts[0].trim();
                    int birthYear = Integer.parseInt(parts[1].trim());
                    
                    ages.put(username, birthYear);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading ages file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid birth year format in file: " + e.getMessage());
        }
        return ages;
    }
}


