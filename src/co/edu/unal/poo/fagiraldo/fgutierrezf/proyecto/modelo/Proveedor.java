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
public class Proveedor {
    
    private int nit;
    private String nombre;
    private ArrayList<Catalogo> productosOfrecidos;

    public Proveedor(int nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        this.productosOfrecidos = new ArrayList<>();
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Catalogo> getProductosOfrecidos() {
        return productosOfrecidos;
    }

    public void setProductosOfrecidos(ArrayList<Catalogo> productosOfrecidos) {
        this.productosOfrecidos = productosOfrecidos;
    }
    
    public String info(){
        return "NIT: " + this.nit + " Nombre: " + this.nombre;
    }
    
    public String listarProductosOfrecidos(){
        String str = "";
        for (int i = 0; i < this.productosOfrecidos.size(); i++) {
            str+= this.productosOfrecidos.get(i).info();
        }
        return str;
    }
    
    
}
