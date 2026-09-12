public class NotificationService {

      public void sendOrderConfirmation(String customerEmail, String orderId, double total) {
        System.out.println("Email to " + customerEmail + ": Order " + orderId + " confirmed. Total: $" + total);
    }
}
