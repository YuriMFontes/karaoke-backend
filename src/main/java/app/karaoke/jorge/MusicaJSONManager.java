package app.karaoke.jorge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MusicaJSONManager {
    private static final String FILE_PATH = "musica.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    //Método para adicionar música ao JSON
    static void adicionarMusica(Musica musica) {
        List<Musica> listaMusica = carregarMusicas();
        listaMusica.add(musica);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(listaMusica, writer);
            System.out.println("Música adicionada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a música: " + e.getMessage());
        }
    }

    //Método para carregar as músicas do JSON
    static List<Musica> carregarMusicas() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<Musica>>() {}.getType();
            List<Musica> listaMusica = GSON.fromJson(reader, listType);

            if (listaMusica == null) {
                return new ArrayList<>();
            } return listaMusica;

        } catch (IOException e) {
            System.out.println("Erro ao carregar músicas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    //Método para verificar se o número digitado corresponde a uma música no JSON
    static boolean verificarNumero(String numeroDigitado) {
        List<Musica> listaMusica = MusicaJSONManager.carregarMusicas();

        for (Musica musica : listaMusica) {
            if (musica.getNumero().equals(numeroDigitado)) {
                return true;
            }
        }
        return false;
    }
}
