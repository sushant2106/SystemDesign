public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        NotificationService notifications = new NotificationService();
        OrderProcessor processor = new OrderProcessor(inventory, notifications);
        processor.placeOrder("LAPTOP", 2, "alice@example.com");
    }
}
