import java.util.*;

interface videoDownloader{

    String downloadVideo(String videoUrl);
}

//step 2 actual video downloader 
class RealVideoDownloader implements  videoDownloader{


    @Override 
    public String downloadVideo(String videoUrl){
        System.out.println("Downloading video from URL :" + videoUrl);
        return " Video content from " + videoUrl;

    }

}

//step3: Proxy with Cache 

class CachedVideoDownloader implements  videoDownloader{

    private  RealVideoDownloader realVideoDownloader;
    private  Map<String,String>cache;

    public CachedVideoDownloader(){
        this.realVideoDownloader=new RealVideoDownloader();
        this.cache=new HashMap<>();
    }

    @Override 
    public String downloadVideo(String videoUrl){
        if(cache.containsKey(videoUrl)){
            System.out.println("Returning cahced video for: " + videoUrl);
            return cache.get(videoUrl);
        }
        System.out.println("Cache Miss Downloading....");

        String video =realVideoDownloader.downloadVideo(videoUrl);
        cache.put(videoUrl, video);
        return video;  

    }
}



public class Main {

    public static void main(String[] args) {

        videoDownloader cachVideoDownloader=new CachedVideoDownloader();

        cachVideoDownloader.downloadVideo("pattern-url");


        videoDownloader cachVideoDownloader2=new CachedVideoDownloader();

        cachVideoDownloader2.downloadVideo("pattern-url");


        
    }
}