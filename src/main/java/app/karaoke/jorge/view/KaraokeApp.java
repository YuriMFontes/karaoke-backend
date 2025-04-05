package app.karaoke.jorge.view;

import app.karaoke.jorge.controller.MusicaController;
import app.karaoke.jorge.controller.MusicaJSONManager;
import app.karaoke.jorge.model.Musica;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KaraokeApp extends Application {
    private Musica musicaSelecionada = null;

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane(); // Container principal
        Scene scene = new Scene(root, 800, 600);

        VBox telaInicial = criarTelaInicial(root, primaryStage);
        root.getChildren().add(telaInicial);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Karaokê Maclim");
        primaryStage.show();
    }

    private VBox criarTelaInicial(StackPane root, Stage stage) {
        TextField inputField = new TextField();
        inputField.setPromptText("Digite o número da música: ");
        inputField.setFont(Font.font(32));
        inputField.setMaxWidth(300);

        Label resultadoLabel = new Label();
        resultadoLabel.setFont(Font.font(28));

        inputField.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.length() == 4) {
                musicaSelecionada = MusicaJSONManager.buscarMusicaPorNumero(newValue);
                if (musicaSelecionada != null) {
                    String resultado = MusicaController.exibirNomeCantor(musicaSelecionada);
                    resultadoLabel.setText("🎵 " + resultado);
                } else {
                    resultadoLabel.setText("❌ Música não encontrada!");
                    musicaSelecionada = null;
                }
            } else {
                resultadoLabel.setText("");
                musicaSelecionada = null;
            }
        });

        inputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER && musicaSelecionada != null) {
                // Troca apenas o conteúdo do StackPane
                root.getChildren().setAll(VideoView.criarLayout(musicaSelecionada));
            }
        });

        VBox layout = new VBox(20, inputField, resultadoLabel);
        layout.setStyle("-fx-alignment: center; -fx-padding: 50;");
        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
