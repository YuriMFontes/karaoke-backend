package app.karaoke.jorge;

import java.util.ArrayList;
import java.util.Scanner;

import static app.karaoke.jorge.Musica.exibirNomeCantor;
import static app.karaoke.jorge.MusicaJSONManager.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Menu para escolhas
        System.out.println("Escolhe um opcão: \n1-Procurar música \n2-Adicionar música \n3-Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {
            //Input no terminal
            System.out.println("Digite o número da música: ");
            String numeroDigitado = scanner.nextLine();

            //Try catch para aplicar exception
            try {
                ;
                if (verificarNumero(numeroDigitado)) {
                    System.out.println("Musica tocando...");
                } else {
                    throw new Exception("Musica digitada não existe!");
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        if (opcao == 2) {
            System.out.println("Qual número da musica? ");
            String numero = scanner.nextLine();
            System.out.println("Qual nome da música que deseja adicionar? ");
            String nome = scanner.nextLine();
            System.out.println("Qual cantor canta? ");
            String cantor = scanner.nextLine();
            adicionarMusica(new Musica(numero, nome, cantor));
        }
    }
}

