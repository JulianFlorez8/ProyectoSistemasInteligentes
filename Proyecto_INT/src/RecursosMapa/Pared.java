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
 * @author julian y migual
 */
public abstract  class Pared implements EntidadEstatica {
    public int posicionX = 0;
    public int posicionY = 0;
    private int alto;
    private int ancho;
    private Disfraz disfraz;
    HitboxMuro limite;


    public Pared (int x, int y) {
    	posicionX = x;
    	posicionY = y;
        ancho = 16;
    	alto = 16;
    }

}
