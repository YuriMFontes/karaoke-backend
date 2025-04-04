package app.karaoke.jorge.model;

public class Musica {
    private String numero;
    private String nome;
    private String cantor;

    //Construtor
    public Musica(String numero, String nome, String cantor) {
        this.numero = numero;
        this.nome = nome;
        this.cantor = cantor;

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
}


