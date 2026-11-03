import java.util.*;

interface Iterator<T>{

    boolean hasNext();
    T next();
}

interface IterableCollection<T>{

    Iterator<T> createIterator();
}

class Playlist implements  IterableCollection<String>{

    private final  List<String> songs=new ArrayList<>();

     public void addSong(String song) {
        songs.add(song);
    }

    public String getSongAt(int index) {
        return songs.get(index);
    }

    public int getSize() {
        return songs.size();
    }

    public Iterator<String> createIterator(){
        return new PlaylistIteratorAno(this);
    }
}

class PlaylistIteratorAno implements Iterator<String>{

    private final Playlist playlist;
    private int index = 0;
    
    public PlaylistIteratorAno(Playlist playlist){
        this.playlist=playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public String next() {
        return playlist.getSongAt(index++);
    }

}

class ReversePlaylistIterator implements Iterator<String> {
    private final Playlist playlist;
    private int index;

    public ReversePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = playlist.getSize() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public String next() {
        return playlist.getSongAt(index--);
    }
}

public class Spotify{

    public static void main(String[] args){
        Playlist playlist = new Playlist();
        playlist.addSong("Shape of You");
        playlist.addSong("Bohemian Rhapsody");
        playlist.addSong("Blinding Lights");
         

        Iterator<String> iterator = playlist.createIterator();

        System.out.println("Now Playing:");
        while (iterator.hasNext()) {
            System.out.println(" 🎵 " + iterator.next());
        }
    }
}