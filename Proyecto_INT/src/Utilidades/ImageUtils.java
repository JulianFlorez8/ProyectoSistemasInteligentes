package Utilidades;

import javafx.scene.image.Image;

import java.io.File;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
/**
 *
 * * @author julian y migue
 */
public class ImageUtils {
    public static Image loadImage(String path) {
        File file = new File(path);
        String imagePath = file.getAbsolutePath();
        if (File.separatorChar == '\\') {
            // de windows a linux
            imagePath=imagePath.replace('/', File.separatorChar);
            imagePath = imagePath.replace("\\", "\\\\");
        } else {
            // de linux a windows
            imagePath=imagePath.replace('\\', File.separatorChar);

        }
        imagePath="file:"+imagePath;

        return new Image(imagePath);
    }
    public static Image cortar(Image img,int x,int y,int w,int h){
        PixelReader reader = img.getPixelReader();
        WritableImage imagenNueva = new WritableImage(reader, x, y, w, h);
        return imagenNueva;
    }
}
