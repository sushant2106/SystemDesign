import java.util.ArrayList;
import java.util.List;

interface DocumentSessionMediator{

    void boradCastChange(String change,User sender);
    void join(User user);
}

//Mediator 
class CollaborativeDocument implements  DocumentSessionMediator{

    private List<User> users=new ArrayList<>();

    @Override 
    public void join(User user){
        users.add(user);
    }

    @Override 
    public void boradCastChange(String change,User sender){
        for(User user : users){
            if(user != sender){
               user.receiveChange(change, sender);
            }
        }
    }


}
class User{
   
    protected String name;
    protected  DocumentSessionMediator mediator;

    public User(String name,DocumentSessionMediator mediator){
        this.name=name;
        this.mediator=mediator;
    }

    public void makeChange(String change){
        System.out.println(name + " edited the document: "+ change);
        mediator.boradCastChange(change, this);
    }

    public void receiveChange(String change,User sender){
        System.out.println(name + " saw change from " + sender.name + change);
    }




}

public class Main {

    public static void main(String[] args){
     
      CollaborativeDocument doc=new CollaborativeDocument();
      User alice=new User("Alice",doc);

      User bob=new User("Bob",doc);

      User Charlie=new User("Charlie",doc);

      doc.join(Charlie);
      doc.join(bob);
      doc.join(alice);


      alice.makeChange("Added project title");

      bob.makeChange("Corrected grammar in paragraph 2");
      

    }
}