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
public class Cama {
    int idCama;
    int numero;
    String estado;
    Habitacion habitacion;

    public Cama() {
    }

    public Cama(int idCama, int numero, String estado, Habitacion habitacion) {
        this.idCama = idCama;
        this.numero = numero;
        this.estado = estado;
        this.habitacion = habitacion;
    }

    public int getIdCama() {
        return idCama;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    
}
