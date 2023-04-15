/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursosMapa;

import Animaciones.Disfraz;
import Entidades.Entidad;
import Entidades.EntidadEstatica;
import bomberman.Renderizado;

/**
 *
 * @author NEWSHORE_
 */
public class Puerta implements EntidadEstatica {
    public int posicionX = 0;
    public int posicionY = 0;
    private int alto;
    private int ancho;
    private Disfraz disfraz;
    HitboxMuro limite;


    public Puerta (int x, int y) {
    	posicionX = x;
    	posicionY = y;

    	ancho = 0;
    	alto = 0;

    	disfraz = new Disfraz(this, 16, 0, 349, 93, 1, 16, 16, 2, false);
    	limite = new HitboxMuro(1, 1, 1, 1);
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
