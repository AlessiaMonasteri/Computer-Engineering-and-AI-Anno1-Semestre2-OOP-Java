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
        users.put("admin", new User("admin", "admin123"));
        users.put("giovanni", new User("giovanni", "password1"));
    }

    @Test
    public void testLoginSuccess() {
        String inputUsername = "admin";

        User user = users.get(inputUsername);
        assertNotNull(user);
        assertEquals("admin", user.getUsername());
        assertEquals("admin123", user.getPassword());
    }

    @Test
    public void testLoginFailure() {
        String inputUsername = "admin";
        String inputPassword = "wrongPassword";

        User user = users.get(inputUsername);
        assertNotNull(user);
        assertNotEquals(inputPassword, user.getPassword());
    }
}
