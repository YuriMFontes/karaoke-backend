package app.karaoke.jorge.model;



public class VIdeo {
    private static final String FILE_PATH = "/Users/yurimfontes/Documents/musicas";
    private Musica musica;

    public VIdeo(Musica musica, String baseUrl) {
        this.musica = musica;
    }

    public String getBaseUrlCompleta(){
        return FILE_PATH + musica.getNumero() + ".mp4";
    }
}
