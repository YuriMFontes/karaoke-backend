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

    //Metodo verificar o numero digitado é igual ao numero da musica
    static boolean verificarNumero(String numeroDigitado, ArrayList<Musica> listaMusica){
        for(Musica musica : listaMusica){
            if (musica.getNumero().equals(numeroDigitado)){
                return true; //Musica encontrada
            }
        }
        return false; //Musica não encontrada
    }
}


