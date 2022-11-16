/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bd;
import Modelo.Cama;
import Modelo.Habitacion;
import Modelo.Ubicacion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FlorBarrera
 */
public class Controlador {
    Ubicacion ubicacion;
    Habitacion habitacion;
    Cama cama;
    
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;

    public Controlador() {
        System.out.println("Inicializamos controlador");
        ubicacion = new Ubicacion();
        habitacion = new Habitacion();
        cama = new Cama();
        conexion = Bd.Bd();
        modelo= new DefaultTableModel();
        
    }
    
public void llenarTablaUbicacion (JTable tabla) throws SQLException{
        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("idUbicacion");
        modelo2.addColumn("hospital");
        modelo2.addColumn("nombreSala");
        
        
       
        tabla.setModel(modelo2);
        
        String consulta = "SELECT \"idUbicacion\", hospital, \"nombreSala\"\n" +
"  FROM public.\"Ubicacion\";";
        pst = conexion.prepareStatement(consulta);
        
        
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            fila[0] = rs.getInt(1); //id
            fila[1] = rs.getString(2);
            fila[2] = rs.getString(3);
                        
            modelo2.addRow(fila);
        }
    }
    
public void insertarUbicacion (Ubicacion ubicacion, JTable tabla){
        
        
        try {
       
        String cadena = "INSERT INTO public.\"Ubicacion\"(\n" +
"            hospital, \"nombreSala\")\n" +
"    VALUES (?, ?);"; 
        
         pst = conexion.prepareStatement(cadena);
        
        pst.setString(1, ubicacion.getHospital());
        pst.setString(2, ubicacion.getNombreSala());
        

        pst.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
            llenarTablaUbicacion(tabla);
        
        
        } catch (SQLException | HeadlessException e) {
            
            System.out.println("Error. No se pudo registrar");
        }
       
      
    }  

public void eliminarUbicacion(Modelo.Ubicacion ubicacion,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM public.\"Ubicacion\"\n" +
" WHERE \"idUbicacion\" = ?;";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, ubicacion.getIdUbicacion());                   
                pst.execute();
                
                llenarTablaUbicacion(tabla);
                JOptionPane.showMessageDialog(null, "ex");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

public void modificarUbicacion (Ubicacion ubicacion, JTable tabla){
        
        
        try {
       
        String cadena = "UPDATE public.\"Ubicacion\"\n" +
"   SET \"hospital\" = 'puto' , \"nombreSala\" = '9999' \n" +
" WHERE \"idUbicacion\"= 8;"; 
        
 //       pst = conexion.prepareStatement(cadena);
        
 //       pst.setString(1, ubicacion.getHospital());
 //       pst.setString(2, ubicacion.getNombreSala());
        

 //       pst.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
            llenarTablaUbicacion(tabla);
        
        
        } catch (SQLException | HeadlessException e) {
            
            System.out.println("Error. No se pudo registrar");
        }
       
      
    }  

public void llenarTablaHabitacion (JTable tabla) throws SQLException{
        DefaultTableModel modelo2 = new DefaultTableModel();
        
        modelo2.addColumn("hospital");
        modelo2.addColumn("nombreSala");
        modelo2.addColumn("idHabitacion");
        modelo2.addColumn("numero");
        modelo2.addColumn("idUbicacion");
        
        
       
        tabla.setModel(modelo2);
        
        String consulta = "SELECT \"Ubicacion\".\"hospital\",\"Ubicacion\".\"nombreSala\",\"Habitacion\".*\n" +
"  FROM \"Ubicacion\", \"Habitacion\"\n" +
"  WHERE \"Ubicacion\".\"idUbicacion\" = \"Habitacion\".\"idUbicacion\";";
        pst = conexion.prepareStatement(consulta);
        
        
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            fila[0] = rs.getString(1); 
            fila[1] = rs.getString(2);
            fila[2] = rs.getInt(3);
            fila[3] = rs.getInt(4);
            fila[4] = rs.getInt(5);
                        
            modelo2.addRow(fila);
        }
    }

