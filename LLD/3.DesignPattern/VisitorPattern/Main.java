import java.util.ArrayList;
import java.util.List;

interface Item{
    void accept(ItemVisitor visitor);
}


class PhysicalProduct implements Item{

    String name;
    int weight;

    public PhysicalProduct(String name,int weight){
        this.name=name;
        this.weight=weight;
    }

    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}

class DigitalProduct implements  Item{
    String name;
    int downloadSizeInMB;

    public DigitalProduct(String name,int downloadSizeInMB){
        this.name=name;
        this.downloadSizeInMB=downloadSizeInMB;
    }

    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}

class GiftCard implements  Item{
    String code;
    int amount;

    public GiftCard(String code,int amount){
        this.code=code;
        this.amount=amount;
    }

    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}



interface ItemVisitor{

    void visit(PhysicalProduct item);
    void  visit(DigitalProduct item);
    void visit(GiftCard item);

}


class InvoiceVisitor implements ItemVisitor{

    public void visit(PhysicalProduct item){
        System.out.println("Invoice " + item.name + "--shipping to customer");
    }

    public void visit(DigitalProduct item){

        System.out.println("Invoice " + item.name + " -- Email with downlaod link");
    }

    public void visit(GiftCard item){
        System.out.println("Invoice gift Card " + item.code);
    }
}




class ShippingVisitor implements ItemVisitor{

    public void visit(PhysicalProduct item){
        System.out.println("Shipping cost " + item.name + "--shipping to customer");
    }

    public void visit(DigitalProduct item){

        System.out.println("No ShippingCost " + item.name + " -- Email with downlaod link");
    }

    public void visit(GiftCard item){
        System.out.println("Shipping gift Card " + item.code);
    }
}
public class Main {

    public static void main(String[] args) {

        List<Item> items=new ArrayList<>();
        items.add(new PhysicalProduct("shoes", 1));
        items.add(new DigitalProduct("Ebook",100));
        items.add(new GiftCard("TUF", 500));


        ItemVisitor invoiceGenerator=new InvoiceVisitor();
        ItemVisitor shippingCalculator=new ShippingVisitor();

        for(Item item: items){
            item.accept(invoiceGenerator);
            item.accept(shippingCalculator);
        }

        
    }
}