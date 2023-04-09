package RecursosMapa;

import bomberman.Renderizado;
import Animaciones.BombaAnimacion;
import Animaciones.Disfraz;
import java.util.Date;
import Entidades.EntidadEstatica;
import Entidades.Entidad;

/**
 *
 * * @author julian y migue
 */
public class Bomba implements EntidadEstatica {

    public int posicionX = 0;
    public int posicionY = 0;
    private int alto;
    private int ancho;
    private Disfraz disfraz;
    HitboxMuro muroMetal;
    BombaAnimacion animacionBomba;
    Date fecha;
    int tiempoInicialBomba = 2000;
    Estado estadoBomba;

    enum Estado {
        INACTIVA,
        ACTIVA,
        EXPLOTANDO,
        EXPLOTADA;
    }

    public Bomba(int x, int y) {
        posicionX = x;
        posicionY = y;
        ancho = 16;
        alto = 16;
        animacionBomba = new BombaAnimacion(this);
        disfraz = animacionBomba.getBomba();
        muroMetal = new HitboxMuro(posicionX, posicionY, ancho, alto);
        fecha = new Date();
        estadoBomba = Estado.ACTIVA;
    }

    public boolean isViva() {
        Estado s = checkearEstadoBomba();
        if (s == Estado.EXPLOTADA) {
            return false;
        } else {
            if (s == Estado.ACTIVA || s == Estado.INACTIVA) {
                return true;
            }
            return true;
        }
    }

    public Estado checkearEstadoBomba() {
        if (new Date().getTime() > tiempoInicialBomba + fecha.getTime()) {
            return Estado.EXPLOTADA;
        } else {
            return Estado.ACTIVA;
        }
    }

    @Override
    public boolean isColision(Entidad b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public HitboxMuro getCuadroLimite() {
        return muroMetal;
    }

    @Override
    public boolean isColisionAmigable() {
        return true;
    }

}
