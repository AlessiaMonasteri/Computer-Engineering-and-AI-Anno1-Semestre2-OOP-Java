import java.time.Year;

public class AgeUtils {
    public static int calculateAge(int birthYear) {
        int currentYear = Year.now().getValue();
        return currentYear - birthYear;
    }
}

