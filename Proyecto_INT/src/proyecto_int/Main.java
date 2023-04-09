package bomberman;

import Constantes.ConstantesGlobales;
import Mapas.Mapa;
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
            JOptionPane.showMessageDialog(null, "Mapa cargado correctamente");
            escenario.setTitle(ConstantesGlobales.NOMBRE + ConstantesGlobales.VERSION);
            Mapa.configurarMapa(mapa);

            Scene s = Mapa.getMapa();
            escenario.setScene(s);
            escenario.show();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se logro cargar el mapa");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
