/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.time.*;
/**
 *
 * @author Flexxo333
 */
public class EntidadSalud {
    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Profesional> profesionales;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Cita> citasProgramadas;
    private ArrayList<ProductoRegistrado> inventario;
    private ArrayList<Especialidad> especialidades;
    private ArrayList<Catalogo> productosCatalogo;

    public EntidadSalud(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.profesionales = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.citasProgramadas = new ArrayList<>();
        this.inventario = new ArrayList<>();
        this.especialidades = new ArrayList<>();
        this.productosCatalogo = new ArrayList<>();
    }
    
    public boolean registrarCliente(int cedula, String nombre, String apellido){
        boolean ex = false;
        boolean j=false;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getCedula() == cedula) {
                ex = true;
            }
        }
        
        if (ex==false) {
            Cliente cliente = new Cliente(cedula, nombre, apellido, true);
            this.clientes.add(cliente);
            j = true;
        } else {
            //Excepcion
        }
        
        return j;
    }
    

    
    public boolean registrarEspecialidad(int codigo, String nombre){
        boolean ex = false;
        boolean j = false;
        for (int i = 0; i < this.especialidades.size(); i++) {
            if (codigo == this.especialidades.get(i).getCodigo()) {
                ex = true;
            }
        }
        
        if (ex==false) {
            Especialidad especialidad = new Especialidad(codigo, nombre);
            this.especialidades.add(especialidad);
            j = true;
        } else {
            //Excepcion
        }
        return j;
    }
    