public void insertarHabitacion(Habitacion habitacion,Ubicacion ubicacion, JTable tabla){
        
        
        try {
            
            int cantidad_de_regsitros = 0;
             String consulta = "SELECT \"Habitacion\".\"numero\"\n" +
                "  FROM \"Habitacion\"\n" +
                "  WHERE  \"Habitacion\".\"numero\" = ?\n"+
                "  AND  \"Habitacion\".\"idUbicacion\" = ? ;";
                   pst = conexion.prepareStatement(consulta);
                   pst.setInt(1, habitacion.getNumero());
                   pst.setObject(2, ubicacion.getIdUbicacion());
                   rs = pst.executeQuery();
                   rsm = rs.getMetaData();
                   while (rs.next()) { 
                     cantidad_de_regsitros++;
                   }
       if(cantidad_de_regsitros>0){
            JOptionPane.showMessageDialog(null, "No puede repetirse la habitacion en una misma ubicacion");
       }else{
        String cadena = "INSERT INTO public.\"Habitacion\"(\n" +
                        "            numero, \"idUbicacion\")\n" +
                        "    VALUES (?, ?);"; 
        
        pst = conexion.prepareStatement(cadena);
        pst.setInt(1, habitacion.getNumero());
        pst.setObject(2, ubicacion.getIdUbicacion());
        pst.execute(); 
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
        llenarTablaHabitacion(tabla);
        }
        
        } catch (SQLException | HeadlessException e) {
            
            System.out.println("Error. No se pudo registrar");
        }
       
      
    } 

public void eliminarHabitacion(Habitacion habitacion,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM public.\"Habitacion\"\n" +
" WHERE \"idHabitacion\" = ?;";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, habitacion.getIdHabitacion());                   
                pst.execute();
                
                llenarTablaHabitacion(tabla);
                JOptionPane.showMessageDialog(null, "Exito al borrar");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

public ArrayList<Ubicacion> llenarComboUbicacion(){

    
    try {
        String consulta = "SELECT \"idUbicacion\", hospital, \"nombreSala\"\n" +
"  FROM public.\"Ubicacion\";";
   pst = conexion.prepareStatement(consulta);
   rs = pst.executeQuery();
   rsm = rs.getMetaData();
   ArrayList<Ubicacion> ubicacionBD = new ArrayList<Ubicacion>();
   
        while (rs.next()) {            
            Ubicacion u = new Ubicacion();
            u.setIdUbicacion(rs.getInt("idUbicacion"));
            u.setHospital(rs.getString("hospital"));
            u.setNombreSala(rs.getString("nombreSala"));
            
            ubicacionBD.add(u);
        }
    
        return ubicacionBD;
        
        
    } catch (SQLException e) {
        System.out.println("Imposible llenar combo");
        return null;
    }

}

public void llenarTablaCama (JTable tabla) throws SQLException{
        DefaultTableModel modelo2 = new DefaultTableModel();
        
        modelo2.addColumn("hospital");
        modelo2.addColumn("nombreSala");
        modelo2.addColumn("numeroHabitacion");
        modelo2.addColumn("idCama");
        modelo2.addColumn("numeroCama");
        modelo2.addColumn("estado");
        

        
       
        tabla.setModel(modelo2);
        
//        String consulta = "SELECT \"Ubicacion\".\"hospital\",\"Ubicacion\".\"nombreSala\", \"Habitacion\".\"numero\",\"Cama\".\"idCama\", \"Cama\".\"numero\",\"Cama\".\"estado\"\n" +
//"FROM \"Ubicacion\", \"Habitacion\", \"Cama\"\n" +
//"WHERE \"Ubicacion\".\"idUbicacion\" = \"Habitacion\".\"idUbicacion\"\n" +
//"AND \"Habitacion\".\"idHabitacion\" = \"Cama\".\"idHabitacion\";";
        
        
 String consulta = "SELECT \"Ubicacion\".\"hospital\",\"Ubicacion\".\"nombreSala\", \"Habitacion\".\"numero\",\"Cama\".\"idCama\", \"Cama\".\"numero\",\"Cama\".\"estado\"\n" +
"FROM \"Cama\"\n" +
"LEFT JOIN  \"Habitacion\" ON  \"Habitacion\".\"idHabitacion\" = \"Cama\".\"idHabitacion\"\n" +
"LEFT JOIN \"Ubicacion\" ON   \"Ubicacion\".\"idUbicacion\" = \"Habitacion\".\"idUbicacion\";" ;
        pst = conexion.prepareStatement(consulta);
        
        
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            fila[0] = rs.getString(1); 
            fila[1] = rs.getString(2);
            fila[2] = rs.getInt(3);
            fila[3] = rs.getInt(4);
            fila[4] = rs.getInt(5);
            fila[5] = rs.getString(6); 
            modelo2.addRow(fila);
        }
    }    

