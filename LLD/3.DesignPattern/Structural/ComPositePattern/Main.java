import java.util.*;

interface CartItem{

    double getPrice();
    void display(String indent);

}

class Product implements  CartItem{

    private String name;
    private double price;

    public Product(String name,double price){
        this.name=name;
        this.price=price;
    }


    @Override 
     public double getPrice(){
        return price;
     }

     @Override 
     public  void  display(String indent){
        System.out.println(indent + "Product" + name + "- Ruppes "+price);
     }

}

class ProductBundle implements  CartItem{

    private String bundleName;
    private List<CartItem> items=new ArrayList<>();

    public  ProductBundle(String bundleName){
        this.bundleName=bundleName;
    }

    public  void addItem(CartItem item){
        items.add(item);
    }

    @Override 
    public  double getPrice(){
        double total=0;

        for(CartItem cartItem:items){
            total+=cartItem.getPrice();
        }
        return total;
    }

    @Override 
    public  void display(String indent){
        System.out.println(indent + "Bundle: " + bundleName);

        for(CartItem item: items){
            item.display(indent + " ");
        }
    }


}



public class Main {
    public static void main(String[] args) {


        CartItem book=new Product("aTOMIC HABBIT",499);
        CartItem phone=new Product("iphone",79999);

        CartItem earbuds=new Product("AirPods",15999);

        CartItem charger=new Product("20 w charger",1999);

        ProductBundle  iphoneCOMBO=new ProductBundle("Iphone Essential");

        iphoneCOMBO.addItem(phone);
        iphoneCOMBO.addItem(phone);
        iphoneCOMBO.addItem(earbuds);
        iphoneCOMBO.addItem(charger);


        ProductBundle schoolKit=new ProductBundle("Back to School kit");

        schoolKit.addItem(new Product("Note bOok",249));
        schoolKit.addItem(new Product("Pin set",99));

        List<CartItem> cart=new  ArrayList<>();
        cart.add(book);
        cart.add(iphoneCOMBO);
        cart.add(schoolKit);

        //Display Cart 

        System.out.println("Your Amazon Cart: ");

        double total=0;
        for(CartItem item: cart){
            item.display(" ");
            total+=item.getPrice();
        }

        System.out.println("\n Total : " +total);
    }
}