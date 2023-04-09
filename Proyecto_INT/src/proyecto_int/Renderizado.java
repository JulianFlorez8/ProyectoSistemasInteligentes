package bomberman;

import Animaciones.Disfraz;
import Mapas.Mapa;
import Utilidades.ImageUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 *
 * * @author julian y migue
 */
public class Renderizado {
    static Image img;
    static {
        img = ImageUtils.loadImage("Recursos/imagenes/disfraces_recuadro.png");
    }
    public static void inicializar() {
        
    }
    public static Image getSpiteSheet(){
        return img;
    }
    public static void animar(Disfraz disfraz) {
        double time = CicloJuego.getTiempoActual();
        GraphicsContext gc = Mapa.getContextoGrafico();
        if (disfraz.disfrazValido) {
            Renderizado.playAnimacion(disfraz.disfraces, disfraz.velocidad, disfraz.getPosicionX(), disfraz.getPosicionY(), disfraz.ancho*disfraz.escala, disfraz.alto*disfraz.escala);
        } else {
            playAnimacion(gc, time, disfraz.tamanoActual, disfraz.localizacionX, disfraz.localizacionY, disfraz.numeroImagenes, disfraz.getPosicionX(), disfraz.getPosicionY(), disfraz.ancho, disfraz.alto, disfraz.escala, disfraz.reproducir, disfraz.velocidad);
        }
    }

    public static void playAnimacion(Image[] imgs, double speed, int x, int y, double w, double h) {
        double time = CicloJuego.getTiempoActual();
        GraphicsContext gc = Mapa.getContextoGrafico();
        int numberOfFrames = imgs.length;
        int index = findCurrentFrame(time, numberOfFrames, speed);
        gc.drawImage(imgs[index], x, y, w, h);
    }

    public static void playAnimacion(GraphicsContext gc, double tiempo ,int tamanoActual, int inicioX, int inicioY, int numeroImagenes, int x, int y, double ancho, double alto, double escala, boolean reversa, double velocidad) {

        double speed = velocidad >= 0 ? velocidad : 0.3;

        int index = findCurrentFrame(tiempo, numeroImagenes, speed);
        int newSpriteSheetX = reversa ? inicioX + index * tamanoActual : inicioX;
        int newSpriteSheetY = reversa ? inicioY : inicioY + index * tamanoActual;
        gc.drawImage(img, newSpriteSheetX, newSpriteSheetY, ancho, alto, x, y, ancho * escala, alto * escala);
    }

    private static int findCurrentFrame(double time, int totalFrames, double speed) {
        return (int) (time % (totalFrames * speed) / speed);
    }
}
