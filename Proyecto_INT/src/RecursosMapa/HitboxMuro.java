package RecursosMapa;

import javafx.geometry.Rectangle2D;
/**
 *
 * * @author julian y migue
 */
public class HitboxMuro {

    int x;
    int y;
    int ancho;
    int alto;
    Rectangle2D perimetro;

    public HitboxMuro(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        ancho=w;
        alto=h;
        perimetro = new Rectangle2D(x, y, ancho, alto);
    }

    public Rectangle2D getPerimetro() {
        return perimetro;
    }

    public boolean checkearColisiones(HitboxMuro b) {
        return b.getPerimetro().intersects(getPerimetro());
    }

    public void setPosicion(int x, int y) {
    	this.x = x;
    	this.y = y;
    	perimetro = new Rectangle2D(x, y, ancho, alto);
    }

}
