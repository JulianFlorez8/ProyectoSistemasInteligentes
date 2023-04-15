package Mapas;

import java.util.Vector;

import bomberman.CicloJuego;
import bomberman.Renderizado;
import Constantes.ConstantesGlobales;
import Jugador.Jugador;
import RecursosMapa.Bomba;
import RecursosMapa.ParedIndestructible;
import RecursosMapa.ParedDestructible;
import Controles.ControlEventos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import Entidades.Entidad;
import static Constantes.ConstantesGlobales.ANCHO_CANVAS;
import static Constantes.ConstantesGlobales.ALTO_CANVAS;
import RecursosMapa.Puerta;
import java.util.ArrayList;

/**
 *
 * @author julian y migue
 */
public class Mapa {

    static Scene mapa;
    static Group root;
    static Canvas c;
    static GraphicsContext contextoGraficos;
    private static boolean mapaListo;
    static Jugador mapaJugador;

    static {
        mapaListo = false;
    }

    private static Vector<Entidad> entidades = new Vector<Entidad>();

    public static Vector<Entidad> getEntidades() {
        return entidades;
    }

    public static boolean addEntidad(Entidad e) {
        if (!entidades.contains(e)) {
            entidades.add(e);
            return true;
        } else {
            return false;
        }
    }

    private static void inicializar(ArrayList<String[]> mapaTxt, int xInicio, int yInicio) {
        root = new Group();
        int anchoMapa = mapaTxt.get(0).length * 33;
        int altoMapa = mapaTxt.size() * 33;
        mapa = new Scene(root, anchoMapa, altoMapa, ConstantesGlobales.COLOR_FONDO);
        c = new Canvas(anchoMapa, altoMapa);
        root.getChildren().add(c);
        contextoGraficos = c.getGraphicsContext2D();
        contextoGraficos.setStroke(Color.BLUE);
        contextoGraficos.setLineWidth(2);
        contextoGraficos.setFill(Color.BLUE);
        Renderizado.inicializar();
        CicloJuego.iniciar(contextoGraficos);

        Jugador p = new Jugador(xInicio, yInicio);
        setJugador(p);

        cargarMapa(mapaTxt);

        ControlEventos.attachEventHandlers(mapa);

    }

    public static void cargarMapa(ArrayList<String[]> mapaTxt) {
        int x = 0;
        int y = 0;
        for (String[] i : mapaTxt) {
            x = 0;
            for (String j : i) {
                switch (j) {

                    case "M": {
                        addEntidad(new ParedIndestructible(x, y));
                        break;

                    }

                    case "R": {
                        addEntidad(new ParedDestructible(x, y));
                        break;

                    }
                    case "F": {
                        addEntidad(new Puerta(x, y));
                        break;
                    }
                    default: {

                    }
                }
                x += 33;
            }
            y += 32;

        }
    }

    public static void configurarMapa(ArrayList<String[]> mapaTxt, int xInicio, int yInicio) {
        if (!mapaListo) {
            inicializar(mapaTxt, xInicio, yInicio);
            mapaListo = true;
        }
    }

    public static Scene getMapa() {
        return mapa;
    }

    public static GraphicsContext getContextoGrafico() {
        return contextoGraficos;
    }

    public static Canvas getCanvas() {
        return c;
    }

    public static void setJugador(Jugador p) {
        mapaJugador = p;
        addEntidad(p);
    }

    public static Jugador getJugador() {
        return mapaJugador;
    }
}
