import java.io.Console;
import java.util.Scanner;

public class PasswordPrompt {
    public static String getPassword(String prompt, Scanner scanner) {
        Console console = System.console();
        if (console != null) {
            System.out.print(prompt + " ");
            char[] passwordChars = console.readPassword(); // Senza parametro
            return new String(passwordChars);
        } else {
            System.out.print(prompt + " ");
            return scanner.nextLine();
        }
    }
}


