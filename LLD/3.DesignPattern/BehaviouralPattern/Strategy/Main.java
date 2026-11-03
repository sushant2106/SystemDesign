
interface MatchingStrategy{

    void match(String riderLocation);
}

class NearestDriverStartegy implements  MatchingStrategy{

    @Override 
    public void match(String riderLocation){
        System.out.println("Matching with the nearest avaailable driver to: "+riderLocation);
    }

}

class AirPortQueue implements  MatchingStrategy{

    @Override 
    public void match(String riderLocation){

        System.out.println("Matching using FIFO airport queue for "+ riderLocation);

    }
}

class SurgPriorityStrategy implements  MatchingStrategy{

    @Override 
    public  void match(String riderLocation){
        System.out.println("Matching rider using surge price priority "+ riderLocation);
    }
}

class RiderMatchingService{

    private MatchingStrategy strategy;

    public RiderMatchingService(MatchingStrategy strategy){
        this.strategy=strategy;
    }
    public void  setStratgey(MatchingStrategy strategy){
        this.strategy=strategy;
    }
    public  void matchRider(String location){
        strategy.match(location);
    }
}
public class Main {

    public static void main(String[] args){

        RiderMatchingService riderMatchingService=new RiderMatchingService(new AirPortQueue());

        riderMatchingService.matchRider("sikta");

    }
}