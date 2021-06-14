package Vista;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class Vista extends JFrame {

    public JPanel Panel;
    public JTable tabla;
    public JScrollPane scroll;
    public JTextField nom, id, id2;
    public JLabel titulo, fecha, nombre, ID, ID2;
    public JButton Jugar, editar, registrar, historial, eliminar, guardar, salir;

    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    DefaultTableModel model = new DefaultTableModel();

    public Vista() {
        Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(new Color(153, 204, 255));

        Componentes();
        //Se agregan todos los elementos en el panel
        Panel.add(fecha);
        Panel.add(titulo);
        Panel.add(nombre);
        Panel.add(nom);
        Panel.add(ID);
        Panel.add(id);
        Panel.add(ID2);
        Panel.add(id2);
        Panel.add(Jugar);
        Panel.add(editar);
        Panel.add(registrar);
        Panel.add(historial);
        Panel.add(eliminar);
        Panel.add(guardar);
        Panel.add(salir);
        Panel.add(scroll);
    }

    public void Componentes() {
        Botones();
        texto();
        datos();
        tabla();
    }

    public void texto() {
        fecha = new JLabel(timeStamp);
        fecha.setBounds(200, 5, 190, 25);
        fecha.setForeground(Color.darkGray);
        fecha.setHorizontalAlignment(SwingConstants.CENTER);
        fecha.setFont(new Font("Century Gothic", Font.PLAIN, 10));

        titulo = new JLabel("BIENVENIDO");
        titulo.setBounds(200, 5, 190, 100);
        titulo.setForeground(Color.darkGray);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Century Gothic", Font.PLAIN, 30));

        nombre = new JLabel("Nombre");
        nombre.setBounds(100, 155, 190, 25);
        nombre.setForeground(Color.darkGray);
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        ID = new JLabel("ID Jugador 1: ");
        ID.setBounds(100, 90, 145, 30);
        ID.setForeground(Color.darkGray);
        ID.setHorizontalAlignment(SwingConstants.CENTER);
        ID.setFont(new Font("Century Gothic", Font.PLAIN, 20));

        ID2 = new JLabel("ID Jugador 2: ");
        ID2.setBounds(100, 118, 145, 30);
        ID2.setForeground(Color.darkGray);
        ID2.setHorizontalAlignment(SwingConstants.CENTER);
        ID2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
    }

    public void datos() {
        nom = new JTextField();
        nom.setBackground(Color.WHITE);
        nom.setBounds(250, 155, 190, 25);
        nom.setForeground(Color.DARK_GRAY);
        nom.setHorizontalAlignment(SwingConstants.CENTER);
        nom.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        id = new JTextField();
        id.setEditable(false);
        id.setBackground(Color.WHITE);
        id.setBounds(250, 95, 100, 25);
        id.setForeground(Color.DARK_GRAY);
        id.setHorizontalAlignment(SwingConstants.CENTER);
        id.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        id2 = new JTextField();
        id2.setEditable(false);
        id2.setBackground(Color.WHITE);
        id2.setBounds(250, 120, 100, 25);
        id2.setForeground(Color.DARK_GRAY);
        id2.setHorizontalAlignment(SwingConstants.CENTER);
        id2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
    }

    public void Botones() {
        Jugar = new JButton("Jugar");
        Jugar.setBounds(360, 108, 80, 25);
        Jugar.setForeground(Color.darkGray);
        Jugar.setHorizontalAlignment(SwingConstants.CENTER);
        Jugar.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        editar = new JButton("Editar datos");
        editar.setBounds(70, 420, 130, 25);
        editar.setForeground(Color.darkGray);
        editar.setHorizontalAlignment(SwingConstants.CENTER);
        editar.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        registrar = new JButton("Registrar");
        registrar.setBounds(230, 420, 130, 25);
        registrar.setForeground(Color.darkGray);
        registrar.setHorizontalAlignment(SwingConstants.CENTER);
        registrar.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        historial = new JButton("Ver historial");
        historial.setBounds(390, 420, 130, 25);
        historial.setForeground(Color.darkGray);
        historial.setHorizontalAlignment(SwingConstants.CENTER);
        historial.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        guardar = new JButton("Guardar datos");
        guardar.setVisible(false);
        guardar.setBounds(70, 470, 130, 25);
        guardar.setForeground(Color.darkGray);
        guardar.setHorizontalAlignment(SwingConstants.CENTER);
        guardar.setFont(new Font("Century Gothic", Font.PLAIN, 14));

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(230, 470, 130, 25);
        eliminar.setForeground(Color.darkGray);
        eliminar.setHorizontalAlignment(SwingConstants.CENTER);
        eliminar.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        salir = new JButton("Salir");
        salir.setBounds(390, 470, 130, 25);
        salir.setForeground(Color.darkGray);
        salir.setHorizontalAlignment(SwingConstants.CENTER);
        salir.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ActionListener s = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        };
        salir.addActionListener(s);
    }

    public void tabla() {
        String[] titulo = new String[]{"ID", "NOMBRE", "TRIUNFOS", "RONDAS"};
        model.setColumnIdentifiers(titulo);

        tabla = new JTable(model);
        tabla.setBounds(70, 200, 450, 190);
        tabla.setFont(new Font("Century Gothic", Font.PLAIN, 12));

        scroll = new JScrollPane(tabla);
        scroll.setBounds(70, 200, 450, 190);
    }

}
