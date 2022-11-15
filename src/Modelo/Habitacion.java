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
public class Habitacion {
    
    int idHabitacion;
    int numero;
    Ubicacion ubicacion;

    public Habitacion() {
        
        ubicacion = new Ubicacion();
        
    }

    public Habitacion(int idHabitacion, int numero, Ubicacion ubicacion) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.ubicacion = ubicacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    
}
