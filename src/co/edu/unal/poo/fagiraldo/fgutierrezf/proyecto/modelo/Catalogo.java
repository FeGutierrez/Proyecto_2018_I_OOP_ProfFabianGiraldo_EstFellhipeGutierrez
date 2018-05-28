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
public class Catalogo {
    
    private int id;
    private String nombre;
    private ArrayList<Proveedor> proveedoresQueOfrecen;

    public Catalogo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.proveedoresQueOfrecen = new ArrayList<>();
    }
    
    public String info(){
        return "Id: " +this.id + " Nombre: " + this.nombre;
    }
    public String ofertadoPor(){
        String str = "";
        for (int i = 0; i < this.proveedoresQueOfrecen.size(); i++) {
            str += this.proveedoresQueOfrecen.get(i).info();
        }
        return str;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Proveedor> getProveedoresQueOfrecen() {
        return proveedoresQueOfrecen;
    }

    public void setProveedoresQueOfrecen(ArrayList<Proveedor> proveedoresQueOfrecen) {
        this.proveedoresQueOfrecen = proveedoresQueOfrecen;
    }
    
    
    
    
    
}
