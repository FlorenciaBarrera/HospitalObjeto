/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Controlador.ControladorInternacion;
import Modelo.Cama;
import Modelo.Habitacion;
import Modelo.Internacion;
import Modelo.Ubicacion;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author FlorBarrera
 */
public class vInternacion extends javax.swing.JInternalFrame {

ControladorInternacion controladorInternacion;
Controlador controlador;
ArrayList<Ubicacion> ubicaciones;

ArrayList<Habitacion> habitaciones;
ArrayList<Cama> camas;
ArrayList<Internacion> internaciones;
Ubicacion u;
Habitacion h;
Internacion in;
    public vInternacion() throws SQLException {
        initComponents();
        controladorInternacion = new ControladorInternacion();
        controlador = new Controlador();
        ubicaciones = new ArrayList<Ubicacion>();
        
        habitaciones = new ArrayList<Habitacion>();
        camas = new ArrayList<Cama>();
        internaciones = new ArrayList<Internacion>();
        u = new Ubicacion();
        h = new Habitacion();
        in = new Internacion();
        controladorInternacion.llenarTablaInternacion(tablaInternacion);
        
        habitaciones = controlador.llenarComboHabitacion();
        ubicaciones = controlador.llenarComboUbicacion();
        
        camas = controladorInternacion.llenarComboCama();
        
        
        for (int i = 0; i<ubicaciones.size();i++){
            u.setHospital(ubicaciones.get(i).getHospital());
            u.setNombreSala(ubicaciones.get(i).getNombreSala());
            }
        
         for (int i = 0; i<habitaciones.size();i++){
            h.setNumero(habitaciones.get(i).getNumero());
            
            }
        
        for (int i = 0; i < camas.size(); i++) {
            
                    cbCama.addItem( camas.get(i).getNumero()+" - "+camas.get(i).getEstado() +" - " + ubicaciones.get(i).getHospital()+" - "+ ubicaciones.get(i).getNombreSala()+ " - "+habitaciones.get(i).getNumero());
        
        
    }}
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInternacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDiagnostico = new javax.swing.JTextField();
        cbCama = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        fechaInternacion = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();

        tablaInternacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInternacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInternacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInternacion);

        jLabel1.setText("Paciente:");

        txtPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPacienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha:");

        jLabel3.setText("Cama:");

        jLabel4.setText("Diagnóstico:");

        cbCama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cama..." }));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setText("INTERNACIÓN");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCama, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(64, 64, 64)
                                            .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(78, 78, 78)
                                            .addComponent(btnEliminar)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(fechaInternacion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(216, 250, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(fechaInternacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        Internacion internacion = new Internacion();
        Cama cama = new Cama();
        Habitacion habitacion = new Habitacion();
        Ubicacion ubicacion = new Ubicacion();
        
        
        internacion.setPaciente(txtPaciente.getText());
        internacion.setDiagnostico(txtDiagnostico.getText());
        
        int idCama = camas.get(cbCama.getSelectedIndex()-1).getIdCama();
        cama.setIdCama(idCama);
//        int idUbicacion = ubicaciones.get(cbHabitacion.getSelectedIndex()-1).getIdUbicacion();
//        String hospital = ubicaciones.get(cbHabitacion.getSelectedIndex()-1).getHospital();
//        String nombreSala = ubicaciones.get(cbHabitacion.getSelectedIndex()-1).getNombreSala();

//        int idHabitacion = habitaciones.get(cbHabitacion.getSelectedIndex()-1).getIdHabitacion();
//        int numero = habitaciones.get(cbHabitacion.getSelectedIndex()-1).getNumero();

        
//        ubicacion.setIdUbicacion(idUbicacion);
//        ubicacion.setHospital(hospital);
//        ubicacion.setNombreSala(nombreSala);
//      
//        habitacion.setIdHabitacion(idHabitacion);
//        habitacion.setNumero(numero);
//        habitacion.setUbicacion(ubicacion);
//        int idCama = camas.get(cbCama.getSelectedIndex()-1).getIdCama();
//        int numeroCama = camas.get(cbCama.getSelectedIndex()-1).getNumero();
//        String estado = camas.get(cbCama.getSelectedIndex()-1).getEstado();
//        cama.setHabitacion(habitacion);
        
        //internacion.setCama(cama);
        //internacion.setCama(cama.getIdCama());
        
//        if (cbEstado.getSelectedIndex()!=0){
//            cama.setEstado(cbEstado.getSelectedItem().toString());
//            controlador.insertarCama(cama, habitacion, tablaCama);}
//            else {
//            JOptionPane.showMessageDialog(null, "Seleccione Estado Cama");
//        }  
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
    String fechaActual = fecha.format(fechaInternacion.getDate());
        internacion.setFecha(fechaActual);
        
        if(txtDiagnostico.getText().length()==0){
                JOptionPane.showMessageDialog(null, "El campo diagnostico es obligatorio");
           }
           else{
                //System.out.println("Si hay texto");
                 //System.out.println("Falla; " + internacion.getPaciente()+" - "+ cama.getIdCama()+" - "+ internacion.getFecha()+" - " + internacion.getDiagnostico());
                   controladorInternacion.insertarInternacion(internacion, cama, tablaInternacion);
 habitaciones = controlador.llenarComboHabitacion();
        ubicaciones = controlador.llenarComboUbicacion();
        
        camas = controladorInternacion.llenarComboCama();
        
        
        for (int i = 0; i<ubicaciones.size();i++){
            u.setHospital(ubicaciones.get(i).getHospital());
            u.setNombreSala(ubicaciones.get(i).getNombreSala());
            }
        
         for (int i = 0; i<habitaciones.size();i++){
            h.setNumero(habitaciones.get(i).getNumero());
            
            }
        
        for (int i = 0; i < camas.size(); i++) {
            
                    cbCama.addItem( camas.get(i).getNumero()+" - "+camas.get(i).getEstado() +" - " + ubicaciones.get(i).getHospital()+" - "+ ubicaciones.get(i).getNombreSala()+ " - "+habitaciones.get(i).getNumero());
        
        
    }
           }
       
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Internacion internacion = new Internacion();
        int row = tablaInternacion.getSelectedRow();
        String id = tablaInternacion.getValueAt(row, 5).toString();
        internacion.setIdInternacion(Integer.parseInt(id));
        
        controladorInternacion.eliminarInternacion(internacion, tablaInternacion);
        
        limpiarCampos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaInternacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInternacionMouseClicked
        int row = tablaInternacion.getSelectedRow();
        String paciente = tablaInternacion.getValueAt(row, 6).toString();
        String diagnostico = tablaInternacion.getValueAt(row, 8).toString();
        
        txtPaciente.setText(paciente);
        txtDiagnostico.setText(diagnostico);
    }//GEN-LAST:event_tablaInternacionMouseClicked

    private void txtPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPacienteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

public void limpiarCampos(){

    txtPaciente.setText("");
    txtDiagnostico.setText("");

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbCama;
    private com.toedter.calendar.JDateChooser fechaInternacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaInternacion;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtPaciente;
    // End of variables declaration//GEN-END:variables
}
