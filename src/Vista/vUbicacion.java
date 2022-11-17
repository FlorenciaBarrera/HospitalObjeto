/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.Ubicacion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author FlorBarrera
 */
public class vUbicacion extends javax.swing.JInternalFrame {

    Controlador controlador;
    ArrayList<Ubicacion> ubicaciones;
    
    public vUbicacion() throws SQLException {
        
        initComponents();
        controlador = new Controlador();
        ubicaciones = new ArrayList<Ubicacion>();
        controlador.llenarTablaUbicacion(tablaUbicacion);
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUbicacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtHospital = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        tablaUbicacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaUbicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUbicacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUbicacion);

        jLabel1.setText("Hospital:");

        txtHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHospitalActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Sala:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(txtHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
if(txtHospital.getText().length() <=3 && txtNombre.getText().length() <=3)
    {
        JOptionPane.showMessageDialog(null, "El campo Hospital y Nombre de sala tienen que ser mayor a 3 caracteres");
    }else{
        Ubicacion ubicacion = new Ubicacion();
        
        ubicacion.setHospital(txtHospital.getText());
        ubicacion.setNombreSala(txtNombre.getText());
        
        
                
        controlador.insertarUbicacion(ubicacion,tablaUbicacion);
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaUbicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUbicacionMouseClicked
       int row = tablaUbicacion.getSelectedRow();
        String hospital = tablaUbicacion.getValueAt(row, 1).toString();
        String nombre = tablaUbicacion.getValueAt(row, 2).toString();
        
        txtHospital.setText(hospital);
        txtNombre.setText(nombre);
    }//GEN-LAST:event_tablaUbicacionMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Ubicacion ubicacion = new Ubicacion();
        int row = tablaUbicacion.getSelectedRow();
        String id = tablaUbicacion.getValueAt(row, 0).toString();
        ubicacion.setIdUbicacion(Integer.parseInt(id));
        
        controlador.eliminarUbicacion(ubicacion, tablaUbicacion);
        
        limpiarCampos();
        //btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHospitalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHospitalActionPerformed

public void limpiarCampos(){

    txtHospital.setText("");
    txtNombre.setText("");

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUbicacion;
    private javax.swing.JTextField txtHospital;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
