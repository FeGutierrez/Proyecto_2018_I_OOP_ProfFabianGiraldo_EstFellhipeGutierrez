/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo;

import java.util.ArrayList;
import java.util.Date;
import co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones.*;

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
    
    
    //Funciones Constructoras o de registro
    public boolean registrarCliente(int cedula, String nombre, String apellido) 
            throws RegisteredClientException{
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
            throw new RegisteredClientException();
        }
        return j;
    }
    

    
    public boolean registrarEspecialidad(int codigo, String nombre) throws RegisteredSpecialityException{
        boolean ex = false;
        boolean j = false;
        for (int i = 0; i < this.especialidades.size(); i++) {
            if (codigo == this.especialidades.get(i).getCodigo() || nombre.equals(this.especialidades.get(i).getNombre())) {
                ex = true;
            }
        }
        if (ex==false) {
            Especialidad especialidad = new Especialidad(codigo, nombre);
            this.especialidades.add(especialidad);
            j = true;
        } else {
            //Excepcion
            throw new RegisteredSpecialityException();
        }
        return j;
    }
    
//    
//    public Profesional(int cedula, String nombre, String apellido, boolean 
//            estadoActivo, Especialidad especialidad, int horaInicio, int minuto, int minutosXSesion, int horasLaboradas) {
    
    public boolean registrarProfesional(int cedula, String nombre, String apellido, 
            int codigoEspecialidad, int horaInicio, int minuto, int minutosXCita, int horasLaboradas )
        throws RegisteredProfesionalException , SpecialityNotFoundException{
        boolean j= false;
        boolean ex = false;
        Especialidad especialidad =null;
        
        //Verificar existencia del profesional
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (this.profesionales.get(i).getCedula() == cedula) {
                ex = true;
            }
        }
        //Verificar que el codigo de especialidad ingresado provoque colision en el arrayList
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
            if (ex==true) {
                throw new RegisteredProfesionalException();
            }
            if (especialidad==null) {
                throw new SpecialityNotFoundException();
            }
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
    
    public boolean registrarCita(int cedulaCliente, int cedulaProfesional, int idFranja)
        throws ClientNotFoundException, ProfesionalNotFoundException, StripeNotFoundException,
            OccupiedStripeException{
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
        //cedula del cliente
        for (int i = 0; i < this.clientes.size(); i++) {
            if (cedulaCliente == this.clientes.get(i).getCedula()) {
                cliente = this.clientes.get(i);
            }
        }
        if (cliente == null) {
            //Excepcion
            throw new ClientNotFoundException();
        } else {
            if (profesional == null) {
                //Excepcion
                throw new ProfesionalNotFoundException();
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
            throw new StripeNotFoundException();
        } else {
            //, una franja disponible del profesional
            if (franja.getCita() !=null) {
                //Excepcion franja del profesional ya cuenta con cita
                throw  new OccupiedStripeException();
            } else {
                cita = new Cita(this.citasProgramadas.size()+1, cliente, profesional, franja);
                //Setear la cita en la franja para futuras validaciones
                this.citasProgramadas.add(cita);
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
            int idProdCatalogo, String categoria, int cantidad) throws
                ProveedorNotFound, CatalogProductNotFound {
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
        
        
        if (prove ==null) {
            //Excepcion existencia proveedores
            throw new ProveedorNotFound();
        } else {
            if (prodCat==null) {
                throw new CatalogProductNotFound();
            } else {
                //¿Existe?
                for (int i = 0; i < this.inventario.size(); i++) {
                    ProductoRegistrado x = this.inventario.get(i);
                    if (x.getProducto()==prodCat && x.getProveedor()==prove) {
                        ex = true;
                        prod = x;
                }
                
                if (ex == true) {
                prod.setCantidad(prod.getCantidad() + cantidad);
                } else {
                    int id = this.inventario.size()+1;
                    ProductoRegistrado productoRegistrado = new ProductoRegistrado(id, prodCat, prove, categoria, fechaRegistro);
                    this.inventario.add(productoRegistrado);
                }
            }
        } 
        //Si existe se añade la cantidad, si no existe, se crea y se hace un set de la cantidad
        //Si existe sabemos que <<prod>> no será un objeto null
        
        }
        return j;
    }
    
    
    //***FUNCIONES MODIFICADORAS
    
    public boolean editarProfesional(int cedula, String nombre, String apellido, int codigoEspecialidad) 
            throws ProfesionalNotFoundException, SpecialityNotFoundException{
        Profesional profesional = null;
        Especialidad especialidad =null;
        boolean j = false;
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (this.profesionales.get(i).getCedula() == cedula) {
                profesional = this.profesionales.get(i);
            }
        }
        for (int i = 0; i < this.especialidades.size(); i++) {
            if (this.especialidades.get(i).getCodigo() == codigoEspecialidad) {
                especialidad = this.especialidades.get(i);
            }
        }
        
        if (profesional==null) {
            throw new ProfesionalNotFoundException();
        } else if (especialidad==null) {
            throw new SpecialityNotFoundException();
        } else {
            profesional.setNombre(nombre);
            profesional.setApellido(apellido);
            profesional.setEspecialidad(especialidad);
            j=true;
        }
        return j;
    }
    
    public boolean editarCliente(int cedulaCliente, String nombre, String apellido)
        throws ClientNotFoundException{
        boolean j = false;
        Cliente cliente =null;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getCedula() == cedulaCliente) {
                cliente = this.clientes.get(i);
            }
        }
        if (cliente == null) {
            throw new ClientNotFoundException();
        } else {
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            j=true;
        }
        return j;
    }
    
    public boolean editarProductoCatalogo(int idProdCat, String nombre) throws CatalogProductNotFound{
        boolean j= false;
        Catalogo catalogo =null;
        for (int i = 0; i < this.productosCatalogo.size(); i++) {
            if (this.productosCatalogo.get(i).getId() == idProdCat) {
                catalogo = this.productosCatalogo.get(i);
            }
        }
        if (catalogo == null) {
            throw new CatalogProductNotFound();
        } else {
            catalogo.setNombre(nombre);
            j=true;
        }
        return j;
    }
    
    public boolean editarProveedor(int idProveedor, String nombre) throws ProveedorNotFound{
        boolean j = false;
        Proveedor proveedor =null;
        for (int i = 0; i < this.proveedores.size(); i++) {
            if (this.proveedores.get(i).getNit() == idProveedor) {
                proveedor = this.proveedores.get(i);
            }
        }
        if (proveedor == null) {
            throw new ProveedorNotFound();
        } else {
            proveedor.setNombre(nombre);
            j=true;
        }
        return j;
    }
    public void editarCita(int codigo, int cedulaProfesional, int idFranja) throws AppointmentNotFoundException
        , ClientNotFoundException, ProfesionalNotFoundException, StripeNotFoundException, OccupiedStripeException{
        Cita cita =null;
        Cita citaAux = null;
        int cedulaCliente = 0;
        for (int i = 0; i < this.citasProgramadas.size(); i++) {
            if (this.citasProgramadas.get(i).getCodigo()==codigo) {
                cita = this.citasProgramadas.get(i);
            }
        }
        if (cita == null) {
            throw new AppointmentNotFoundException();
        } else {
            //Buscar en la cita en las franjas de los profesionales extraerla y retirarla de la franja
            for (int i = 0; i < this.profesionales.size(); i++) {
                for (int j = 0; j < this.profesionales.get(i).getAgenda().getFranjas().size(); j++) {
                    if (cita == this.profesionales.get(i).getAgenda().getFranjas().get(j).getCita()) {
                        citaAux = this.profesionales.get(i).getAgenda().getFranjas().get(j).getCita();
                        //Se retra de cita pero no del arrayList de citas de la entidad
                        this.profesionales.get(i).getAgenda().getFranjas().get(j).setCita(null);
                    }
                }
            }
            if (citaAux == null) {
                throw new AppointmentNotFoundException();
            } else {
                //Extraer cedula y poner estado en false
                cedulaCliente = citaAux.getCliente().getCedula();
                citaAux.setActiva(false);
            }
            if (cedulaCliente == 0) {
                throw new ClientNotFoundException();
            } else {
                //Registrar nueva cita con el cliente de la cita que se ha modificado, 
                //el profesional deseado y la franja de ese profesional (Si existe)
                registrarCita(cedulaCliente, cedulaProfesional, idFranja);
                //Asignar la cita al id del profesional en el id de franja del mismo
            }
        }
        
    }
    
    public boolean editarEspecialidad(int codigo, String nombre) throws SpecialityNotFoundException{
        boolean j = false;
        Especialidad especialidad =null;
        for (int i = 0; i < this.especialidades.size(); i++) {
            if (this.especialidades.get(i).getCodigo()== codigo) {
                especialidad = this.especialidades.get(i);
            }
        }
        if (especialidad == null) {
            throw new SpecialityNotFoundException();
        } else {
            especialidad.setNombre(nombre);
            j=true;
        }
        return j;
    }
    
    /*
    ****
    *FUNCIONES DESTRUCTORAS O DE ELIMINACIÓN (FISICA Y/O LOGICA)
    ****
    */
    public boolean desactivarProfesional(int cedula) throws ProfesionalNotFoundException{
        boolean j = false;
        Profesional profesional = null;
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (this.profesionales.get(i).getCedula() == cedula) {
                profesional = this.profesionales.get(i);
            }
        }
        if (profesional ==null) {
            throw new ProfesionalNotFoundException();
        } else {
            profesional.setEstadoActivo(false);
            j = true;
        }
        return j;
        
    }
    
    public boolean desactivarCliente(int cedula) throws ClientNotFoundException{
        boolean j = false;
        Cliente cliente = null;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getCedula() == cedula) {
                cliente = this.clientes.get(i);
            }
        }
        if (cliente ==null) {
            throw new ClientNotFoundException();
        } else {
            cliente.setEstadoActivo(false);
            j = true;
        }
        return j;
        
    }
    
    public void eliminarProductoCatalogo(){
        
    }
    
    public boolean desactivarProveedor(int nit) throws ProveedorNotFound{
        boolean j=false;
        Proveedor proveedor = null;
        for (int i = 0; i < this.proveedores.size(); i++) {
            if (this.proveedores.get(i).getNit() == nit) {
                proveedor = this.proveedores.get(i);
            }
        }
        if (proveedor == null) {
            throw new ProveedorNotFound();
        } else {
            proveedor.setEstadoActivo(false);
            j = true;
        }
        return j;
    }
    
    public boolean cancelarCita(int codigo) throws AppointmentNotFoundException{
        Cita cita =null;
        boolean a = false;
        for (int i = 0; i < this.citasProgramadas.size(); i++) {
            if (this.citasProgramadas.get(i).getCodigo()==codigo) {
                cita = this.citasProgramadas.get(i);
            }
        }
        if (cita == null) {
            throw new AppointmentNotFoundException();
        } else {
            //Buscar la cita en las franjas de los profesionales extraerla y retirarla de la franja
            for (int i = 0; i < this.profesionales.size(); i++) {
                for (int j = 0; j < this.profesionales.get(i).getAgenda().getFranjas().size(); j++) {
                    if (cita == this.profesionales.get(i).getAgenda().getFranjas().get(j).getCita()) {
                        //Se retra de cita pero no del arrayList de citas de la entidad
                        cita.setActiva(false);
                        this.profesionales.get(i).getAgenda().getFranjas().get(j).setCita(null);
                        a = true;
                    }
                }
            }
        }
        return a;
    }
    
    public boolean eliminarEspecialidad(int codigo) throws SpecialityNotFoundException{
        //Hay que mostrar una advertencia de que esto dejará sin 
        //especialidad a los profesionales que la posean
        //Buscarla
        boolean j = false;
        Especialidad especialidad = null;
        for (int i = 0; i < this.especialidades.size(); i++) {
            if (this.especialidades.get(i).getCodigo() == codigo) {
                especialidad = this.especialidades.get(i);
            }
        }
        if (especialidad == null) {
            throw new SpecialityNotFoundException();
        } else {
            //Quitarla de los profesioanles que la poseen, seteando null
            for (int i = 0; i < this.profesionales.size(); i++) {
                if (this.profesionales.get(i).getEspecialidad() == especialidad) {
                    this.profesionales.get(i).setEspecialidad(null);
                    j = true;
                }
            }
            //Eliminarla de la lista
            this.especialidades.remove(especialidad);
        }
        return j;
    }
    
    
    /*
    ****
    **FUNCIONES DE CONSULTA
    *****
    */
    //Clientes
    public String listarTodosClientes(){
        String str = "";
        for (int i = 0; i < this.clientes.size(); i++) {
            str+= this.clientes.get(i).info();
        }
        return str;
    }
    
    public String listarClientesActivos(){
        String str = "";
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).isEstadoActivo()) {
                str+= this.clientes.get(i).info();
            }
        }
        return str;
    }
    
    public String listarClientesNoActivos(){
        String str = "";
        for (int i = 0; i < this.clientes.size(); i++) {
            if (!this.clientes.get(i).isEstadoActivo()) {
                str+= this.clientes.get(i).info();
            }
        }
        return str;
    }
    
    //Profesionales
    public String listarTodosLosProfesionales(){
        String str = "";
        for (int i = 0; i < this.profesionales.size(); i++) {
            str += this.profesionales.get(i).info();
        }
        return str;
    }
    
    public String listarProfesionalesActivos(){
        String str = "";
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (this.profesionales.get(i).isEstadoActivo()) {
                str += this.profesionales.get(i).info();
            }
        }
        return str;
    }
    
    public String listarProfesionalesNoActivos(){
        String str = "";
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (!this.profesionales.get(i).isEstadoActivo()) {
                str += this.profesionales.get(i).info();
            }
        }
        return str;
    }
    
    //Citas
    public String listarTodasCitas(){
        String str = "";
        for (int i = 0; i < this.citasProgramadas.size(); i++) {
            str += this.citasProgramadas.get(i).info();
        }
        return str;
    }
    
    public String listarCitasActivas(){
        String str = "";
        for (int i = 0; i < this.citasProgramadas.size(); i++) {
            if (this.citasProgramadas.get(i).isActiva()) {
                str += this.citasProgramadas.get(i).info();
            }
        }
        return str;
    }
    
    public String listarCitasNoActivas(){
        String str = "";
        for (int i = 0; i < this.citasProgramadas.size(); i++) {
            if (!this.citasProgramadas.get(i).isActiva()) {
                str += this.citasProgramadas.get(i).info();
            }
        }
        return str;
    }
    
    //Proveedores
    public String listarTodosProveedores(){
        String str = "";
        for (int i = 0; i < this.proveedores.size(); i++) {
            str += this.proveedores.get(i).info();
        }
        return str;
    }
    
    public String listarProveedoresActivos(){
        String str = "";
        for (int i = 0; i < this.proveedores.size(); i++) {
            if (this.proveedores.get(i).isEstadoActivo()) {
                str += this.proveedores.get(i).info();
            }
        }
        return str;
    }
    
    public String listarProveedoresNoActivos(){
        String str = "";
        for (int i = 0; i < this.proveedores.size(); i++) {
            if (!this.proveedores.get(i).isEstadoActivo()) {
                str += this.proveedores.get(i).info();
            }
        }
        return str;
    }
    //Productos
    public String listarTodosProductosEnInventario(){
        String str = "";
        for (int i = 0; i < this.inventario.size(); i++) {
            str += this.inventario.get(i).info();
        }
        return str;
    }
    
    public String listarProductosEnCatalogo(){
        String str = "";
        for (int i = 0; i < this.productosCatalogo.size(); i++) {
            str += this.productosCatalogo.get(i).info();
        }
        return str;
    }
    //Especialidades
    public String listarTodasEspecialidades(){
        String str = "";
        for (int i = 0; i < this.especialidades.size(); i++) {
            str += this.especialidades.get(i).info();
        }
        return str;
    }
    public String listarFranjasdelProfesional(int cedula) throws ProfesionalNotFoundException{
    String str = "";
    Profesional profesional = null;
    //Hallar profesional
        for (int i = 0; i < this.profesionales.size(); i++) {
            if (this.profesionales.get(i).getCedula() == cedula) {
                profesional = this.profesionales.get(i);
            }
        }
        if (profesional==null) {
            throw new ProfesionalNotFoundException();
        } else {
            for (int i = 0; i < profesional.getAgenda().getFranjas().size(); i++) {
                str += profesional.getAgenda().getFranjas().get(i).info();
            }
        }
        return str;
    }
    public String listarFranjasLibres() {
    String str = "";
    //Hallar profesional
        for (int i = 0; i < this.profesionales.size(); i++) {
            for (int j = 0; j < this.profesionales.get(i).getAgenda().getFranjas().size(); j++) {
                if (this.profesionales.get(i).getAgenda().getFranjas().get(j).getCita()==null ) {
                    str += this.profesionales.get(i).getAgenda().getFranjas().get(j).info();
                }
            }
        }
        return str;
    }
    public String listarFranjasOcupadas(){
    String str = "";
    //Hallar profesional
        for (int i = 0; i < this.profesionales.size(); i++) {
            for (int j = 0; j < this.profesionales.get(i).getAgenda().getFranjas().size(); j++) {
                if (this.profesionales.get(i).getAgenda().getFranjas().get(j).getCita()!=null ) {
                    str += this.profesionales.get(i).getAgenda().getFranjas().get(j).info();
                }
            }
        }
        return str;
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
