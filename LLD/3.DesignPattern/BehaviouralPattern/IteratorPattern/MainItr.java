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


interface PlayList{
    PlaylistIterator createIterator();
}

class YoutubePlayList implements PlayList {

    private List<Video> videos=new ArrayList<>();

    public void addVideo(Video video){
        videos.add(video);
    }

    @Override 
    public PlaylistIterator createIterator(){
        return new YoutubePlayListIterator(videos);
    }



}



public class MainItr {

    public static void main(String[] args) {

     YoutubePlayList playList=new YoutubePlayList();
       
       playList.addVideo(new Video("LLD tutuorial"));
       playList.addVideo(new Video("System Design"));

       PlaylistIterator iterator=playList.createIterator();

       while ((iterator.hasNext())) {
        System.out.println(iterator.next().getTitle());
        
       }
        
    }
}