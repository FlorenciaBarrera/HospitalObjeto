/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bd;
import Modelo.Cama;
import Modelo.Habitacion;
import Modelo.Internacion;
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
import java.sql.Date;
/**
 *
 *@author FlorBarrera
 */
public class ControladorInternacion {
    Ubicacion ubicacion;
    Habitacion habitacion;
    Cama camas;
    Internacion internaciones;
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;

    public ControladorInternacion() {
        System.out.println("Inicializamos controlador");
        ubicacion = new Ubicacion();
        habitacion = new Habitacion();
        camas = new Cama();
        internaciones = new Internacion();
        conexion = Bd.Bd();
        modelo= new DefaultTableModel();
    }

public void llenarTablaInternacion (JTable tabla) throws SQLException{
        DefaultTableModel modelo2 = new DefaultTableModel();
        
        modelo2.addColumn("hospital");
        modelo2.addColumn("nombreSala");
        modelo2.addColumn("numeroHabitacion");
        modelo2.addColumn("numeroCama");
        modelo2.addColumn("estado");
        modelo2.addColumn("idInternacion");
        modelo2.addColumn("paciente");
        modelo2.addColumn("fecha");
        modelo2.addColumn("diagnostico");
       
        tabla.setModel(modelo2);
        
        String consulta = "SELECT \"Ubicacion\".\"hospital\", \"Ubicacion\".\"nombreSala\", \"Habitacion\".\"numero\",\"Cama\".\"numero\",\"Cama\".\"estado\",\"Internacion\".\"idInternacion\", \"Internacion\".\"paciente\",\"Internacion\".\"fecha\", \"Internacion\".\"diagnostico\"\n" +
"  FROM \"Ubicacion\", \"Habitacion\", \"Cama\" ,\"Internacion\"\n" +
"  WHERE \"Ubicacion\".\"idUbicacion\" = \"Habitacion\".\"idUbicacion\"\n" +
"  AND \"Habitacion\".\"idHabitacion\" = \"Cama\".\"idHabitacion\"\n" +
"  AND \"Cama\".\"idCama\" = \"Internacion\".\"idCama\"; ";
        pst = conexion.prepareStatement(consulta);
        
        
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            fila[0] = rs.getString(1); 
            fila[1] = rs.getString(2);
            fila[2] = rs.getInt(3);
            fila[3] = rs.getInt(4);
            fila[4] = rs.getString(5);
            fila[5] = rs.getInt(6);
            fila[6] = rs.getString(7);
            fila[7] = rs.getString(8);
            fila[8] = rs.getString(9);
                        
            modelo2.addRow(fila);
        }
    }    
    
public ArrayList<Cama> llenarComboCama(){

    
    try {
        String consulta = "SELECT \"Ubicacion\".\"idUbicacion\", \"Ubicacion\".\"hospital\",\"Ubicacion\".\"nombreSala\",\"Habitacion\".\"idHabitacion\", \"Habitacion\".\"numero\",\"Habitacion\".\"idUbicacion\",\"Cama\".\"idCama\", \"Cama\".\"numero\" as \"num_cama\", \"Cama\".\"estado\",\"Cama\".\"idHabitacion\"\n" +
"  FROM \"Cama\"\n" +
"  LEFT JOIN \"Habitacion\" ON   \"Habitacion\".\"idHabitacion\" = \"Cama\".\"idHabitacion\"  \n" +
"  LEFT JOIN \"Ubicacion\" ON   \"Ubicacion\".\"idUbicacion\" = \"Habitacion\".\"idUbicacion\"  \n" +
"  WHERE  \"Cama\".\"estado\" = 'Disponible' ;";
   pst = conexion.prepareStatement(consulta);
   rs = pst.executeQuery();
   rsm = rs.getMetaData();
   
   ArrayList<Cama> camaBD = new ArrayList<Cama>();
   
        while (rs.next()) { 
            Cama c = new Cama();
            Habitacion h = new Habitacion();
            Ubicacion u = new Ubicacion();
            
            u.setIdUbicacion(rs.getInt("idUbicacion"));
            u.setHospital(rs.getString("hospital"));
            u.setNombreSala(rs.getString("nombreSala"));
            
                        
            h.setIdHabitacion(rs.getInt("idHabitacion"));
            h.setNumero(rs.getInt("numero"));
            h.setUbicacion(u);
            
            c.setIdCama(rs.getInt("idCama"));
            //c.setNumero(rs.getInt("numero"));
            c.setNumero(rs.getInt("num_cama"));
            c.setEstado(rs.getString("estado"));
            c.setHabitacion(h);
            
            camaBD.add(c);
        }
    
        return camaBD;
        
        
    } catch (SQLException e) {
        System.out.println("Imposible llenar combo");
        return null;
    }

}
public void eliminarInternacion(Internacion internacion,JTable tabla){  
            try {    
                int idCama=0;
                String consulta2 = "SELECT \"Internacion\".\"idCama\"\n" +
                "  FROM \"Internacion\"\n" +
                "  WHERE  \"Internacion\".\"idInternacion\" = ? ;";
                   pst = conexion.prepareStatement(consulta2);
                   pst.setInt(1, internacion.getIdInternacion());
                   rs = pst.executeQuery();
                   rsm = rs.getMetaData();
                   while (rs.next()) { 
                     idCama=rs.getInt(1); 
                   }
                   
                String consulta1 = "UPDATE \"Cama\"\n" +
"   SET \"estado\" = 'Disponible'\n" +
" WHERE \"idCama\"= ?;";
                pst = conexion.prepareStatement(consulta1);
                pst.setInt(1, idCama);                   
                pst.execute();
                //JOptionPane.showMessageDialog(null, "Cama liberada:"+idCama);
                
                
                
                String consulta = "DELETE FROM \"Internacion\"\n" +
" WHERE \"Internacion\".\"idInternacion\" = ?;";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, internacion.getIdInternacion());                   
                pst.execute();
                
                
                JOptionPane.showMessageDialog(null, "Exito al borrar");
                
                
                llenarTablaInternacion(tabla);
            }catch(SQLException e){
            //System.out.println(e);
            }            
   }    

