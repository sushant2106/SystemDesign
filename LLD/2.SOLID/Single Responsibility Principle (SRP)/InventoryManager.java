
import java.util.*;
public class InventoryManager{

    private Map<String,Integer> stock=new HashMap<>();



    public InventoryManager(){
        stock.put("LAPTOP", 10);
        stock.put("PHONE", 25);
        stock.put("TABLET", 15);
    }

     
   public boolean checkStock(String productId, int quantity){
    return stock.getOrDefault(productId,0) >=quantity;
   }
   
    public void reduceStock(String productId, int quantity) {
        stock.put(productId, stock.get(productId) - quantity);
    }




}
