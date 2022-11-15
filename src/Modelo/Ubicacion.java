/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author FlorBarrera
 */
public class Ubicacion {
    
     int idUbicacion;
    String hospital;
    String nombreSala;

    public Ubicacion() {
    }

    public Ubicacion(int idUbicacion, String hospital, String nombreSala) {
        this.idUbicacion = idUbicacion;
        this.hospital = hospital;
        this.nombreSala = nombreSala;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }
    
    
}
