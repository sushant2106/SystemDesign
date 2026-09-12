public class Store {
    private String storename="Vmart";

    public class Greeter{

        public void greet(String customer){
             System.out.println("Hello " + customer + ", welcome to " + storename + "!");
        }


    }
    public static void main(String[] args) {

        Store store=new Store();
        Store.Greeter greeter=store.new Greeter();

        greeter.greet("SHyam");
        
    }
    
}
