// Classe principale per testare l'esecuzione
public class Main {
    public static void main(String[] args) throws Exception {
        PaymentProcessor paypalPayment = new PaypalPayment();
        PaymentProcessor creditCardPayment = new CreditCardPayment();

        // Esegui il pagamento con PayPal
        System.out.println("Testing PayPal Payment:");
        PaymentService.executePayment(paypalPayment, 100.0);

        // Esegui il pagamento con Credit Card
        System.out.println("\nTesting Credit Card Payment:");
        PaymentService.executePayment(creditCardPayment, 50.0);
    }
}
