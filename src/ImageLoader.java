import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader  {
    private static String imageName;

    public static BufferedImage loadImage(String nameOfImage) throws IOException{
        imageName = nameOfImage;
        File file = new File(imageName);
        BufferedImage image = ImageIO.read(file);
        return image;
    }

}
