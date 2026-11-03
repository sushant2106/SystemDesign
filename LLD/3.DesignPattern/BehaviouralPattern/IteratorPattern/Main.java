import java.util.*;

class Video{
    String title;

    public Video(String title){
      this.title=title;
    }

    public String getTitle(){
        return title;
    }
}

class YoutubePlayList{

    private List<Video> videos= new ArrayList<>();

    public void addVideo(Video video){
        videos.add(video);
    }

    public List<Video> getVideos(){
        return videos;
    }
}

interface PlaylistIterator{
    boolean hasNext();
    Video next();
}

class YoutubePlayListIterator implements  PlaylistIterator{

    private List<Video> videos;
    private int position;

    public YoutubePlayListIterator(List<Video> videos){
        this.videos=videos;
        this.position=0;
    }

    @Override 
    public boolean hasNext(){
        return position < videos.size();
    }

    @Override 
    public  Video next(){
        return  hasNext() ? videos.get(position++) : null;
    }

}

class YoutubeCopyRightIterator implements  PlaylistIterator{

    private List<Video> videos;
    private int position;

    public YoutubeCopyRightIterator(List<Video> videos){
        this.videos=videos;
        this.position=0;
    }

    @Override 
    public boolean hasNext(){
        return position < videos.size();
    }

    @Override 
    public  Video next(){
        return  hasNext() ? videos.get(position++) : null;
    }

}


public class Main {

    public static void main(String[] args) {

       YoutubePlayList playList=new YoutubePlayList();
       
       playList.addVideo(new Video("LLD tutuorial"));
       playList.addVideo(new Video("System Design"));

       PlaylistIterator iterator=new YoutubePlayListIterator(playList.getVideos());

       while ((iterator.hasNext())) {
        System.out.println(iterator.next().getTitle());
        
       }
        
    }
}