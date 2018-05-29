/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo;

import java.util.ArrayList;

/**
 *
 * @author Flexxo333
 */
public class Profesional {
    private int cedula;
    private String nombre;
    private String apellido;
    private boolean estadoActivo;
    private ArrayList<Cita> citasAgendadas;
    private Especialidad especialidad;
    private Calendario agenda;
        //public Profesional(int cedula, String nombre, String apellido, boolean estadoActivo, Especialidad especialidad) { Constructor sin horario, es decir, fijo
//    this.cedula = cedula;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.estadoActivo = estadoActivo;
//        this.citasAgendadas = new ArrayList<>();
//        this.especialidad = especialidad;
//        this.agenda = new Calendario(8, 0, 75, 8);
//    }
    
    //Constructor dinámico
    public Profesional(int cedula, String nombre, String apellido, boolean 
            estadoActivo, Especialidad especialidad, int horaInicio, int minuto, int minutosXSesion, int horasLaboradas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoActivo = estadoActivo;
        this.citasAgendadas = new ArrayList<>();
        this.especialidad = especialidad;
        this.agenda = new Calendario(horaInicio, minuto, minutosXSesion, horasLaboradas);
        
    }
    
    public String info(){
        return this.cedula + this.nombre + this.apellido+ this.estadoActivo + this.especialidad.getNombre();
    }
    
    public Calendario getAgenda() {
        return agenda;
    }

    public void setAgenda(Calendario agenda) {
        this.agenda = agenda;
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

    public ArrayList<Cita> getCitasAgendadas() {
        return citasAgendadas;
    }

    public void setCitasAgendadas(ArrayList<Cita> citasAgendadas) {
        this.citasAgendadas = citasAgendadas;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
}
