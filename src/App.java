import java.net.URI;
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

        for (Map<String, String> movie : moviesList) {
            System.out.println("Nome do filme: \"" + movie.get("title") + "\" - Rating: " + movie.get("imDbRating"));
            System.out.println();
        }
    }
}
