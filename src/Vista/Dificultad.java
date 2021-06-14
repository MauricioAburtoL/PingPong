package Vista;

import Juego.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Dificultad extends JFrame {

    public JPanel Panel;
    public JLabel fecha, titulo;
    public JButton Facil, Normal, Dificil;
    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

    public Dificultad() {
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
        fecha.setBounds(25, 5, 190, 25);
        fecha.setForeground(Color.darkGray);
        fecha.setHorizontalAlignment(SwingConstants.CENTER);
        fecha.setFont(new Font("Century Gothic", Font.PLAIN, 10));

        titulo = new JLabel("Nivel de Dificultad");
        titulo.setBounds(25, 5, 190, 100);
        titulo.setForeground(Color.darkGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        Facil = new JButton("Facil");
        Facil.setBounds(80, 105, 80, 25);
        Facil.setForeground(Color.darkGray);
        Facil.setHorizontalAlignment(SwingConstants.CENTER);
        Facil.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ActionListener b = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Repintado.velocidad = 20;
                //Controla la velocidad
                Ventana ventana = new Ventana();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        Facil.addActionListener(b);

        Normal = new JButton("Normal");
        Normal.setBounds(60, 140, 120, 25);
        Normal.setForeground(Color.darkGray);
        Normal.setHorizontalAlignment(SwingConstants.CENTER);
        Normal.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                //Controla la velocidad
                Repintado.velocidad = 10;
                Ventana ventana = new Ventana();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        Normal.addActionListener(a);

        Dificil = new JButton("Dificil");
        Dificil.setBounds(75, 176, 90, 25);
        Dificil.setForeground(Color.darkGray);
        Dificil.setHorizontalAlignment(SwingConstants.CENTER);
        Dificil.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ActionListener j = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                //Controla la velocidad
                Repintado.velocidad = 5;
                Ventana ventana = new Ventana();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        Dificil.addActionListener(j);

        Panel.add(fecha);
        Panel.add(titulo);
        Panel.add(Facil);
        Panel.add(Normal);
        Panel.add(Dificil);

    }
}
