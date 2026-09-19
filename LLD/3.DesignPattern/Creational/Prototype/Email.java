import java.security.PublicKey;
import java.util.*;

interface EmailTemplate extends Cloneable{

    EmailTemplate clone();

    void setContent(String content);
    void send(String to);

    String getContent();
}

class WelcomeEmail implements  EmailTemplate{

    private String subject;
    private String content;

    public WelcomeEmail(){
        this.subject="Welcome to TUF+";
        this.content="Hi,there,! Thanks for joining us..";
    }

    // @Override  
    // public EmailTemplate clone(){
        // try{
            // return (EmailTemplate) super.clone();
        // }
        // catch(CloneNotSupportedException e){
            // throw new RuntimeException("Clone failed..",e);
        // }

    //}

    @Override  
    public WelcomeEmail clone(){
      try{
        return (WelcomeEmail) super.clone();
      }
      catch(CloneNotSupportedException e){
        throw new RuntimeException("Clone failed..",e);
      }
    }

    @Override 
    public void  setContent(String content){
        this.content=content;
    }

    @Override 
    public  void  send(String to){
        System.out.println("Sending to " + to + " : [" +subject +"]" +content);
    }
    
    @Override 
    public String getContent(){
        return  content;
    }

}


class EmailTemplateRegistry{
    private static  final Map<String,EmailTemplate> templates=new HashMap<>();

    static {
        templates.put("Welcome",new  WelcomeEmail());
    }

     
    public static  EmailTemplate getTemplate(String type){
        return templates.get(type).clone(); //clone avoid modify original 
    }


}



public class Email{

    public static void main(String[] args) {
        

        EmailTemplate welcomeEmail=EmailTemplateRegistry.getTemplate("Welcome");
        welcomeEmail.setContent("type-1");

        System.out.println(welcomeEmail.getContent());
    }
}