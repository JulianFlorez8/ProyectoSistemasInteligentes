package bomberman;

import Constantes.ConstantesGlobales;
import RecursosMapa.Bomba;
import Controles.ControlEntradas;
import Mapas.Mapa;
import java.util.Iterator;
import java.util.Vector;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import Entidades.Entidad;
/**
 *
 * * @author julian y migue
 */
public class CicloJuego {

    static double tiempoActual;
    static double viejoTiempo;
    static double tiempoDelta;
    final static long inicioJuegoNano = System.nanoTime();

    public static double getTiempoActual() {
        return tiempoActual;
    }

    public static void iniciar(GraphicsContext gc) {
        EstadoJuego.estadoJuego=ConstantesGlobales.ESTADO.CORRIENDO;
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
            	viejoTiempo = tiempoActual;
            	tiempoActual = (currentNanoTime - inicioJuegoNano) / 1000000000.0;
            	tiempoDelta = tiempoActual - viejoTiempo;
                gc.clearRect(0, 0, ConstantesGlobales.ANCHO_CANVAS, ConstantesGlobales.ANCHO_CANVAS);
                actualizarJuego();
                renderizarJuego();
            }
        }.start();
    }

    public static double getTiempoDelta() {
    	return tiempoDelta * 100;
    }

    public static void actualizarJuego() {
        ControlEntradas.controlEventosJugador();
        Vector<Entidad> entities = Mapa.getEntidades();
        Iterator<Entidad> it = entities.iterator();
        while (it.hasNext()) {
            Entidad entity = it.next();
            if(entity instanceof Bomba){
                boolean alive = ((Bomba) entity).isViva();
                if(!alive){
                    it.remove();
                }
            }
        }
    }

    public static void renderizarJuego() {
        for (Entidad e : Mapa.getEntidades()) {
            e.dibujar();
        }
    }

}