//public void insertarInternacion(Internacion internacion, Integer cama,JTable tabla){
//        
//        
//        try {
//       
//        String cadena = "INSERT INTO public.\"Internacion\"(paciente, fecha, diagnostico, \"idCama\")\n" +
//"	VALUES (?,?,?,?);"; 
//        
//         pst = conexion.prepareStatement(cadena);
//         
//         
//        pst.setString(1, internacion.getPaciente());
//        pst.setDate(2, java.sql.Date.valueOf(internacion.getFecha()));
//        pst.setString(3, internacion.getDiagnostico());
//        //pst.setObject(4, cama.getIdCama());
//        //pst.setObject(4, cama);
//        pst.setObject(4, internacion.getIdCama());
//        JOptionPane.showMessageDialog(null, "Se:"+pst);
//
//        //pst.execute();
//            
//            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
//            
//            //llenarTablaInternacion(tabla);
//        
//        
//        } catch (SQLException | HeadlessException e) {
//            
//            System.out.println("Error. No se pudo registrar"+e);
//        }
//       
//      
//    } 

public void insertarInternacion(Internacion internacion, Cama cama,JTable tabla){
        
        
        try {
            int cantidad_de_regsitros = 0;
             String consulta = "SELECT \"Internacion\".\"paciente\"\n" +
                "  FROM \"Internacion\"\n" +
                "  WHERE  \"Internacion\".\"paciente\" = ? ;";
                   pst = conexion.prepareStatement(consulta);
                   pst.setString(1, internacion.getPaciente());
                   rs = pst.executeQuery();
                   rsm = rs.getMetaData();
                   while (rs.next()) { 
                     cantidad_de_regsitros++;
                   }
                   if (cantidad_de_regsitros>0) { 
                        JOptionPane.showMessageDialog(null, "paciente repetido");
                    }else{
                       
                              String cadena = "INSERT INTO public.\"Internacion\"(paciente, fecha, diagnostico, \"idCama\")\n" +
                                "	VALUES (?,?,?,?);"; 
                                        pst = conexion.prepareStatement(cadena);
                                        pst.setString(1, internacion.getPaciente());
                                        pst.setDate(2, java.sql.Date.valueOf(internacion.getFecha()));
                                        pst.setString(3, internacion.getDiagnostico());
                                        pst.setObject(4, cama.getIdCama());
                                        pst.execute();
                                        JOptionPane.showMessageDialog(null, "Se inserto correctamente");

                                         String cadena1 = "UPDATE public.\"Cama\"\n" +
                                        "   SET \"estado\" = 'No Disponible'  \n" +
                                        " WHERE \"idCama\"= ? ;"; 
                                        pst = conexion.prepareStatement(cadena1);
                                        pst.setInt(1, cama.getIdCama());
                                        pst.execute();
                                        
                                        llenarTablaInternacion(tabla);
                                        
                   }
       
 
        
        
        } catch (SQLException | HeadlessException e) {
            
            //System.out.println("Error. No se pudo registrar"+e);
        }
       
      
    } 



}
