package app.karaoke.jorge;

import java.util.ArrayList;
import java.util.Scanner;

import static app.karaoke.jorge.Musica.verificarNumero;

public class Main {
    public static void main(String[] args) {
        //ArrayList para instanciar as musicas
        ArrayList<Musica> listaMusica = new ArrayList<>();
        listaMusica.add(new Musica("0001","Five Song", "Yeshua"));
        listaMusica.add(new Musica("0002", "Domingo de manha", "Matheus e Kaua"));

        //Input no terminal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da música: ");
        String numeroDigitado = scanner.nextLine();

        //Try catch para aplicar exception
        try {;
            if(verificarNumero(numeroDigitado, listaMusica)){
                System.out.println("Musica tocando...");
            }else {
                throw new Exception("Musica digitada não existe!");
            }

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        scanner.close();
    }
}
