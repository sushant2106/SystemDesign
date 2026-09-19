package Notification;

interface Message{
      void setContent(String to, String body);
    String format();
}

interface Sender{
    void send(Message message);
}


class EmailMessage implements  Message{

    private String to;
    private String body; 
     

    @Override
    public void setContent(String to, String body) {
        this.to = to;
        this.body = body;
    }

    @Override
    public String format() {
        return "Email to <" + to + ">: " + body;
    }
    
}

class EmailSender implements  Sender{
    @Override 
    public  void send(Message message){
         System.out.println("Sending via SMTP: " + message.format());
    }
}

// SMS Products
class SmsMessage implements Message {
    private String to;
    private String body;

    @Override
    public void setContent(String to, String body) {
        this.to = to;
        this.body = body.length() > 160 ? body.substring(0, 160) : body;
    }

    @Override
    public String format() {
        return "SMS to " + to + ": " + body;
    }
}

class SmsSender implements Sender {
    @Override
    public void send(Message message) {
        System.out.println("Sending via carrier API: " + message.format());
    }
}


interface NotificationFactory{
    Message createMessage();
    Sender  createSender();
}

class  EmailFactory implements NotificationFactory{


    @Override 
    public Message createMessage(){
        return new EmailMessage();
    }

    @Override 
    public  Sender creatSender(){
         return new  EmailSender();
    }


        

}

class SmsFactory implements NotificationFactory {
    @Override
    public Message createMessage() { return new SmsMessage(); }

    @Override
    public Sender createSender() { return new SmsSender(); }
}

class NotificationService{
   
    private  final NotificationFactory factory;

    public  NotificationService(NotificationFactory factory){
        this.factory=factory;
    }

}


public class Main {
    
}
