import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String imdbUrl = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String nasaUrl = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-03-09&end_date=2022-03-11";
        String languagesAPIUrl = "http://localhost:8080/api/languages";

        ContentExtractor contentExtractor = new LanguagesContentExtractor();
        HttpRequestClient httpClient = new HttpRequestClient();

        String json = httpClient.search(languagesAPIUrl);
        List<Content> jsonContent = contentExtractor.extract(json);

        StickerGenerator stickerGenerator = new StickerGenerator();

        for (int i = 0; i < 3; i++) {
            Content item = jsonContent.get(i);
            String title = item.getTitle();

            InputStream inputStream = new URL(item.getUrlImage()).openStream();
            String nomeArquivo = "stickers-generator/images/" + title + ".png";

            stickerGenerator.create(inputStream, nomeArquivo);

            System.out.println(title + "\n");
        }
    }
}
