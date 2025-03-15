import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da música: ");
        String musicNumber = scanner.nextLine().trim();

        MusicFinder musicFinder = new MusicFinder("/Users/yurimfontes/Documents/musicas/musicas.txt");
        Music music = musicFinder.findMusicByNumber(musicNumber);

        if (music != null) {
            System.out.println("Música encontrada!");
            System.out.println("Nome: " + music.getName());
            System.out.println("Artista: " + music.getArtist());
            System.out.println("Caminho do arquivo: " + music.takeURL());
        } else {
            System.out.println("Música não encontrada!");
        }
    }
}
