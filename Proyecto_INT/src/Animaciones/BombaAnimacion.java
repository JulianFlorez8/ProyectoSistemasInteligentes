package Animaciones;

import bomberman.Renderizado;
import Constantes.ConstantesGlobales;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import Entidades.Entidad;

/**
 *
 * @author miguel y julian
 */
public class BombaAnimacion {

    Disfraz bomba;
    double velocidadReproducion;

    public Disfraz getBomba() {
        return bomba;
    }

    public void setBomba(Disfraz bomba) {
        this.bomba = bomba;
    }

    public BombaAnimacion(Entidad e) {
        Image img = Renderizado.getSpiteSheet();
        velocidadReproducion = 0.3;

        List<Rectangle> specs = new ArrayList<>();
        specs.add(new Rectangle(181, 93, 17, 16));
        specs.add(new Rectangle(211, 93, 16, 16));
        specs.add(new Rectangle(240, 93, 18, 17));
        bomba = new Disfraz(e, 30, velocidadReproducion, img, specs, ConstantesGlobales.ANCHO_PERSONAJE + 2, ConstantesGlobales.ALTO_PERSONAJE + 2, 2, false);
    }
}
