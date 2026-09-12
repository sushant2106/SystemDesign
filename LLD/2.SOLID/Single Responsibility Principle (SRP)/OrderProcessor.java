public class OrderProcessor {
    
   private InventoryManager  inventoryManager;
    private NotificationService notificationService;
    private int orderCounter = 0;

    public OrderProcessor(InventoryManager inventoryManager, NotificationService notificationService) {
        this.inventoryManager = inventoryManager;
        this.notificationService = notificationService;
    }

    public void placeOrder(String productId, int quantity, String customerEmail){
        if(!inventoryManager.checkStock(productId, quantity)){
            System.out.println("Insufficient stock for " + productId);
            return;
        }

        inventoryManager.reduceStock(productId, quantity);

        double total=quantity*100.0;
        orderCounter++;

         String orderId = "ORD-" + orderCounter;
        notificationService.sendOrderConfirmation(customerEmail, orderId, total);

    }



}
