package app.karaoke.jorge.controller;

import app.karaoke.jorge.model.Musica;
import app.karaoke.jorge.model.Video;
import app.karaoke.jorge.view.VideoView;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class VideoController {

    public static Node carregarVideo(Musica musica) {
        Video video = new Video(musica);
        File arquivo = new File(video.getCaminhoCompleto());

        if (arquivo.exists()) {
            Media media = new Media(arquivo.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            mediaView.setPreserveRatio(true);
            mediaPlayer.setAutoPlay(true);

            return mediaView;
        } else {
            return VideoView.criarMensagemErro();
        }
    }
}
