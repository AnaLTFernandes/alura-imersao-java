import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI uri = URI.create(url);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        String body = response.body();
        JsonParser json = new JsonParser();
        List<Map<String, String>> moviesList = json.parse(body);

        StickerGenerator stickerGenerator = new StickerGenerator();

        for (int i = 0; i < 3; i++) {
            Map<String, String> movie = moviesList.get(i);
            String urlImage = movie.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String title = movie.get("title");

            InputStream inputStream = new URL(urlImage).openStream();
            String nomeArquivo = "images/" + title + ".png";

            stickerGenerator.create(inputStream, nomeArquivo);

            System.out.println(title);
            System.out.println();
        }
    }
}
