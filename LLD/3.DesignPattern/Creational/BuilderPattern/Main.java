import java.util.*;

class BurgerMeal{

    //required 

    private final String bunType;
    private final String patty;

    //optional 

    private final boolean hasCheese;
    private final List<String>toppings;
    private final String side;
    private final String drink;

    private BurgerMeal(BurgerBuilder builder){

        this.bunType=builder.bunType;
        this.patty=builder.patty;
        this.hasCheese=builder.hasCheese;
        this.toppings=builder.toppings;
        this.side=builder.side;
        this.drink=builder.drink;
    }

    public  static  class BurgerBuilder{

        //required 

        private final String bunType;
        private final String patty;

        //Optional

        private boolean hasCheese;
        private List<String> toppings;
        private String side;
        private String drink;

        public  BurgerBuilder(String bunType,String patty){
            this.bunType=bunType;
            this.patty=patty;
        }

        public  BurgerBuilder withCheese(boolean hasCheese){
            this.hasCheese=hasCheese;
            return this;
        }

        public  BurgerBuilder withToppings(List<String> toppings){
            this.toppings=toppings;
            return this;
        }

        public  BurgerBuilder withSide(String side){
            this.side=side;
            return this;
        }
       
        public  BurgerBuilder withDrink(String drink){
            this.drink=drink;
            return  this;
        }

        public  BurgerMeal build(){
            return new BurgerMeal(this);
        }

    }


}

public class Main {

    public static void main(String[] args) {

        BurgerMeal burgerMeal=new BurgerMeal.BurgerBuilder("wheat","veg").build();

        BurgerMeal burgerwuthCHeese=new BurgerMeal.BurgerBuilder("wheat", "veg").withCheese(true).build();

        System.out.println(burgerMeal.drink);
        
    }
}