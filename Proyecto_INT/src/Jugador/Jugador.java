package Jugador;

import bomberman.CicloJuego;
import bomberman.Renderizado;
import Animaciones.JugadorAnimacion;
import Animaciones.Disfraz;
import Constantes.Direccion;
import Constantes.ConstantesGlobales;
import Mapas.Mapa;
import Entidades.Entidad;
import Entidades.EntidadMatable;
import Entidades.EntidadMover;
import Modelos.Nodo;
import RecursosMapa.HitboxMuro;
import java.util.ArrayList;

/**
 *
 * * @author julian y migue
 */
public class Jugador implements EntidadMover, EntidadMatable {

    private int vida;
    private boolean estaVivo;
    HitboxMuro limite;

    Disfraz disfrazActual;
    JugadorAnimacion jugadorAnimacion;

    Direccion direccionActual;

    public int positionX = 0;
    public int positionY = 0;

    String nombre;
    private ArrayList<Nodo> camino;

    public ArrayList<Nodo> getCamino() {
        return camino;
    }

    public void setCamino(ArrayList<Nodo> camino) {
        this.camino = camino;
    }

    public Jugador() {
        inicializar(64, 64);
    }

    public Jugador(int posX, int posY) {
        inicializar(posX, posY);
        vida = 100;
        estaVivo = true;
        this.camino = new ArrayList<Nodo>();
    }

    private void inicializar(int x, int y) {
        nombre = "Jugador";

        jugadorAnimacion = new JugadorAnimacion(this);

        positionX = x;
        positionY = y;

        limite = new HitboxMuro(positionX, positionY, ConstantesGlobales.ANCHO_PERSONAJE, ConstantesGlobales.ALTO_PERSONAJE);

        disfrazActual = jugadorAnimacion.getPlayerIdleSprite();
    }

    public void mover(Direccion direction) {
        Jugador.this.mover(1, direction);
    }

    private void setDisfrazActual(Disfraz s) {
        if (s != null) {
            disfrazActual = s;
        } else {
            System.out.println("Error! Disfraz no encontrado");
        }
    }

    public int getVida() {
        return vida;
    }

    public boolean isVivo() {
        return estaVivo;
    }

    public String toString() {
        return nombre;
    }

    public void irAX(int x,Direccion direccion ) {

        switch (direccion) {
            case IZQUIERDA:
                if (!checkearColisiones(x, positionY)) {
                    positionX = x;
                    setDisfrazActual(jugadorAnimacion.getMoveLeftSprite());
                    direccionActual = Direccion.IZQUIERDA;
                }
                break;
            case DERECHA:
                if (!checkearColisiones(x, positionY)) {
                    positionX = x;
                    setDisfrazActual(jugadorAnimacion.getMoveRightSprite());
                    direccionActual = Direccion.DERECHA;
                }
                break;
            default:
                setDisfrazActual(jugadorAnimacion.getPlayerIdleSprite());
        }

    }
    public void irAY(int y,Direccion direccion ) {

        switch (direccion) {
            case ARRIBA:
                if (!checkearColisiones(positionX,y)) {
                    positionY = y;
                    setDisfrazActual(jugadorAnimacion.getMoveUpSprite());
                    direccionActual = Direccion.ARRIBA;
                }
                break;
            case ABAJO:
                if (!checkearColisiones(positionX, y)) {
                    positionY = y;
                    setDisfrazActual(jugadorAnimacion.getMoveDownSprite());
                    direccionActual = Direccion.ABAJO;
                }
                break;
            
            default:
                setDisfrazActual(jugadorAnimacion.getPlayerIdleSprite());
        }

    }

    @Override
    public boolean isColision(Entidad b) {
        HitboxMuro otherEntityBoundary = (HitboxMuro) b.getCuadroLimite();
        return limite.checkearColisiones(otherEntityBoundary);
    }

    @Override
    public void dibujar() {
        if (disfrazActual != null) {
            Renderizado.animar(disfrazActual);
        }
    }

    @Override
    public void morir() {
        setDisfrazActual(jugadorAnimacion.getPlayerDying());
    }

    private boolean checkearColisiones(int x, int y) {
        limite.setPosicion(x, y);

        for (Entidad e : Mapa.getEntidades()) {
            if (e != this && isColision(e) && !e.isColisionAmigable()) {
                limite.setPosicion(positionX, positionY);
                return true;
            }
        }
        limite.setPosicion(positionX, positionY);
        return false;
    }

    @Override
    public void mover(int steps, Direccion direction) {

        steps *= CicloJuego.getTiempoDelta();

        if (steps == 0) {
            setDisfrazActual(jugadorAnimacion.getPlayerIdleSprite());
            return;
        } else {
            switch (direction) {
                case ARRIBA:
                    if (!checkearColisiones(positionX, positionY - steps)) {
                        positionY -= steps;
                        setDisfrazActual(jugadorAnimacion.getMoveUpSprite());
                        direccionActual = Direccion.ARRIBA;
                    }
                    break;
                case ABAJO:
                    if (!checkearColisiones(positionX, positionY + steps)) {
                        positionY += steps;
                        setDisfrazActual(jugadorAnimacion.getMoveDownSprite());
                        direccionActual = Direccion.ABAJO;
                    }
                    break;
                case IZQUIERDA:
                    if (!checkearColisiones(positionX - steps, positionY)) {
                        positionX -= steps;
                        setDisfrazActual(jugadorAnimacion.getMoveLeftSprite());
                        direccionActual = Direccion.IZQUIERDA;
                    }
                    break;
                case DERECHA:
                    if (!checkearColisiones(positionX + steps, positionY)) {
                        positionX += steps;
                        setDisfrazActual(jugadorAnimacion.getMoveRightSprite());
                        direccionActual = Direccion.DERECHA;
                    }
                    break;
                default:
                    setDisfrazActual(jugadorAnimacion.getPlayerIdleSprite());
            }
        }
    }

    @Override
    public void reducirVida(int damage) {
        if (vida - damage <= 0) {
            morir();
        } else {
            vida -= damage;
        }
    }

    @Override
    public void removerDelMapa() {
        throw new UnsupportedOperationException("funcion para eliminar bloque, aun no implementada.");
    }

    @Override
    public int getPosicionX() {
        return positionX;
    }

    @Override
    public int getPosicionY() {
        return positionY;
    }

    @Override
    public HitboxMuro getCuadroLimite() {
        limite.setPosicion(positionX, positionY);
        return limite;
    }

    @Override
    public boolean isColisionAmigable() {
        return true;
    }
}
