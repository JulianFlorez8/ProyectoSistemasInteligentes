package Entidades;

import RecursosMapa.HitboxMuro;


/**
 *
 * * @author julian y migue
 */
public interface Entidad {
    boolean isColision(Entidad b);
    boolean isColisionAmigable();
    void dibujar();
    void removerDelMapa();
    int getPosicionX();
    int getPosicionY();
    HitboxMuro getCuadroLimite();
    
}
