package app.karaoke.jorge;

import java.util.ArrayList;

public class Musica {
    private String numero;
    private String nome;
    private String cantor;

    //Construtor
    public Musica(String numero, String cantor, String nome) {
        this.numero = numero;
        this.cantor = cantor;
        this.nome = nome;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public String getCantor() {
        return cantor;
    }

    public String getNumero() {
        return numero;
    }

    //Sobreescrever ToString
    @Override
    public String toString() {
        return "Música #" + numero + ": " + nome + " - " + cantor;
    }


    //Metodo para exibir o nome e cantor da musica
    static void exibirNomeCantor(String numeroDigitado, ArrayList<Musica> listaMusica){
        for(Musica musica : listaMusica){
            if(musica.getNumero().equals(numeroDigitado)){
                System.out.println(musica.getNome() + " - " + musica.getCantor());
            }
        }
    }

}


