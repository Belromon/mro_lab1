import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedImage image = ImageLoader.loadImage("pics/1.png");
    DisplayImage.display(image);
    }
}
