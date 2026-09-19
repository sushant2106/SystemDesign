interface Logistics{

    public abstract  void send();

}

class Road implements  Logistics{

    @Override 
    public  void  send(){
        System.out.println("Sending by road logic");
    }
}

class Air implements  Logistics{

    @Override 
    public  void  send(){
        System.out.println("Sending by air logic ...");
    }
}

class LogisticsFactory {

    public  static  Logistics geLogistics(String mode){ //dependency as return another class 

        if(mode == "road"){
            return  new  Road();
        }
        return  new Air();
    }
}
class LogisticService{

    public  void  send(String mode){
        Logistics logistics=LogisticsFactory.geLogistics(mode);
        logistics.send();
    }


}

public class Main {
 public static void main(String[] args) {

   new LogisticService().send("Air");

//    LogisticsFactory.geLogistics("AIr");
    
 }
    
}




