/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo;

/**
 *
 * @author Flexxo333
 */
public class Cita {
    
    private int codigo;
    private Cliente cliente;
    private Profesional profesional;
    private Franja fecha;
    private boolean activa;

    public Cita(int codigo, Cliente cliente, Profesional profesional, Franja fecha) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.profesional = profesional;
        this.fecha = fecha;
        this.activa = true;
    }
    
    public String info(){
        return this.codigo + "," + this.cliente.getNombre() + "," + this.profesional.getNombre()+ "," +this.fecha.getFecha() + " " + this.activa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Franja getFecha() {
        return fecha;
    }

    public void setFecha(Franja fecha) {
        this.fecha = fecha;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
}
