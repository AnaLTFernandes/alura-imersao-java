import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor {
    public List<Content> extract(String json) {
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> attributesList = jsonParser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attribute : attributesList) {
            String title = attribute.get("title");
            String image = attribute.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

            Content content = new Content(title, image);
            contents.add(content);
        }

        return contents;
    }
}
