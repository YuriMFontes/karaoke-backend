import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MusicFinder {
    private String filePath;

    public MusicFinder(String filePath) {
        this.filePath = filePath;
    }

    public Music findMusicByNumber(String number){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 3){
                    String musicNumber = parts[0].trim();
                    String musicName = parts[1].trim();
                    String musicArtist = parts[2].trim();

                    if(musicNumber.equals(number)){
                        return new Music(musicName, musicNumber, musicArtist, "E:/KaraokeVideos/");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    };
}
