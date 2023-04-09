package Entidades;

import Constantes.Direccion;
/**
 *
 * * @author julian y migue
 */
public interface EntidadMover extends Entidad {


    public void mover(int steps, Direccion direction);

}
