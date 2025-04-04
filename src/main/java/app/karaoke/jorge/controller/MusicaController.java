package app.karaoke.jorge.controller;

import app.karaoke.jorge.model.Musica;

public class MusicaController {

    public static String exibirNomeCantor(Musica musica){
        return musica.getNome() + " - " + musica.getCantor();
    };

}
