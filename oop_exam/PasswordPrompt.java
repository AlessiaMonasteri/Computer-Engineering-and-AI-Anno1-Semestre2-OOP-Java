import java.io.Console;
import java.util.Scanner;

public class PasswordPrompt {

// In PasswordPrompt.java
public static String getPassword(String prompt, Scanner scanner) {
    Console console = System.console();
    if (console != null) {
        char[] passwordChars = console.readPassword(prompt);
        return new String(passwordChars);
    } else {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}

}

