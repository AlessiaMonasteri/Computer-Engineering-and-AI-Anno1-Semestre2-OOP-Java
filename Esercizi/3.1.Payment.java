import java.lang.annotation.*;
import java.lang.reflect.Method;

// Definizione dell'annotazione LogExecution
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecution {
    String value() default "Executing method";
}

// Definizione dell'interfaccia PaymentProcessor
interface PaymentProcessor {
    void processPayment(double amount);
}

// Implementazione di PaypalPayment (completamento della classe)
class PaypalPayment implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

// Implementazione di CreditCardPayment con annotazione LogExecution
class CreditCardPayment implements PaymentProcessor {
    @LogExecution("Processing credit card payment")
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

// Classe PaymentService che esegue il pagamento e logga l'annotazione
class PaymentService {
    public static void executePayment(PaymentProcessor processor, double amount) throws Exception {
        // Ottieni il metodo processPayment dalla classe del processore
        Method method = processor.getClass().getMethod("processPayment", double.class);

        // Verifica se il metodo ha l'annotazione LogExecution
        if (method.isAnnotationPresent(LogExecution.class)) {
            LogExecution logAnnotation = method.getAnnotation(LogExecution.class);
            System.out.println("LOG: " + logAnnotation.value());
        }
        
        // Esegui il pagamento
        processor.processPayment(amount);
    }
}


