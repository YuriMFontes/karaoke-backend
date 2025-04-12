package app.karaoke.jorge.model;

public class Video {
    private static final String FILE_PATH = "F:/Musicas/";
    private Musica musica;

    public Video(Musica musica) {
        this.musica = musica;
    }

    public String getCaminhoCompleto(){
        return FILE_PATH + musica.getNumero() + ".mp4";
    }
}
