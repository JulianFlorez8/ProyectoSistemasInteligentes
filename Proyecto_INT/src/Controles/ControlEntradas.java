package Controles;

import java.util.List;

import Constantes.Direccion;
import Jugador.Jugador;
import RecursosMapa.Bomba;
import Mapas.Mapa;
import java.util.Iterator;
import java.util.Vector;
import javafx.scene.input.KeyCode;
import Entidades.Entidad;
/**
 *
 * * @author julian y migue
 */
public class ControlEntradas {

    public static void controlEventosJugador(){
        List entradaTeclado = ControlEventos.getlistaEntradas();
        Jugador player = Mapa.getJugador();
        if(entradaTeclado.contains(KeyCode.UP) || entradaTeclado.contains(KeyCode.W)){
            player.mover(5,Direccion.ARRIBA);
        }
        if(entradaTeclado.contains(KeyCode.DOWN) || entradaTeclado.contains(KeyCode.S)){
            player.mover(5,Direccion.ABAJO);
        }
        if(entradaTeclado.contains(KeyCode.LEFT) || entradaTeclado.contains(KeyCode.A)){
            player.mover(5,Direccion.IZQUIERDA);
        }
        if(entradaTeclado.contains(KeyCode.RIGHT) || entradaTeclado.contains(KeyCode.D)){
            player.mover(5,Direccion.DERECHA);
        }
        if( !entradaTeclado.contains(KeyCode.LEFT) &&
            !entradaTeclado.contains(KeyCode.RIGHT) &&
            !entradaTeclado.contains(KeyCode.UP) &&
            !entradaTeclado.contains(KeyCode.DOWN) &&
            !entradaTeclado.contains(KeyCode.W) &&
            !entradaTeclado.contains(KeyCode.A) &&
            !entradaTeclado.contains(KeyCode.S) &&
            !entradaTeclado.contains(KeyCode.D)
          )
        {
            player.mover(0, Direccion.ABAJO);
        }
        
        //eliminar Bomba
        if(entradaTeclado.contains(KeyCode.SPACE)){           
            Mapa.addEntidad(new Bomba(player.getPosicionX(), player.getPosicionY()));
        }        
    }

}
