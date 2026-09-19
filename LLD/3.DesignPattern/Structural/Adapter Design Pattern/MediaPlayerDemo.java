interface MediaPlayer{
    public abstract void play(String filename);
}


class Mp3Player implements MediaPlayer {
    @Override
    public void play(String filename) {
        System.out.println("MP3 Player: Playing " + filename);
    }
}

class VlcCodec {

    public void playVlc(String filename){
        System.out.println("VLC Codec: Decoding and playing " + filename);
    }

}


class Mp4Codec {
    public void playMp4(String filename) {
        System.out.println("MP4 Codec: Decoding and playing " + filename);
    }
}


class VlcPlayerAdapter implements  MediaPlayer{
    
    private final VlcCodec vlcCodec;
     
    public VlcPlayerAdapter(VlcCodec codec) {
        this.vlcCodec = codec;
    }

    @Override 
    public  void play(String filename){

        vlcCodec.playVlc(filename);

    }

}

class Mp4PlayerAdapter implements MediaPlayer{
    private  final Mp4Codec mp4Codec;

    Mp4PlayerAdapter(Mp4Codec mp4Codec){
        this.mp4Codec=mp4Codec;
    }

    @Override
    public void play(String filename) {
        mp4Codec.playMp4(filename);
    }


}

class AudioPlayer{

    public void playFile(String filename){

        MediaPlayer  player;
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        
        
         switch (extension) {
            case "mp3":
                player = new Mp3Player();
                break;
            case "vlc":
                player = new VlcPlayerAdapter(new VlcCodec());
                break;
            case "mp4":
                player = new Mp4PlayerAdapter(new Mp4Codec());
                break;
            default:
                System.out.println("Unsupported format: " + extension);
                return;
        }

        player.play(filename);
    

    }
}

public class MediaPlayerDemo{

    public static void main(String[] args){
      
        AudioPlayer player = new AudioPlayer();
        player.playFile("song.mp3");
        player.playFile("movie.mp4");
        player.playFile("documentary.vlc");
        player.playFile("image.png");

    }
}