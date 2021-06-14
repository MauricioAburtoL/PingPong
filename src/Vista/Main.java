package Vista;

import java.awt.*;
import Controlador.*;
import static java.util.logging.Level.SEVERE;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.UIManager.getInstalledLookAndFeels;

public class Main {

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vista v = new Vista();
                Controlador c = new Controlador(v);
                v.setLocationRelativeTo(v);
                v.setSize(600, 550);
                v.setTitle("ProyecPong");
                v.setLocationRelativeTo(null);
                v.setMinimumSize(new Dimension(100, 100));
                v.setVisible(true);
                v.setDefaultCloseOperation(EXIT_ON_CLOSE);
                v.add(v.Panel);
            }
        });
    }
}
