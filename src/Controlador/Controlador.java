package Controlador;

import Vista.Dificultad;
import Vista.*;
import Modelo.*;
import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Vista vista = new Vista();
    Jugador jd = new Jugador();
    InfoJugador ij = new InfoJugador();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(Vista v) {
        this.vista = v;
        this.vista.historial.addActionListener(this);
        this.vista.registrar.addActionListener(this);
        this.vista.editar.addActionListener(this);
        this.vista.guardar.addActionListener(this);
        this.vista.eliminar.addActionListener(this);
        this.vista.Jugar.addActionListener(this);
        Listar(vista.tabla);
    }

    public Controlador() {

    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.historial) {
            Limpiar();
            Listar(vista.tabla);
        }
        if (ae.getSource() == vista.registrar) {
            if (vista.nom.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Escriba un nombre");
            } else {
                Agregar();
                Limpiar();
                Listar(vista.tabla);
            }
        }
        if (ae.getSource() == vista.editar) {
            int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione una fila");
            } else {
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nom = (String) vista.tabla.getValueAt(fila, 1);
                vista.id.setText("" + id);
                vista.nom.setText(nom);
                vista.guardar.setVisible(true);
            }
        }
        if (ae.getSource() == vista.guardar) {
            Limpiar();
            Actualizar();
            Listar(vista.tabla);
            vista.guardar.setVisible(false);
            vista.id.setText(null);
            vista.nom.setText(null);
        }
        if (ae.getSource() == vista.eliminar) {
            Eliminar();
        }
        if (ae.getSource() == vista.Jugar) {

            int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione a los jugadores");
            } else {
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nomb = (String) vista.tabla.getValueAt(fila, 1);

                if (vista.id.getText().isEmpty()) {
                    vista.id.setText("" + id);
                    ij.setId(id);
                    vista.nom.setText(nomb);

                } else {
                    vista.id2.setText("" + id);
                    ij.setId(id);
                    vista.nom.setText(nomb);
                }

            }

            Buscar();

        }
    }

    public void Listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<InfoJugador> lista = jd.Listar();
        Object[] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getTriunfos();
            object[3] = lista.get(i).getRondas();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }

    public void Agregar() {
        String nombre = vista.nom.getText();
        ij.setNombre(nombre);
        int r = jd.Agregar(ij);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Jugador agregado correctamente");
            vista.nom.setText(null);
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }

    public void Actualizar() {
        int id = Integer.parseInt(vista.id.getText());
        String nombre = vista.nom.getText();
        ij.setId(id);
        ij.setNombre(nombre);
        int r = jd.Actualizar(ij);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Datos actualizados");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }

    void Limpiar() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void Eliminar() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un usuario en la tabla");
        } else {
            int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
            jd.Eliminar(id);
            JOptionPane.showMessageDialog(vista, "Jugador eliminado");
            Limpiar();
            Listar(vista.tabla);
        }
    }

    public void Buscar() {
        if (vista.id.getText().isEmpty() || vista.id2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione ambos jugadores");
        } else {
            JOptionPane.showMessageDialog(vista, "Jugador 1 utilice las tecas W y S\n" + "Jugador 2 utilice las tecas arriba y abajo");
            vista.setVisible(false);
            Dificultad d = new Dificultad();
        }
    }
}
