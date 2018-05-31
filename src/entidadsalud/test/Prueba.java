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
    class Entidad{
        private String nombre;
        private ArrayList<Perro> perros;
        private ArrayList<Persona> personas;

        public Entidad(String nombre) {
            this.nombre = nombre;
            this.perros = new ArrayList<>();
            this.personas = new ArrayList<>();
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Perro> getPerros() {
        return perros;
    }

    public void setPerros(ArrayList<Perro> perros) {
        this.perros = perros;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
        
    }

    class Perro {
        private String nombre;
        private Persona dueno;

        public Perro(String nombre, Persona dueno) {
            this.nombre = nombre;
            this.dueno = dueno;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueno) {
        this.dueno = dueno;
    }
        
        
    }

    class Persona {
        private String nombre;
        private ArrayList<Perro> mascotas;

        public Persona(String nombre) {
            this.nombre = nombre;
            this.mascotas = new ArrayList<>();
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Perro> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Perro> mascotas) {
        this.mascotas = mascotas;
    }
        
    }


public class Prueba {
    
    
    public static void main(String[] args) {
        Entidad ent = new Entidad("Veterinaria");
        Persona per1 = new Persona("Yaryzzeyda");
        Perro perro1 = new Perro("Zeus", per1);
        Perro perro2 = new Perro("Diana", per1);
        
        ent.getPerros().add(perro1);
        per1.getMascotas().add(perro1);
        ent.getPerros().add(perro2);
        per1.getMascotas().add(perro2);
        
        System.out.println(ent.getPerros().get(0).getNombre());
        System.out.println(per1.getMascotas().get(0).getNombre());
        System.out.println("******");
        System.out.println("******");
        System.out.println("******");
        Perro perro3 = null;
        
        perro3=perro1;
        
        System.out.println("******");
        System.out.println("ACA");
        perro3.setNombre("julian");
        System.out.println("******");
        
        System.out.println(ent.getPerros().get(0).getNombre());
        System.out.println(per1.getMascotas().get(0).getNombre());
        
        
        //entidadsalud.test.Perro@7d4991ad
        //entidadsalud.test.Perro@28d93b30
    }

    
}

