package RecursosMapa;

import bomberman.Renderizado;
import Animaciones.Disfraz;
import Constantes.ConstantesGlobales;
import javafx.scene.paint.Color;
import Entidades.EntidadEstatica;
import Entidades.Entidad;

/**
 *
 * * @author julian y migue
 */
public class ParedDestructible implements EntidadEstatica {
    public int posicionX = 0;
    public int posicionY = 0;
    private int alto;
    private int ancho;
    private Disfraz disfraz;
    HitboxMuro limite;


    public ParedDestructible (int x, int y) {
    	posicionX = x;
    	posicionY = y;

    	ancho = 30;
    	alto = 30;

    	disfraz = new Disfraz(this, 16, 0, 348, 153, 1, 16, 16, 2, false);
    	limite = new HitboxMuro(posicionX, posicionY, ancho, alto);
    }

    @Override
    public boolean isColision(Entidad b) {
        throw new UnsupportedOperationException("No hecha aun.");
    }

    @Override
    public void dibujar() {
        Renderizado.animar(disfraz);
    }

    @Override
    public void removerDelMapa() {
        throw new UnsupportedOperationException("funcion para eliminar bloque, aun no implementada.");
    }

    @Override
    public int getPosicionX() {
        return posicionX;
    }

    @Override
    public int getPosicionY() {
        return posicionY;
    }

    @Override
    public HitboxMuro getCuadroLimite()
    {
            return limite;
    }

    @Override
    public boolean isColisionAmigable() {
        return false;
    }

}
