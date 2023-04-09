package Constantes;

import javafx.scene.paint.Color;

/**
 *
 * @author miguel y julian 
 */
public class ConstantesGlobales {

    public static int ANCHO_CANVAS = 640;
    public static int ALTO_CANVAS = 680;
    public static String NOMBRE = "BomberMan";
    public static String VERSION = "  v 0.1";
    public static Color COLOR_FONDO = Color.GREEN;
    public static int ANCHO_PERSONAJE = 18;
    public static int ALTO_PERSONAJE = 21;
    public static int ESCALA_PERSONAJE = 2;
    public static enum ESTADO{
        CORRIENDO,PAUSADO,FIN
    }
}
