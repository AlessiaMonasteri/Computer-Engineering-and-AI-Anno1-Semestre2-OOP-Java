package Test;

import org.junit.Test;
import Utils.User;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;
import org.junit.Before; 


public class TestLogin {

    private Map<String, User> users;

    @Before
    public void setup() {
        users = new HashMap<>();
        String hashedPassword = "$2a$10$NXJD98y4uJPed6bhHcOOeuTHl5U/BTgtEqWsKMpPriXHawXHXDBmK";
        users.put("prova", new User("prova", hashedPassword, 1990));
    }

    @Test
    public void testLoginSuccess() {
        String inputUsername = "prova";
        String inputPassword = "provaprova";

        User user = users.get(inputUsername);
        //Verifica che l'utente esista
        assertNotNull(user); 
        assertEquals("prova", user.getUsername());
        //Verifica che l'hash sia corretto
        assertTrue(user.checkPassword(inputPassword)); 
        //Controlla che l’età venga calcolata
        assertTrue(user.getAge() > 0);
    }

    @Test
    public void testLoginFailure() {
        String inputUsername = "prova";
        String inputPassword = "wrongPassword";

        User user = users.get(inputUsername);
        assertNotNull(user);
        assertFalse(user.checkPassword(inputPassword));
    }
}

