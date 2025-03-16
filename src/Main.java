import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da música: ");
        String musicNumber = scanner.nextLine().trim();

        MusicFinder musicFinder = new MusicFinder("/Users/yurimfontes/Documents/musicas/musicas.txt");
        VideoFinder videoFinder = new VideoFinder("/Users/yurimfontes/Documents/musicas");

        String videoPath = videoFinder.findVideoByNumber(musicNumber);
        Music music = musicFinder.findMusicByNumber(musicNumber);

        if (music != null) {
            System.out.println("Música encontrada!");
            System.out.println("Nome: " + music.getName());
            System.out.println("Artista: " + music.getArtist());
            System.out.println("Caminho do arquivo: " + music.getUrl());
        } else {
            System.out.println("Música não encontrada!");
        }

        if (videoPath != null){
            System.out.println("Video encontrado!");
            System.out.println("Caminho do video: " + videoPath);
        }else{
            System.out.println("Video não encontrado!");
        }

        videoFinder.playVideo(videoPath);
    }
}
