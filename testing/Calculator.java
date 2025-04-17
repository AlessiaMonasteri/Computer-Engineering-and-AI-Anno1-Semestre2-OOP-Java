public class Calculator {

    public static int add (int... numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
        }
    }