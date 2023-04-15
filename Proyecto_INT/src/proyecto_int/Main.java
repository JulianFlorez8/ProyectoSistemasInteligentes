package bomberman;

import Constantes.ConstantesGlobales;
import Mapas.Mapa;
import Modelos.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * * @author julian y migue
 */
public class Main extends Application {

    ArrayList<String[]> mapa;
    ArrayList<ArrayList<Nodo>> mapaNodos;
    int[] inicio;
    int[] fin;

    @Override
    public void start(Stage escenario) {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            mapa = new ArrayList<String[]>();
            String linea = "";
            while (((linea = br.readLine()) != null)) {
                mapa.add(linea.split(","));
                System.out.println(linea);
            }
            
            escenario.setTitle(ConstantesGlobales.NOMBRE + ConstantesGlobales.VERSION);
            buscarInicioFinal(mapa);
            Mapa.configurarMapa(mapa, inicio[0], inicio[1]);
            Scene s = Mapa.getMapa();
            escenario.setScene(s);
            JOptionPane.showMessageDialog(null, "Mapa cargado correctamente");
            String[] options = {"Anchura", "Profundidad", "Costo Uniforme", "Beam Search", "Hill climbing", "A estrella"};
            int selection = JOptionPane.showOptionDialog(null, "Tipo de algoritmo a aplicar:", "Hora de jugar Bomberman!", 0, 3, null, options, options[0]);
            switch (selection) {

                case 1: {

                    System.out.println("Usted eligió la opcion 1.");

                    break;

                }

                case 2: {

                    System.out.println("Usted eligió la opcion 2.");

                    break;

                }

                case 3: {

                    System.out.println("Usted eligió la opcion 3.");

                    break;

                }

                case 4: {

                    System.out.println("Usted eligió la opcion 3.");

                    break;

                }

                case 5: {

                    System.out.println("Usted eligió la opcion 3.");

                    break;

                }

                case 6: {

                    System.out.println("Usted eligió la opcion 3.");

                    break;

                }

                default: {

                    System.out.println("Opcion incorrecta");

                }
            }
            escenario.show();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se logro cargar el mapa"+e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void buscarInicioFinal(ArrayList<String[]> mapaTxt) {
        System.out.println("entra");
        int x = 0;
        int y = 0;
        inicio = new int[2];
        fin = new int[2];
        mapaNodos = new ArrayList<ArrayList<Nodo>>();
        for (String[] i : mapaTxt) {
            x = 0;
            ArrayList<Nodo> filaTemporal = new ArrayList<Nodo>();

            for (String j : i) {
                switch (j) {

                    case "I": {
                        //filaTemporal.add(new Nodo(x + "" + y));
                        //this.agregarAdyacencias(mapaTxt, x, y);
                        inicio[0] = x * 33;
                        inicio[1] = y * 32;
                        break;

                    }

                    case "F": {
                        //filaTemporal.add(new Nodo(x + "" + y));
                        //this.agregarAdyacencias(mapaTxt, x, y);
                        fin[0] = x * 33;
                        fin[1] = y * 32;
                        break;

                    }
                    case "M": {
                        //filaTemporal.add(null);
                        break;

                    }
                    case "C": {
                        //filaTemporal.add(new Nodo(x + "" + y));
                        //this.agregarAdyacencias(mapaTxt, x, y);
                        break;

                    }
                    default: {

                    }
                }
                x++;
            }
            mapaNodos.add(filaTemporal);
            y++;

        }
    }

    public void agregarAdyacencias(ArrayList<String[]> mapaTxt, int x, int y) {
        ArrayList<Nodo> lista = new ArrayList<Nodo>();
        if(x>0){
            lista.add(new Nodo(x-1 + "" + y));
            
        }
        if(x<(mapaTxt.get(0).length-1)){
            lista.add(new Nodo(x+1 + "" + y));
        }
        if(y>0){
            lista.add(new Nodo(x + "" + (y-1)));
            
        }
        if(y<(mapaTxt.size()+1)){
            lista.add(new Nodo(x + "" + (y+1)));
        }

    }

    public void crearArbol(ArrayList<String[]> mapaTxt) {

    }

}
