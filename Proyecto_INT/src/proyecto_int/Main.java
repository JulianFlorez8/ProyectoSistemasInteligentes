package proyecto_int;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private JPanel panel1;
    private JButton cargarArchivoButton;


    public Main() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cargarArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    System.out.println(filePath);

                    try {
                        // imprimir linea por linea
                        //Files.lines(Paths.get(filePath)).forEach(System.out::println);

                        //imprimir caracter por caracter
                        Files.lines(Paths.get(filePath)).forEach(line -> {
                            char[] characters = line.toCharArray();
                            for (char c : characters) {
                                System.out.println(c);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Main app = new Main();
        JFrame frame = new JFrame("App");
        frame.setSize(500, 500); // Define el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(app.panel1);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
