package Utils;

import org.mindrot.jbcrypt.BCrypt;

import java.io.*;

public class PasswordHasher {
    public static void main(String[] args) {
        //File non più esistente
        String inputPath = "C:\\Users\\Utente\\OneDrive\\Desktop\\Documenti\\Epicode-Laurea\\CORSI\\Anno 1\\Semestre 2\\Object Oriented Programming\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\oop_exam\\users.properties";
        
        String outputPath = "C:\\Users\\Utente\\OneDrive\\Desktop\\Documenti\\Epicode-Laurea\\CORSI\\Anno 1\\Semestre 2\\Object Oriented Programming\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\Computer-Engineering-and-AI-Anno1-Semestre2-OOP-Java\\oop_exam\\Utils\\users_hash.properties";

        //Per gestire automaticamente la chiusura di reader e writer
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            
            //Line contiene ogni riga letta dal file
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                //Verifica che la riga non sia vuota e contenga un '='
                if (!line.isEmpty() && line.contains("=")) {
                    //Divide la riga in due parti
                    String[] parts = line.split("=", 2);
                    //Parte username
                    String username = parts[0].trim();
                    //Parte password in chiaro
                    String plainPassword = parts[1].trim();
                    //Hash della password
                    String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
                     //Scrive nel file lo username e la hashedPassword come chiave=valore
                    writer.write(username + "=" + hashedPassword);
                    writer.newLine(); //Va a capo
                }
            }

            System.out.println("Conversion completed. File saved to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
}

