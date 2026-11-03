import java.util.*;
interface Subscriber{

    public void update(String videoTitle);
}

class EmailSubscriber implements  Subscriber{
    private  String email;

    EmailSubscriber(String email){
        this.email=email;
    }

    @Override 
    public  void update(String videoTitle){
        System.out.println("Email sent to " +email + ": New Video uploaded -" + videoTitle);
    }
}

class MobileAppSubscriber implements  Subscriber{
    private  String username;

    MobileAppSubscriber(String username){
        this.username=username;
    }

    @Override 
    public  void update(String videoTitle){
        System.out.println("In app for :" + username + ": Ne video Uploaded -" + videoTitle);

    }
}

interface Channel{
    public void subscriber(Subscriber subscriber);
    public void unsubscribe(Subscriber subscriber);
    public void notifySubscriber(String videoTitle);

}

class YouTubeChannel implements  Channel{

    private  List<Subscriber> subscribers=new ArrayList<>();
    String channelName;
    
    YouTubeChannel(String channelName){
        this.channelName=channelName;
    }

    @Override 
    public void subscriber(Subscriber sub){
        subscribers.add(sub);

    }
    
    @Override 
    public void unsubscribe(Subscriber sub){
        subscribers.remove(sub);

    }

    @Override 
    public void notifySubscriber(String videoTitle){
        for(Subscriber subscriber: subscribers){
            subscriber.update(videoTitle);
        }

    }

    public void uploadVideo(String videoTitle){
          System.out.println(channelName + " uploaded: " + videoTitle);
          notifySubscriber(videoTitle);
    }



}

public class Main {

    public static void main(String[] args){

        YouTubeChannel tuf=new YouTubeChannel("take you forward");

        tuf.subscriber(new MobileAppSubscriber("Sachin"));

        tuf.uploadVideo("Observer-pattern");



    }
}