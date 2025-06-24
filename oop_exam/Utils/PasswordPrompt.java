package Utils;

import java.io.Console;
import java.util.Scanner;

//Per il get sicuro della password
public class PasswordPrompt {
    public static String getPassword(String prompt, Scanner scanner) {

        Console console = System.console();

        //Controlla se la console è disponibile
        if (console != null) {

            //Mostra il messaggio richiesto senza andare a capo
            System.out.print(prompt + " ");
            
            //Non mostra il testo digitato sullo schermo
            char[] passwordChars = console.readPassword();

            //Converte l’array di caratteri in String
            return new String(passwordChars);

        } else {
            System.out.print(prompt + " ");
            return scanner.nextLine();
        }
    }
}


