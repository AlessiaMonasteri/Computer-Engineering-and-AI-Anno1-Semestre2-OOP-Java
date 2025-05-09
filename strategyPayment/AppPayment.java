interface PaymentStrategy {
    void pay(double amount);
   }
   class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
    System.out.println("Paid $" + amount + " with Credit Card.");
    }
   }
   class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
    System.out.println("Paid $" + amount + " using PayPal.");
    }
   }
public class AppPayment {
    public static void main(String[] args) throws Exception {
    Order order1 = new Order(new CreditCardPayment());
    order1.processPayment(100);
    Order order2 = new Order(new PayPalPayment());
    order2.processPayment(200);
    }
   }
