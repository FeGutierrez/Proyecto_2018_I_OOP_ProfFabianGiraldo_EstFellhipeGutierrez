/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo;

import java.util.Date;

/**
 *
 * @author Flexxo333
 */
public class Franja {
    
    private int id;
    private Date fecha;
    private Cita cita;

    public Franja(int id, Date fecha, Cita cita) {
        this.id = id;
        this.fecha = fecha;
        this.cita = cita;
    }
    
    public String info(){
        if (cita!=null) {
            return this.id + ", " + this.fecha + ", "+ this.cita.info();
        }
        return this.id + ", " + this.fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
    
    
    
    
}
