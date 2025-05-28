import java.time.Year;

public class User {
    private String username;
    private String password;
    private int birthYear;

    public User(String username, String password, int birthYear) {
        this.username = username;
        this.password = password;
        this.birthYear = birthYear;
    }

    public String getUsername() {
        return username;
    }

    String getPassword() { 
        return password;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - birthYear;
    }
    
    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
