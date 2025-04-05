package app.karaoke.jorge.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class VideoView {

    public static BorderPane criarLayout(Node centro) {
        BorderPane layout = new BorderPane();

        layout.setCenter(centro);
        layout.setStyle("-fx-background-color: black;");

        return layout;
    }

    public static Label criarMensagemErro() {
        Label erro = new Label("❌ Vídeo não encontrado para essa música!");
        erro.setStyle("-fx-text-fill: red; -fx-font-size: 36px;");
        return erro;
    }
}
