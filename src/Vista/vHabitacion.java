/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.Habitacion;
import Modelo.Ubicacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FlorBarrera
 */
public class vHabitacion extends javax.swing.JInternalFrame {

Controlador controlador;
ArrayList<Habitacion> habitaciones;
ArrayList<Ubicacion> ubicaciones;

    
    
    public vHabitacion() throws SQLException {
        initComponents();
        
        controlador = new Controlador();
        habitaciones = new ArrayList<Habitacion>();
        ubicaciones = new ArrayList<Ubicacion>();
        
        controlador.llenarTablaHabitacion(tablaHabitacion);
        
        ubicaciones = controlador.llenarComboUbicacion();
        for (int i = 0; i < ubicaciones.size(); i++) {
            cbUbicacion.addItem(ubicaciones.get(i).getHospital()+" "+ubicaciones.get(i).getNombreSala());
            
        }
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
        tablaHabitacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbUbicacion = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        tablaHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaHabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHabitacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaHabitacion);

        jLabel1.setText("Numero:");

        jLabel2.setText("Ubicación:");

        cbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Ubicación..." }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumero)
                            .addComponent(cbUbicacion, 0, 164, Short.MAX_VALUE))
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(btnEliminar))))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    
        Habitacion habitacion = new Habitacion();
        Ubicacion ubicacion = new Ubicacion();
        habitacion.setNumero(Integer.parseInt(txtNumero.getText()));
        int idUbicacion = ubicaciones.get(cbUbicacion.getSelectedIndex()-1).getIdUbicacion();
        String hospital = ubicaciones.get(cbUbicacion.getSelectedIndex()-1).getHospital();
        String nombreSala = ubicaciones.get(cbUbicacion.getSelectedIndex()-1).getNombreSala();

        ubicacion.setIdUbicacion(idUbicacion);
        ubicacion.setHospital(hospital);
        ubicacion.setNombreSala(nombreSala);
      
        
        habitacion.setUbicacion(ubicacion);
        
        System.out.println("PUTOOoOOOOooooOO:  "+ubicacion.getIdUbicacion()+ " "+ubicacion.getHospital()+" "+ubicacion.getNombreSala());
    
        controlador.insertarHabitacion(habitacion, ubicacion,tablaHabitacion);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Habitacion habitacion = new Habitacion();
        int row = tablaHabitacion.getSelectedRow();
        String id = tablaHabitacion.getValueAt(row, 0).toString();
        habitacion.setIdHabitacion(Integer.parseInt(id));
        
        controlador.eliminarHabitacion(habitacion, tablaHabitacion);
        
        limpiarCampos();
        btnEliminar.setEnabled(false);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaHabitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHabitacionMouseClicked
        int row = tablaHabitacion.getSelectedRow();
        String numero = tablaHabitacion.getValueAt(row, 1).toString();
        //String ubicacion = tablaHabitacion.getValueAt(row, 2).toString();
        
        txtNumero.setText(numero);
        //txtNombre.setText(nombre);
    }//GEN-LAST:event_tablaHabitacionMouseClicked

public void limpiarCampos(){

    txtNumero.setText("");

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbUbicacion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHabitacion;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}