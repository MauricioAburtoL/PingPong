package Modelo;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Jugador {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List Listar() {
        List<InfoJugador> datos = new ArrayList<>();
        String sql = "SELECT *FROM JUGADOR";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                InfoJugador ij = new InfoJugador();
                ij.setId(rs.getInt(1));
                ij.setNombre(rs.getString(2));
                ij.setTriunfos(rs.getInt(3));
                ij.setRondas(rs.getInt(4));
                datos.add(ij);
            }
        } catch (Exception e) {

        }
        return datos;
    }

    public int Agregar(InfoJugador ij) {
        String sql = "INSERT INTO jugador (id,nombre,triunfos,rondas) values (?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ij.getId());
            ps.setString(2, ij.getNombre());
            ps.setInt(3, ij.triunfos);
            ps.setInt(4, ij.rondas);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return 1;
    }

    public int Actualizar(InfoJugador ij) {
        int r = 0;
        String sql = "UPDATE jugador SET nombre=?, triunfos=?, rondas=? WHERE id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ij.getNombre());
            ps.setInt(2, ij.getTriunfos());
            ps.setInt(3, ij.getRondas());
            ps.setInt(4, ij.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {

        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "DELETE FROM jugador WHERE id = " + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int Buscar(InfoJugador ij) {
        int r = 0;
        String sql = "SELECT *FROM jugador SET nombre=? WHERE id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ij.getNombre());
            ps.setInt(2, ij.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {

        }
        return r;

    }
}
