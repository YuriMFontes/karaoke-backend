import java.io.File;
import java.io.FilenameFilter;

public class VideoFinder {
    private String directoryPath;

    public VideoFinder(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String findVideoByNumber(String number){
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()){
            System.out.println("Diretório inválido");
            return null;
        }

        FilenameFilter filter = (dir, name) ->
                name.startsWith(number) && (name.endsWith(".mp4"));

        File[] matchFiles = directory.listFiles(filter);
        if (matchFiles != null && matchFiles.length > 0){
            return matchFiles[0].getAbsolutePath();
        }
        return null;
    };
}
