    package app.karaoke.jorge.controller;

    import app.karaoke.jorge.model.Musica;
    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;
    import com.google.gson.reflect.TypeToken;

    import java.io.File;
    import java.io.FileReader;
    import java.io.IOException;
    import java.lang.reflect.Type;
    import java.util.ArrayList;
    import java.util.List;

    public class MusicaJSONManager {
        private static final String FILE_PATH = "musica.json";
        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        //Método para carregar as músicas do JSON
        private static List<Musica> carregarMusicas() {
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
        public static boolean verificarNumero(String numeroDigitado) {
            List<Musica> listaMusica = MusicaJSONManager.carregarMusicas();

            for (Musica musica : listaMusica) {
                if (musica.getNumero().equals(numeroDigitado)) {
                    System.out.println(musica.getNome() + " - " + musica.getCantor());
                    return true;
                }
            }
            return false;
        }

        public static Musica
        buscarMusicaPorNumero(String numeroDigitado) {
            List<Musica> listaMusica = carregarMusicas();
            for (Musica musica : listaMusica) {
                if (musica.getNumero().equals(numeroDigitado)) {
                    return musica;
                }
            }
            return null;
        }

    }
