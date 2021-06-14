package Vista;

import java.awt.*;
import javax.swing.*;
import Controlador.*;
import Juego.*;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FinJuego extends JFrame {

    Pelota p = new Pelota();
    public JPanel Panel;
    public JLabel fecha, titulo;
    public JButton Facil, Normal, Salir, jugar, regresar;
    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

    public FinJuego() {
        setSize(250, 300);
        setTitle("ProyecPong");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(100, 100));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(new Color(153, 204, 255));
        add(Panel);

        fecha = new JLabel(timeStamp);
        fecha.setForeground(Color.darkGray);
        fecha.setHorizontalAlignment(SwingConstants.CENTER);
        fecha.setFont(new Font("Century Gothic", Font.PLAIN, 10));
        fecha.setBounds(25, 5, 190, 25);

        titulo = new JLabel("PinPong");
        titulo.setBounds(25, 5, 190, 100);
        titulo.setForeground(Color.darkGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        jugar = new JButton("Jugar de nuevo");
        jugar.setBounds(45, 95, 150, 30);
        jugar.setForeground(Color.darkGray);
        jugar.setHorizontalAlignment(SwingConstants.CENTER);
        jugar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ActionListener j = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FinJuego fj = new FinJuego();
                fj.disable();
                Mesa m = new Mesa();
                m.setVisible(false);
                Dificultad d = new Dificultad();
                Pelota.finJuego = false;
            }
        };
        jugar.addActionListener(j);

        regresar = new JButton("Regresar");
        regresar.setBounds(45, 135, 150, 30);
        regresar.setForeground(Color.darkGray);
        regresar.setHorizontalAlignment(SwingConstants.CENTER);
        regresar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ActionListener r = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FinJuego fj = new FinJuego();
                fj.disable();
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
        };
        regresar.addActionListener(r);

        Salir = new JButton("Salir");
        Salir.setBounds(75, 176, 90, 25);
        Salir.setForeground(Color.darkGray);
        Salir.setHorizontalAlignment(SwingConstants.CENTER);
        Salir.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ActionListener s = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        };
        Salir.addActionListener(s);

        Panel.add(jugar);
        Panel.add(regresar);
        Panel.add(fecha);
        Panel.add(titulo);
        Panel.add(Salir);
    }

}
