package Utils;
import org.mindrot.jbcrypt.BCrypt;
import java.time.Year;

public class User {
    private String username;
    private String hashedPassword;
    private int birthYear;

    public User(String username, String password, int birthYear) {
        this.username = username;
        this.hashedPassword = password;
        this.birthYear = birthYear;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { 
        return hashedPassword;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - birthYear;
    }
    
    public boolean checkPassword(String inputPassword) {
        return BCrypt.checkpw(inputPassword, this.hashedPassword);
    }

}
