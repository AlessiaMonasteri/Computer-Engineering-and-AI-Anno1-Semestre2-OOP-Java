import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAddMethod(){
        assertEquals(Calculator.add(1,2,3,4,5),15);
    }
}
