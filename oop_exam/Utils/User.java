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

    //Usata nella riproduzione di un media
    public static int getRequiredAge(String prohibition) {
        switch (prohibition) {
            case "VM 18":
            case "PEGI 18":
                return 18;
            case "VM 16":
            case "PEGI 16":
                return 16;
            case "VM 14":
                return 14;
            case "PEGI 12":
                return 12;
            case "PEGI 7":
                return 7;
            case "PEGI 3":
                return 3;
            default:
                return 0;
        }
    }
    
    public boolean checkPassword(String inputPassword) {
        return BCrypt.checkpw(inputPassword, this.hashedPassword);
    }

}
