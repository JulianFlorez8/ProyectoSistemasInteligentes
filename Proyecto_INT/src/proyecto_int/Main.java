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
    ArrayList<Nodo[]> mapaNodos;
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
            imprimir();
            Mapa.configurarMapa(mapa, inicio[0], inicio[1]);
            Scene s = Mapa.getMapa();
            escenario.setScene(s);
            JOptionPane.showMessageDialog(null, "Mapa cargado correctamente");
            String[] options = {"Anchura", "Profundidad", "Costo Uniforme", "Beam Search", "Hill climbing", "A estrella"};
            int selection = JOptionPane.showOptionDialog(null, "Tipo de algoritmo a aplicar:", "Hora de jugar Bomberman!", 0, 3, null, options, options[0]);
            switch (selection) {

                case 1: {

                    System.out.println("Usted eligió la opcion 1.");
                    anchura();

                    break;

                }

                case 2: {
                    profundidad();

                    System.out.println("Usted eligió la opcion 2.");

                    break;

                }

                case 3: {
                    costoUniforme();
                    System.out.println("Usted eligió la opcion 3.");

                    break;

                }

                case 4: {
                    beamSearch();
                    System.out.println("Usted eligió la opcion 3.");

                    break;

                }

                case 5: {
                    hillClimbing();
                    System.out.println("Usted eligió la opcion 3.");

                    break;

                }

                case 6: {
                    aEstrella();
                    System.out.println("Ejecucion A*");

                    break;

                }

                default: {

                    System.out.println("Opcion incorrecta");

                }
            }
            escenario.show();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se logro cargar el mapa" + e);
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
        mapaNodos = new ArrayList<Nodo[]>();
        for (String[] i : mapaTxt) {
            x = 0;
            Nodo[] filaTemporal = new Nodo[i.length];
            for (String j : i) {
                switch (j) {

                    case "I": {
                        filaTemporal[x] = new Nodo(x + "" + y);
                        //this.agregarAdyacencias(mapaTxt, x, y);
                        inicio[0] = x * 33;
                        inicio[1] = y * 32;
                        break;

                    }

                    case "F": {
                        filaTemporal[x] = new Nodo(x + "" + y);
                        //this.agregarAdyacencias(mapaTxt, x, y);
                        fin[0] = x * 33;
                        fin[1] = y * 32;
                        break;

                    }
                    case "M": {
                        filaTemporal[x] = null;
                        //filaTemporal.add(null);
                        break;

                    }
                    case "C": {
                        filaTemporal[x] = new Nodo(x + "" + y);
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

    public void imprimir() {
        String impreso ="";
        for (Nodo[] i : mapaNodos) {
            for (Nodo j : i) {
                if (j != null) {
                    impreso+=j.getNombre();
                } else {
                    impreso+="null";
                    
                }

            }
            System.out.println(impreso+ '\n');
            impreso ="";
        }
        
    }

    public void agregarAdyacencias(ArrayList<String[]> mapaTxt, int x, int y) {

    }

    public void crearArbol(ArrayList<String[]> mapaTxt) {

    }

    public void anchura() {

    }

    public void profundidad() {

    }

    private void costoUniforme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void beamSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void hillClimbing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aEstrella() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
