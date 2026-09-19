
interface VideoQuality{

    void load(String title);
}

class SDQuality implements VideoQuality{

    public void load(String title){
        System.out.println("Straming " + title + "in SD Quality");
    }
}

class HDQuality implements  VideoQuality{

    public void  load(String title){
        System.out.println("Streaming " + title + "in HD Quality");
    }
}

class UltraHDQuality implements  VideoQuality{

    public void  load(String title){
        System.out.println("Straming " + title + " in 4K Ultra HD Quality");
    }
}

class K8Quality implements  VideoQuality{

    public void  load(String title){
        System.out.println("Straming " + title + " in 8k Ultra HD Quality");
    }
}
abstract class  VideoPlayer {

    protected  VideoQuality videoQuality;

    public  VideoPlayer(VideoQuality quality){
        this.videoQuality=quality;
    }

    public  abstract void play(String title);
 
}

class WebPlayer extends  VideoPlayer{
    public WebPlayer(VideoQuality quality){
        super(quality);
    }

    public void play(String title){
        System.out.println("Web Platform");
         videoQuality.load(title);
    }
}

class MobilePlayer extends VideoPlayer {

    public MobilePlayer(VideoQuality quality){
        super(quality);
    }

    public  void  play(String title){
        System.out.println("Mobile Platform");
        videoQuality.load(title);
    }
}
public class Main {

    public static void main(String[] args) {

       VideoPlayer videoPlayer=new WebPlayer(new HDQuality());
       videoPlayer.play("pogo");
        
       VideoPlayer videoPlayer2=new WebPlayer(new K8Quality());
       videoPlayer2.play("pogo");

       WebPlayer  webPlayer=new WebPlayer(new SDQuality());
        webPlayer.play("dance Macha dance..");
    }
}