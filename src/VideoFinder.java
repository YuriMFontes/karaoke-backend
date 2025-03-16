import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

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

    public void playVideo(String videoPath){
        File videoFile = new File(videoPath);

        if (!videoFile.exists()){
            System.out.println("Video não encontrado!" + videoPath);
            return;
        }

        if (Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().open(videoFile);
                System.out.println("Reproduzindo video" + videoPath);
            } catch (IOException e){
                System.out.println("Erro ao tentar abrir o video");
                e.printStackTrace();
            }
        }else {
            System.out.println("Desktop não suportado para abrir arquivos.");
        }
    };
}
