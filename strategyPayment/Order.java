class Order {
    private PaymentStrategy paymentStrategy;
    public Order(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
    }
    public void processPayment(double amount) {
    paymentStrategy.pay(amount);
    }
   }

