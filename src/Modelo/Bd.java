/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FlorBarrera
 */
public class Bd {
    
    public static Connection  Bd() {        
        try {
            Connection conexion ;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Hospital";
            conexion = DriverManager.getConnection(url,"postgres","admin");
            System.out.println("Conexion a la BD exitosa");
                    return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en conexion con la BD");
            return null; 
        }
    }
    
}
