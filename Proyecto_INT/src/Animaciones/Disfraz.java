package Animaciones;

import Utilidades.ImageUtils;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import Entidades.Entidad;
/**
 *
 * * @author julian y migue
 */
public class Disfraz
{
	public double velocidad;
	public int localizacionX;
	public int localizacionY;
	public int numeroImagenes;
	public double ancho;
	public double alto;
	public int escala;
	public int tamanoActual;
	public boolean reproducir;

        public Image[] disfraces;
        public boolean disfrazValido;
        
        public Entidad entityReference;
        
	public Disfraz(Entidad e, int tamanoActual, double velocidad, int localizacionX, int localizacionY, int numeroImagenes, double ancho, double alto,
			int escala, boolean reproducir)
	{
		super();
		this.tamanoActual = tamanoActual;
		this.velocidad = velocidad;
		this.localizacionX = localizacionX;
		this.localizacionY = localizacionY;
		this.numeroImagenes = numeroImagenes;
		this.ancho = ancho;
		this.alto = alto;
		this.escala = escala;
		reproducir = reproducir;
                this.entityReference=e;
	}

	public int getPosicionX() {
		return entityReference.getPosicionX();
	}

	public int getPosicionY() {
		return entityReference.getPosicionY();
	}


    public Disfraz(Entidad e,int tamanoActual,double velocidad,Image cuadroDisfraces,List<Rectangle> especificaciones,double ancho, double alto,int escala, boolean haciaDerecha){
        super();
        this.tamanoActual = tamanoActual;
        this.velocidad = velocidad;
        this.numeroImagenes=especificaciones.size();
        this.ancho = ancho;
        this.alto = alto;
        this.escala = escala;
        reproducir = haciaDerecha;
        this.entityReference=e;
        disfrazValido=true;
        disfraces=new Image[especificaciones.size()];
        for (int i = 0; i < especificaciones.size(); i++) {
            Rectangle specification = especificaciones.get(i);
            int x=(int)specification.getX();
            int y=(int)specification.getY();
            int w=(int)specification.getWidth();
            int h=(int)specification.getHeight();

            disfraces[i]=ImageUtils.cortar(cuadroDisfraces, x, y, w, h);
        }
    }
}
