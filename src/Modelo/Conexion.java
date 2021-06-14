package Modelo;

import java.sql.*;

public class Conexion {
    
    //Variables necesarias para la conexión
    Connection con = null;

    //Método donde se realiza la conexión
    public Connection getConnection() {
        String URL = "jdbc:mysql://127.0.0.1:3306/proyecpong" + "?useTimeZone=true&serverTimezone=UTC";
        String USERNAME = "root";
        String PASSWORD = "CarolCPB1379";
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexión Exitosa");
            
        } catch (Exception e) {
            System.out.print(e);
        }
        
        return con;
        
    }
}