public ArrayList<Habitacion> llenarComboHabitacion(){

    
    try {
        String consulta = "SELECT \"Ubicacion\".\"idUbicacion\", \"Ubicacion\".\"hospital\",\"Ubicacion\".\"nombreSala\",\"Habitacion\".\"idHabitacion\",\"Habitacion\".\"numero\",\"Habitacion\".\"idUbicacion\"\n" +
"FROM \"Ubicacion\", \"Habitacion\" \n" +
" WHERE \"Ubicacion\".\"idUbicacion\" = \"Habitacion\".\"idUbicacion\";";
   pst = conexion.prepareStatement(consulta);
   rs = pst.executeQuery();
   rsm = rs.getMetaData();
   ArrayList<Habitacion> habitacionBD = new ArrayList<Habitacion>();
   
        while (rs.next()) {            
            Habitacion h = new Habitacion();
            Ubicacion u = new Ubicacion();
            
            u.setIdUbicacion(rs.getInt("idUbicacion"));
            u.setHospital(rs.getString("hospital"));
            u.setNombreSala(rs.getString("nombreSala"));
            h.setIdHabitacion(rs.getInt("idHabitacion"));
            h.setNumero(rs.getInt("numero"));
            h.setUbicacion(u);
            
            habitacionBD.add(h);
        }
    
        return habitacionBD;
        
        
    } catch (SQLException e) {
        System.out.println("Imposible llenar combo");
        return null;
    }

}

public void insertarCama(Cama cama, Habitacion habitacion,JTable tabla){
        
        
        try {
            int cantidad_de_regsitros = 0;
             String consulta = "SELECT \"Cama\".\"numero\"\n" +
                "  FROM \"Cama\"\n" +
                "  WHERE  \"Cama\".\"numero\" = ?\n"+
                "  AND  \"Cama\".\"idHabitacion\" = ? ;";
                   pst = conexion.prepareStatement(consulta);
                   pst.setInt(1, cama.getNumero());
                   pst.setObject(2, habitacion.getIdHabitacion());
                   rs = pst.executeQuery();
                   rsm = rs.getMetaData();
                   while (rs.next()) { 
                     cantidad_de_regsitros++;
                   }
       if(cantidad_de_regsitros>0){
            JOptionPane.showMessageDialog(null, "No puede repetirse el numero de cama en una misma habitacion");
       }else{
           String cadena = "INSERT INTO \"Cama\"(\n" +
"            numero, estado, \"idHabitacion\")\n" +
"    VALUES (?, ?, ?);"; 
        pst = conexion.prepareStatement(cadena);
        pst.setInt(1, cama.getNumero());
        pst.setString(2, cama.getEstado());
        pst.setObject(3, habitacion.getIdHabitacion());
        pst.execute(); 
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
        llenarTablaCama(tabla);
       }
       
       
       
       
        
        
        
        } catch (SQLException | HeadlessException e) {
            
            System.out.println("Error. No se pudo registrar");
        }
       
      
    } 

public void eliminarCama(Cama cama,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM \"Cama\"\n" +
" WHERE \"Cama\".\"idCama\" = ?;";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, cama.getIdCama());                   
                pst.execute();
                JOptionPane.showMessageDialog(null, "Exito al borrar");
                llenarTablaCama(tabla);
                
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

public void liberarCama(Cama cama,JTable tabla){  
            try {    
                
                String consulta = "UPDATE public.\"Cama\"\n" +
"   SET \"estado\" = 'Disponible'\n" +
" WHERE \"idCama\"= ?;";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, cama.getIdCama());                   
                pst.execute();
                
                llenarTablaCama(tabla);
                JOptionPane.showMessageDialog(null, "Cama liberada");
            }catch(SQLException e){
                System.out.println(e);
            }            
   }







}
