package app.karaoke.jorge.view;

import app.karaoke.jorge.controller.MusicaJSONManager;
import app.karaoke.jorge.controller.MusicaController;
import app.karaoke.jorge.model.Musica;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KaraokeApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        inputField.setPromptText("Digite o número da música (ex: 0001)");
        inputField.setFont(Font.font(32));
        inputField.setMaxWidth(300);

        Label resultadoLabel = new Label();
        resultadoLabel.setFont(Font.font(28));

        Button tocarButton = new Button("Tocar Música");
        tocarButton.setFont(Font.font(24));
        tocarButton.setOnAction(e -> {
            String numeroMusica = inputField.getText().trim();

            // Buscar a música no JSON
            Musica musica = MusicaJSONManager.buscarMusicaPorNumero(numeroMusica);
            if (musica != null) {
                String resultado = MusicaController.exibirNomeCantor(musica);
                resultadoLabel.setText("🎵 " + resultado);
            } else {
                resultadoLabel.setText("❌ Música não encontrada!");
            }
        });

        VBox root = new VBox(20, inputField, tocarButton, resultadoLabel);
        root.setStyle("-fx-alignment: center; -fx-padding: 50;");

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Karaokê Maclim");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
