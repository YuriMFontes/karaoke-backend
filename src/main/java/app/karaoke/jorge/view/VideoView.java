package app.karaoke.jorge.view;

import app.karaoke.jorge.model.Musica;
import app.karaoke.jorge.model.Video;
import app.karaoke.jorge.controller.MusicaController;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import java.io.File;

public class VideoView {

    public static BorderPane criarLayout(Musica musica) {
        Video video = new Video(musica);
        String caminhoVideo = video.getCaminhoCompleto();
        File arquivo = new File(caminhoVideo);

        BorderPane layout = new BorderPane();

        if (arquivo.exists()) {
            Media media = new Media(arquivo.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            mediaView.setPreserveRatio(true);
            mediaView.fitWidthProperty().bind(layout.widthProperty());
            mediaView.fitHeightProperty().bind(layout.heightProperty());

            mediaPlayer.setAutoPlay(true);
            layout.setCenter(mediaView);
        } else {
            Label erro = new Label("❌ Vídeo não encontrado para essa música!");
            erro.setFont(Font.font(36));
            erro.setStyle("-fx-text-fill: red;");
            layout.setCenter(erro);
        }

        Label titulo = new Label("🎤 Tocando agora: " + MusicaController.exibirNomeCantor(musica));
        titulo.setFont(Font.font(28));
        titulo.setStyle("-fx-text-fill: white; -fx-padding: 20;");
        layout.setTop(titulo);
        layout.setStyle("-fx-background-color: black;");

        return layout;
    }
}
