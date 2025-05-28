package app.karaoke.jorge.view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.Label;

public class VideoView {

    public static StackPane criarLayout(Node centro) {
        StackPane layout = new StackPane();

        // ✅ Imagem de fundo ocupando toda a tela
        BackgroundImage bgImage = new BackgroundImage(
                new Image(VideoView.class.getResource("/imagens/musica.png").toExternalForm(), true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        layout.setBackground(new Background(bgImage));

        // ✅ Centraliza o vídeo pequeno no meio
        layout.getChildren().add(centro);

        return layout;
    }

    public static Label criarMensagemErro() {
        Label erro = new Label("❌ Vídeo não encontrado para essa música!");
        erro.setStyle("-fx-text-fill: red; -fx-font-size: 36px;");
        return erro;
    }
}
