interface Pizza{

    String getDescription();
    double getCost();
}


class MargheritaPizza implements  Pizza{

    @Override 
    public String getDescription(){
        return "Margheita Pizza";
    }

    @Override 
    public double getCost(){
        return 200.0;
    }
}


class PlainPizza implements  Pizza{


    @Override 
    public String getDescription(){
        return "Plain Pizza";
    }


    @Override 
    public double getCost(){
        return 200.0;
    }
}

//Decorator Abstract Class 
abstract class PizzaDecorator implements  Pizza{

    protected  Pizza pizza;

    public  PizzaDecorator(Pizza pizza){
        this.pizza=pizza;
    }
}

class ExtraCheese extends  PizzaDecorator{

    public ExtraCheese(Pizza pizza){
        super(pizza);
    }

    @Override 
    public String getDescription(){
        return pizza.getDescription() + " , Extra Cheese";
    }

    @Override 
    public double getCost(){
        return pizza.getCost() + 40.0;
    }
}


class Olives extends  PizzaDecorator{


    public Olives(Pizza pizza){
        super(pizza);
    }


    @Override 
    public String getDescription(){
        return pizza.getDescription() + " , Olives";
    }


    @Override 
    public double getCost(){
        return pizza.getCost() + 30.0;
    }

}


class StufferdCrust extends  PizzaDecorator{

    public StufferdCrust(Pizza pizza){
        super(pizza);
    }

    

    @Override 
    public String getDescription(){
        return pizza.getDescription() + ",Stuffed Crust";
    }




    @Override 
    public double getCost(){
        return pizza.getCost() + 30.0;
    }
}


public class Main{

    public static void main(String[] args) {

        Pizza margheritaCheezePizza=new ExtraCheese(new MargheritaPizza());

        // pizza.getDescription();

        Pizza pizza2=new Olives(margheritaCheezePizza);

        pizza2.getDescription();

      
        //new Olive(new Margerita())
        //new Stuffed(new Olive(new Margerita()))
        Pizza pizza3=new StufferdCrust(pizza2);
        
        System.out.println(pizza3.getDescription());

        
    }
}