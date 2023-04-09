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
 * * @author julian y migue
 */
public class JugadorAnimacion {

    Disfraz moveRight;
    Disfraz moveLeft;
    Disfraz moveUp;
    Disfraz moveDown;
    Disfraz idle;
    Disfraz die;
    double playSpeed;
    public JugadorAnimacion(Entidad e) {
        Image img = Renderizado.getSpiteSheet();
        playSpeed=0.1;
        moveDown  = new Disfraz(e, 30, 0.1, 0,  0, 3, ConstantesGlobales.ANCHO_PERSONAJE, ConstantesGlobales.ALTO_PERSONAJE, 2, false);
        moveLeft  = new Disfraz(e, 30, 0.1, 30, 0, 3, ConstantesGlobales.ANCHO_PERSONAJE, ConstantesGlobales.ALTO_PERSONAJE, 2, false);
        moveUp    = new Disfraz(e, 30, 0.1, 60, 0, 3, ConstantesGlobales.ANCHO_PERSONAJE - 1.5, ConstantesGlobales.ALTO_PERSONAJE, 2, false);
        moveRight = new Disfraz(e, 30, 0.1, 90, 0, 3, ConstantesGlobales.ANCHO_PERSONAJE, ConstantesGlobales.ALTO_PERSONAJE, 2, false);
        idle      = new Disfraz(e, 30, 0.1,118, 0, 1, ConstantesGlobales.ANCHO_PERSONAJE + 2, ConstantesGlobales.ALTO_PERSONAJE, 2, false);
        
        List<Rectangle> specs=new ArrayList<>();
        specs.add(new Rectangle(149, 0,20,21));
        specs.add(new Rectangle(179, 1,19,20));
        specs.add(new Rectangle(118, 30,21,21));
        specs.add(new Rectangle(149, 30,20,21));
        specs.add(new Rectangle(179, 30,19,21));
        specs.add(new Rectangle(118, 60,21,21));
        specs.add(new Rectangle(147, 60,23,22));
        die = new Disfraz(e,30,playSpeed,img, specs,ConstantesGlobales.ANCHO_PERSONAJE+2, ConstantesGlobales.ALTO_PERSONAJE+2, 2, false);
    }

    public Disfraz getMoveRightSprite() {
        return moveRight;
    }

    public Disfraz getMoveLeftSprite() {
        return moveLeft;
    }

    public Disfraz getMoveUpSprite() {
        return moveUp;
    }

    public Disfraz getMoveDownSprite() {
        return moveDown;
    }
    public Disfraz getPlayerIdleSprite(){
        return idle;
    }
    public Disfraz getPlayerDying(){
        return die;
    }
}
