package app.karaoke.jorge.controller;

import app.karaoke.jorge.model.Musica;
import app.karaoke.jorge.controller.MusicaJSONManager;

public class MusicaController {

    public static String exibirNomeCantor(Musica musica) {
        return musica.getNome() + " - " + musica.getCantor();
    }

    public static Musica buscarEMostrarMusica(String numero, StringBuilder mensagem) {
        Musica musica = MusicaJSONManager.buscarMusicaPorNumero(numero);
        if (musica != null) {
            mensagem.append("🎵 ").append(exibirNomeCantor(musica));
            return musica;
        } else {
            mensagem.append("❌ Música não encontrada!");
            return null;
        }
    }
}
