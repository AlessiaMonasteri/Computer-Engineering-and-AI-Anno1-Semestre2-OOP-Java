import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;
import org.junit.Before; 

public class TestLogin {

    private Map<String, User> users;

    @Before
    public void setup() {
        users = new HashMap<>();
        users.put("admin", new User("admin", "admin123", 1990));
    }

    @Test
    public void testLoginSuccess() {
        String inputUsername = "admin";
        String inputPassword = "admin123";

        User user = users.get(inputUsername);
        assertNotNull(user);
        assertEquals("admin", user.getUsername());
        assertTrue(user.checkPassword(inputPassword));
        assertTrue(user.getAge() > 0);  // controlla che l’età venga calcolata
    }

    @Test
    public void testLoginFailure() {
        String inputUsername = "admin";
        String inputPassword = "wrongPassword";

        User user = users.get(inputUsername);
        assertNotNull(user);
        assertFalse(user.checkPassword(inputPassword));
    }
}
