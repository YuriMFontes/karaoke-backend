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

    private static MediaPlayer mediaPlayerAtual;

    public static Node carregarVideo(Musica musica, Runnable onVideoEnd) {
        pararVideoAtual();

        Video video = new Video(musica);
        File arquivo = new File(video.getCaminhoCompleto());

        if (arquivo.exists()) {
            Media media = new Media(arquivo.toURI().toString());
            mediaPlayerAtual = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayerAtual);

            // ✅ Define tamanho fixo da área do vídeo
            mediaView.setFitWidth(1024);
            mediaView.setFitHeight(768);
            mediaView.setPreserveRatio(true); // Mantém a proporção do vídeo

            mediaPlayerAtual.setAutoPlay(true);

            // Ao terminar o vídeo, executa o retorno
            mediaPlayerAtual.setOnEndOfMedia(() -> {
                mediaPlayerAtual.stop();
                mediaPlayerAtual.dispose();
                mediaPlayerAtual = null;

                if (onVideoEnd != null) {
                    onVideoEnd.run();
                }
            });

            return mediaView;
        } else {
            return VideoView.criarMensagemErro();
        }
    }

    public static void pararVideoAtual() {
        if (mediaPlayerAtual != null) {
            mediaPlayerAtual.stop();
            mediaPlayerAtual.dispose();
            mediaPlayerAtual = null;
        }
    }
}
