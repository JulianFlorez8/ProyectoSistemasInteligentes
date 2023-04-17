package proyecto_int;

import Algoritmos.Informada.HeuristicaEnum;
import Algoritmos.Informada.aEstrella.AEstrella;
import Algoritmos.NoInformada.BusquedadAnchura;
import Algoritmos.NoInformada.BusquedadProfundidad;
import Constantes.ConstantesGlobales;
import Constantes.Direccion;
import Jugador.Jugador;
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
    Nodo nodoInicial;
    Nodo nodoFinal;
    String[] nombresNodos = "ABCDEFGHIJKLMNOPQRSTQWXYZabcdefghijqlmnopqrstq".split("");

    @Override
    public void start(Stage escenario) throws InterruptedException {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        int selection = -1;
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
            agregarAdyacencias();
            
            JOptionPane.showMessageDialog(null, "Mapa cargado correctamente");
            String[] options = {"Anchura", "Profundidad recursivo", "Profundidad iterativo", 
                "Costo Uniforme", "Beam Search", "Hill climbing", "A estrella Euclidiana", "A estrella Manhattan"};
            selection = JOptionPane.showOptionDialog(null, "Tipo de algoritmo a aplicar:", "Hora de jugar Bomberman!", 0, 3, null, options, options[0]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se logro cargar el mapa" + e);
        }
        switch (selection) {

            case 0: {

                System.out.println("Ejecución Anchura");
                anchura();

                break;

            }

            case 1: {
                profundidad("Recursivo");

                System.out.println("Ejecución Profundidad recursivo");

                break;

            }
            case 2: {
                profundidad("Iterativo");

                System.out.println("Ejecución Profundidad iterativo");

                break;

            }

            case 3: {
                costoUniforme();
                System.out.println("Ejecución Costo uniforme");

                break;

            }

            case 4: {
                beamSearch();
                System.out.println("Ejecución Beam Search");

                break;

            }

            case 5: {
                hillClimbing();
                System.out.println("Ejecución Jill Climbing");

                break;

            }

            case 6: {
                aEstrella(HeuristicaEnum.Euclidiana);
                System.out.println("Ejecucion A* Euclidiana");

                break;

            }
            case 7: {
                aEstrella(HeuristicaEnum.Manhattan);
                System.out.println("Ejecucion A* Manhattan");
                break;
            }

            default: {

                System.out.println("Opcion incorrecta");

            }
        }
        escenario.show();
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

                        filaTemporal[x] = new Nodo(nombresNodos[x] + "-" + nombresNodos[y],x*33,y*32);
                        //this.agregarAdyacencias(mapaTxt, x, y);
                        nodoInicial = filaTemporal[x];
                        inicio[0] = x * 33;
                        inicio[1] = y * 32;
                        break;

                    }

                    case "F": {
                        filaTemporal[x] = new Nodo(nombresNodos[x] + "-" + nombresNodos[y],x*33,y*32);
                        //this.agregarAdyacencias(mapaTxt, x, y);
                        nodoFinal = filaTemporal[x];
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
                        filaTemporal[x] = new Nodo(nombresNodos[x] + "-" + nombresNodos[y],x*33,y*32);
                        System.out.println(filaTemporal[x]);
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
        String impreso = "";
        for (Nodo[] i : mapaNodos) {
            for (Nodo j : i) {
                if (j != null) {
                    impreso += j.getNombre() + "_";
                } else {
                    impreso += "---";

                }

            }
            System.out.println(impreso + '\n');
            impreso = "";
        }

    }

    public void agregarAdyacencias() {
        int x = 0;
        int y = 0;
        for (Nodo[] i : mapaNodos) {
            x = 0;
            for (Nodo j : i) {
                if (j != null) {
                    if (mapaNodos.get(y - 1)[x] != null) {
                        mapaNodos.get(y - 1)[x].addAdyacencia(j);
                    };
                    if (mapaNodos.get(y + 1)[x] != null) {
                        mapaNodos.get(y + 1)[x].addAdyacencia(j);
                    };
                    if (mapaNodos.get(y)[x - 1] != null) {
                        mapaNodos.get(y)[x - 1].addAdyacencia(j);
                    };
                    if (mapaNodos.get(y)[x + 1] != null) {
                        mapaNodos.get(y)[x + 1].addAdyacencia(j);
                    };
                }
                x++;
            }
            y++;
        }

    }

    public void crearArbol(ArrayList<String[]> mapaTxt) {

    }

    public void anchura() {
        BusquedadAnchura algoritmo = new BusquedadAnchura();
        algoritmo.bfs(nodoInicial, nodoFinal.getNombre());
        Mapa.getJugador().setCamino(algoritmo.getCamino());
    }

    public void profundidad(String tipo) {
        BusquedadProfundidad algoritmo = new BusquedadProfundidad(nodoInicial);
        if (tipo == "Recursivo") {
            algoritmo.recursivo(nodoInicial, nodoFinal.getNombre());
        } else {
            algoritmo.iterativo(nodoInicial, nodoFinal.getNombre());

        }
        System.out.println("Camino asignado"+algoritmo.getCamino());
        Mapa.getJugador().setCamino(algoritmo.getCamino());

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

    private void aEstrella(HeuristicaEnum tipo) {
        AEstrella algoritmo = new AEstrella();
        algoritmo.busquedadAEstrella(nodoInicial, nodoFinal, tipo);
        Mapa.getJugador().setCamino(algoritmo.getCamino(nodoFinal));
        
    }

}
