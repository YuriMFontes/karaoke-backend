package app.karaoke.jorge.view;

import app.karaoke.jorge.controller.MusicaController;
import app.karaoke.jorge.controller.VideoController;
import app.karaoke.jorge.model.Musica;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KaraokeApp extends Application {
    private Musica musicaSelecionada = null;

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane(); // Container principal

        // Adiciona imagem de fundo
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(getClass().getResource("/imagens/musica.png").toExternalForm(), true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        root.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(root, 800, 600);

        VBox telaInicial = criarTelaInicial(root);
        root.getChildren().add(telaInicial);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Karaokê Maclim");
        primaryStage.show();
    }

    private VBox criarTelaInicial(StackPane root) {
        TextField inputField = new TextField();
        inputField.setPromptText("Digite o número da música: ");
        inputField.setFont(Font.font(32));
        inputField.setMaxWidth(300);

        Label resultadoLabel = new Label();
        resultadoLabel.setFont(Font.font(28));

        inputField.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.length() == 4) {
                StringBuilder mensagem = new StringBuilder();
                musicaSelecionada = MusicaController.buscarEMostrarMusica(newValue, mensagem);
                resultadoLabel.setText(mensagem.toString());
            } else {
                resultadoLabel.setText("");
                musicaSelecionada = null;
            }
        });

        inputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER && musicaSelecionada != null) {
                Runnable voltarParaTelaInicial = () -> {
                    VBox telaInicial = criarTelaInicial(root);
                    javafx.application.Platform.runLater(() -> root.getChildren().setAll(telaInicial));
                };

                var videoNode = VideoController.carregarVideo(musicaSelecionada, voltarParaTelaInicial);
                var layoutVideo = VideoView.criarLayout(videoNode);

                Scene scene = root.getScene();

                scene.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.BACK_SPACE) {
                        VideoController.pararVideoAtual();
                        VBox telaInicial = criarTelaInicial(root);
                        root.getChildren().setAll(telaInicial);
                        scene.setOnKeyPressed(null); // remove o listener para evitar duplicação
                    }
                });

                root.getChildren().setAll(layoutVideo);
            }
        });

        VBox layout = new VBox(20, inputField, resultadoLabel);
        layout.setStyle("-fx-alignment: center; -fx-padding: 50;");
        resultadoLabel.setStyle("-fx-text-fill: white;");
        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
