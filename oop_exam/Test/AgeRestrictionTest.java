package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import Library.Movie;
import Utils.User;


//Verifica che un utente possa o non possa riprodurre un media
//in base al proprio age e al codice VM / PEGI del media

public class AgeRestrictionTest {

    private Movie vm18Movie;
    private Movie vm14Movie;

    private User user17;   //17 anni
    private User user18;   //18 anni

    @Before
    public void setUp() {

        // Film con restrizione
        vm18Movie = new Movie("Saw", "James Wan", 2004, "Horror", "VM 18");
        vm14Movie = new Movie("The Ring", "Gore Verbinski", 2002, "Horror", "VM 14");

        user17 = new User("teen17", "dummyHash", 2008);
        user18 = new User("adult18", "dummyHash", 2007);
    }

    @Test
    public void minorCannotPlayVM18() {
        int requiredAge = User.getRequiredAge(vm18Movie.getProhibition());
        assertTrue("La restrizione VM 18 deve valere 18 anni", requiredAge == 18);

        boolean canPlay = user17.getAge() >= requiredAge;
        assertFalse("Il 17enne NON deve riprodurre VM 18", canPlay);
    }


    //Utente 18enne PUÒ riprodurre un VM14
    @Test
    public void adultCanPlayVM14() {
        int requiredAge = User.getRequiredAge(vm14Movie.getProhibition());
        assertTrue("La restrizione VM14 deve valere 14 anni", requiredAge == 14);

        boolean canPlay = user18.getAge() >= requiredAge;
        assertTrue("L'adulto deve riprodurre VM 14", canPlay);

    }
}

