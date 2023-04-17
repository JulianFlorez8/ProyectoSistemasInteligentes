package Entidades;

/**
 *
 * * @author julian y migue
 */
public interface EntidadMatable extends Entidad {

    public void morir();
    public void reducirVida(int dano);
    public int getVida();

}
