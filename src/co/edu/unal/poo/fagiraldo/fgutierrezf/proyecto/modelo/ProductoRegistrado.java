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
public class ProductoRegistrado {
    
    private int id;
    private Catalogo producto;
    private Proveedor proveedor;
    private String categoria;
    private Date fechaRegistro;
    private int cantidad;

    public ProductoRegistrado(int id, Catalogo producto, Proveedor proveedor, String categoria, Date fechaRegistro) {
        this.id = id;
        this.producto = producto;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.fechaRegistro = fechaRegistro;
        this.cantidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Catalogo getProducto() {
        return producto;
    }

    public void setProducto(Catalogo producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
