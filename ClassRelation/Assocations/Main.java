import java.util.ArrayList;
import java.util.List;

class User{

    private String name;
    private List<Group> groups=new ArrayList<>();


    public User(String name){
        this.name=name;
    }

    public void joinGroup(Group group){
        if(!groups.contains(group)){
           groups.add(group);
           group.addUser(this);
        }
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }
}


class Group{


    String groupName;
    private List<User> users=new ArrayList<>();



    public Group(String  groupName){
        this.groupName=groupName;
    }
    
      public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.joinGroup(this);
        }
    }

    public String getName() {
        return groupName;
    }

    public List<User> getUsers() {
        return users;
    }
}

public class Main {

    
public static void main(String[] args) {
     
 User alice = new User("Alice");
User bob = new User("Bob");

Group backend = new Group("Backend");
Group devOps = new Group("DevOps");

alice.joinGroup(backend);
alice.joinGroup(devOps);
bob.joinGroup(backend);


   

}

}