//    
//    public Profesional(int cedula, String nombre, String apellido, boolean 
//            estadoActivo, Especialidad especialidad, int horaInicio, int minuto, int minutosXSesion, int horasLaboradas) {
    
    public boolean registrarProfesional(int cedula, String nombre, String apellido, 
            int codigoEspecialidad, int horaInicio, int minuto, int minutosXCita, int horasLaboradas ){
        boolean j= false;
        boolean ex = false;
        Especialidad especialidad =null;
        
        //Verificar existencia del profesional
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (this.profesionales.get(i).getCedula() == cedula) {
                ex = true;
            }
        }
        
        //Verificar que el codigo de especlidad ingresado provoque colision en el arrayList
        for (int i = 0; i < this.especialidades.size(); i++) {
            if (this.especialidades.get(i).getCodigo() == codigoEspecialidad) {
                especialidad = this.especialidades.get(i);
            }
        }
        
        
        //Especialidad debe ser diferente de nulo
        if (ex == false && especialidad !=null) {
            //Calendario(int horaInicio, int minuto, int minutosXSesion, int horasLaboradas) {
            //public Profesional(int cedula, String nombre, String apellido, boolean 
            //estadoActivo, Especialidad especialidad, int horaInicio, int minuto, int minutosXSesion, int horasLaboradas) {
            Profesional profesional = new Profesional(cedula, nombre, apellido, true, especialidad,
                horaInicio, minuto, minutosXCita, horasLaboradas);
            this.profesionales.add(profesional);
            j=true;
        } else {
            //Excepcion
        }
        return j;
                
    }
    
    public boolean registrarProveedor(int nit, String nombre){
        boolean j= false;
        boolean ex= false;
        for (int i = 0; i < this.proveedores.size(); i++) {
            if (this.proveedores.get(i).getNit() == nit) {
                ex = true;
            }
        }
        if (ex==false) {
            Proveedor proveedor = new Proveedor(nit, nombre);
            this.proveedores.add(proveedor);
            j = true;
        }
        
        
        return j;
        
    }
    
    public boolean regisrarProductoCatalogo(int id, String nombre){
        boolean j= false;
        boolean ex= false;
        
        //¿Existe?
        for (int i = 0; i < this.productosCatalogo.size(); i++) {
            if (this.productosCatalogo.get(i).getId() == id) {
                ex = true;
            }
        }
        //Agregar a lista
        if (ex == false) {
            Catalogo catalogo = new Catalogo(id, nombre);
            this.productosCatalogo.add(catalogo);
            j = true;
        }
        return j;        
    }
    
    public boolean registrarCita(int cedulaCliente, int cedulaProfesional, int idFranja){
        boolean j= false;
        //Variables auxiliares
        Profesional profesional = null;
        Cliente cliente = null;
        Franja franja = null;
        Cita cita = null;
        //Para registrar una cita se necesita, cedula del profesional
        
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (cedulaProfesional == this.profesionales.get(i).getCedula()) {
                profesional = this.profesionales.get(i);
            }
        }
        System.out.println(profesional.getCedula());
        
        //cedula del cliente
        for (int i = 0; i < this.clientes.size(); i++) {
            if (cedulaCliente == this.clientes.get(i).getCedula()) {
                cliente = this.clientes.get(i);
            }
        }
        System.out.println(cliente.getCedula());
        if (cliente == null) {
            //Excepcion
        } else {
            if (profesional == null) {
                //Excepcion
            } else {
                for (int i = 0; i < profesional.getAgenda().getFranjas().size(); i++) {
                    if (idFranja == profesional.getAgenda().getFranjas().get(i).getId()) {
                        franja = profesional.getAgenda().getFranjas().get(i);
                    }
                }
            }
        }
        
        if (franja == null) {
            //Excepcion franja no existe
        } else {
            //, una franja disponible del profesional
            if (franja.getCita() !=null) {
                //Excepcion franja del profesional ya cuenta con cita
            } else {
                cita = new Cita(1, cliente, profesional, franja);
                //Setear la cita en la franja para futuras validaciones
                franja.setCita(cita);
                profesional.getCitasAgendadas().add(cita);
                j = true;
            }
        }
        //if (profesional!=null && cita!=null && cliente !=null) {
        //     
        //}
        
        return j;
        
    }
    
    public boolean registrarEnInventario(Date fechaRegistro, int nitProveedor, 
            int idProdCatalogo, String categoria, int cantidad){
        boolean j= false;
        boolean ex = false;
        //Variable auxiliar
        ProductoRegistrado prod = null;
        Proveedor prove = null;
        Catalogo prodCat =null;
        //Obtener Proveedor
        for (int i = 0; i < this.proveedores.size(); i++) {
            if (this.proveedores.get(i).getNit() == nitProveedor) {
                prove = this.proveedores.get(i);
            }
        }
        //Obtener desde Catalogo
        for (int i = 0; i < this.productosCatalogo.size(); i++) {
            if (this.productosCatalogo.get(i).getId()== idProdCatalogo) {
                prodCat = this.productosCatalogo.get(i);
            }
        }
        //¿Existe?
        for (int i = 0; i < this.inventario.size(); i++) {
            ProductoRegistrado x = this.inventario.get(i);
            if (x.getProducto()==prodCat && x.getProveedor()==prove) {
                ex = true;
                prod = x;
        }
        
        if (prove ==null || prodCat==null) {
            //Excepcion existencia proveedores
        } else
        //Si existe se añade la cantidad, si no existe, se crea y se hace un set de la cantidad
        //Si existe sabemos que <<prod>> no será un objeto null
        if (ex == true) {
            prod.setCantidad(prod.getCantidad() + cantidad);
        } else {
            int id = this.inventario.size()+1;
            ProductoRegistrado productoRegistrado = new ProductoRegistrado(id, prodCat, prove, categoria, fechaRegistro);
            this.inventario.add(productoRegistrado);
        }
        }
        return j;
    }
    
    
    
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Profesional> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(ArrayList<Profesional> profesionales) {
        this.profesionales = profesionales;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public ArrayList<Cita> getCitasProgramadas() {
        return citasProgramadas;
    }

    public void setCitasProgramadas(ArrayList<Cita> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }

    public ArrayList<ProductoRegistrado> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<ProductoRegistrado> inventario) {
        this.inventario = inventario;
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public ArrayList<Catalogo> getProductosCatalogo() {
        return productosCatalogo;
    }

    public void setProductosCatalogo(ArrayList<Catalogo> productosCatalogo) {
        this.productosCatalogo = productosCatalogo;
    }
    
    
    
}
