class OrderContext {
    private OrderState currentState;

    public OrderContext() {
        this.currentState = new OrderPlacedState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }

    public String getCurrentState() {
        return currentState.getStateName();
    }
}

interface OrderState {
    void next(OrderContext context);
    void cancel(OrderContext context);
    String getStateName();
}

class OrderPlacedState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new PreparingState());
        System.out.println("Order is now being prepared.");
    }

    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }

    public String getStateName() {
        return "ORDER_PLACED";
    }
}

class PreparingState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new OutForDelivery());
        System.out.println("Order is out for delivery.");
    }

    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }

    public String getStateName() {
        return "PREPARING";
    }
}

class OutForDelivery implements OrderState {
    public void next(OrderContext context) {
        context.setState(new DeliveredState());
        System.out.println("Order has been delivered.");
    }

    public void cancel(OrderContext context) {
        context.setState(new CancelledState());
        System.out.println("Order has been cancelled.");
    }

    public String getStateName() {
        return "OUT_FOR_DELIVERY";
    }
}

class DeliveredState implements OrderState {
    public void next(OrderContext context) {
        System.out.println("Order is already delivered. No further state.");
    }

    public void cancel(OrderContext context) {
        System.out.println("Delivered orders cannot be cancelled.");
    }

    public String getStateName() {
        return "DELIVERED";
    }
}

class CancelledState implements OrderState {
    public void next(OrderContext context) {
        System.out.println("Cancelled orders cannot proceed to next state.");
    }

    public void cancel(OrderContext context) {
        System.out.println("Order is already cancelled.");
    }

    public String getStateName() {
        return "CANCELLED";
    }
}

public class Main {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();
        System.out.println("Current State: " + order.getCurrentState());

        order.next();   // Move to Preparing
        order.next();   // Move to OutForDelivery
        order.next();   // Move to Delivered
        order.cancel(); // Try cancelling after delivery
    }
}
