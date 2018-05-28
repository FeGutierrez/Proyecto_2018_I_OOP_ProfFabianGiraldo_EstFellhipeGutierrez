/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadsalud.test;

import java.util.ArrayList;



/**
 *
 * @author Flexxo333
 */
public class EntidadSalud {
    
    private String nombre;
    private ArrayList<ClienteT> listaClientes;

    public EntidadSalud(String nombre) {
        this.nombre = nombre;
        this.listaClientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<ClienteT> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<ClienteT> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    
    
}
