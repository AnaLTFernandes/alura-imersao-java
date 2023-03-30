import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpRequestClient {
    public String search(String url) {
        try {
            URI uri = URI.create(url);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}