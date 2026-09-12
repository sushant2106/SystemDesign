import java.util.*;

class LineItem{
   
    private String productName;
    private int quantity;
    private double unitprice;

    LineItem(String productName,int quantity,int unitprice){
        this.productName=productName;
        this.quantity=quantity;
        this.unitprice=unitprice;
    }

    public double getSubtotal(){
        return quantity * unitprice;
    }

    public String getProductName() {
        return productName;
    }

    public void describe() {
        System.out.printf("%s x%d @ $%.2f = $%.2f%n",
            productName, quantity, unitprice, getSubtotal());
    }


}

class Order{
    private String orderId;
    private List<LineItem> lineItems=new ArrayList<>();
   

    public Order(String orderId) {
        this.orderId = orderId;
        this.lineItems = new ArrayList<>();
    }

    public void addItem(String product,int qty,double price){
      LineItem lineItem0ther=new LineItem(product, qty, qty);
      lineItems.add(lineItem0ther);

    }

    public void removeItme(String product){
        lineItems.removeIf(item -> item.getProductName().equals(product));

    }

    public double getTotal(){

        double total=0;

        for(LineItem item: lineItems){
            total+=item.getSubtotal();
        }

        return total;

    }

     public void printReceipt() {
        System.out.println("Order: " + orderId);
        for (LineItem item : lineItems) {
            item.describe();
        }
        System.out.printf("Total: $%.2f%n", getTotal());



}


public class Main {

    public static void main(String[] args) {
        
    
    }
}