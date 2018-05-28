/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Flexxo333
 */
public class Cliente {
    private int cedula;
    private String nombre;
    private String apellido;
    private boolean estadoActivo;
    private File historiaClinica;

    public Cliente(int cedula, String nombre, String apellido, boolean estadoActivo){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoActivo = estadoActivo;
        this.historiaClinica = new File(this.cedula+"_"+this.nombre+"_"+this.apellido+".txt");
        if (!this.historiaClinica.exists()) {
            try {
                this.historiaClinica.createNewFile();
            } catch (IOException e) {
                
            }
        }
    }
    
    public String info(){
        return this.cedula+ " , " + this.nombre+ " , " + this.apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public File getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(File historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
    
    
    
}
