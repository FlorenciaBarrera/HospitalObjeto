/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
* @author FlorBarrera
 */
public class Internacion {
    
    int idInternacion;
    String paciente;
    String fecha;
    String diagnostico;
    int idCama;

    public Internacion() {
    }

    public Internacion(int idInternacion, String paciente, String fecha, String diagnostico, int cama) {
        this.idInternacion = idInternacion;
        this.paciente = paciente;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.idCama = cama;
    }

    public int getIdInternacion() {
        return idInternacion;
    }

    public void setIdInternacion(int idInternacion) {
        this.idInternacion = idInternacion;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getIdCama() {
        return idCama;
    }

    public void setCama(int cama) {
        this.idCama = cama;
    }
    
    
}
