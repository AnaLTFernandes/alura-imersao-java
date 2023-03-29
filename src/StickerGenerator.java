import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Transparency;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickerGenerator {
    public void create(InputStream inputStream, String fileName) throws IOException {
        BufferedImage originalImage = ImageIO.read(inputStream);

        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        int newHeight = originalHeight + 200;
        BufferedImage newImage = new BufferedImage(originalWidth, newHeight, Transparency.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        graphics.drawString("IMAGEM LEGAL!", 100, newHeight - 100);

        ImageIO.write(newImage, "png", new File(fileName));
    }
}