package Controles;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * * @author julian y migue
 */
public class ControlEventos {
    public static char ultimaTeclaPresionada;
    public static char ultimaTeclaSoltada;
    public static ArrayList<KeyCode> listaEntradas = new ArrayList<KeyCode>();

    public static void attachEventHandlers(Scene s){
        keyReleaseHanlder krh = new keyReleaseHanlder();
        keyPressedHandler kph = new keyPressedHandler();
        s.setOnKeyReleased(krh);
        s.setOnKeyPressed(kph);
    }

    public boolean isTeclaPresionada(KeyCode k) {
    	if( listaEntradas.contains(k)){
    		return true;
        }else{
            return false;
        }
    }
    
    public static List getlistaEntradas(){
        return listaEntradas;
    }
}

class keyReleaseHanlder implements javafx.event.EventHandler<KeyEvent>{
    public keyReleaseHanlder() {
    }
    @Override
    public void handle(KeyEvent evt) {

        KeyCode code = evt.getCode();

        if ( ControlEventos.listaEntradas.contains(code) )
        	ControlEventos.listaEntradas.remove( code );
    }
}
class keyPressedHandler implements javafx.event.EventHandler<KeyEvent>{
    @Override
    public void handle(KeyEvent evt) {
        KeyCode code = evt.getCode();
        
        if ( !ControlEventos.listaEntradas.contains(code) )
        	ControlEventos.listaEntradas.add( code );
    }
}
