/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo;

import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.MainTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Flexxo333
 */
public class Calendario {
    
    
    private Date fechaHoraInicio;
    private ArrayList<Franja> franjas;
    private int minutosXSesion;
    private int horasLaboradas;
    
    public String info(){
        return this.fechaHoraInicio + " , " + this.minutosXSesion + " , " + this.horasLaboradas;
    }
    
    public Calendario(int horaInicio, int minuto, int minutosXSesion, int horasLaboradas) {
        this.fechaHoraInicio = convertiraHora(horaInicio, minuto);
        if (minutosXSesion==0) {
            this.minutosXSesion = 60;
        } else {
            this.minutosXSesion = minutosXSesion;
        }
        this.horasLaboradas = horasLaboradas;
        this.franjas = franjasDelCalendario();
    }
    
    public Date convertiraHora(int hora, int minuto){
        //Dia actual al crearla
        Date actual = new Date();
        Calendar calendario  = Calendar.getInstance();
        calendario.setTime(actual);
        
        //Establecer los parámetros de ubicación temporal
        calendario.set(calendario.HOUR_OF_DAY, hora);
        calendario.set(calendario.MINUTE, minuto);
        calendario.set(calendario.SECOND, 0);
        return calendario.getTime();
    }
//    //Arreglo de franjas cada una con estado ocupado o no.
    private ArrayList<Franja> franjasDelCalendario(){
        ArrayList<Franja> arregloFranjas = new ArrayList<>();
        int minutosLaborados = this.horasLaboradas*60;
        int numFranjas = minutosLaborados/this.minutosXSesion;
        //La fecha inicial de la primera franja es la hora de inicio de el calendario
        
        
        for (int i = 0; i < numFranjas; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.getFechaHoraInicio());
            //calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+this.minutosXSesion);
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+(i*minutosXSesion));
            Date date3 = calendar.getTime();
            Franja franja = new Franja(i+1, date3, null);
            arregloFranjas.add(franja);
        }
        return arregloFranjas;
    }
    
    
    
    
    
//
// int x = 600/45;
// double y = (int) x;
//        
//        System.out.println(x);
//        
//        ArrayList<Date> arr = new ArrayList<>();
//        Date date = new Date();
//        System.out.println(date);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        for (int i = 0; i < x; i++) {
//            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+45);
//            Date date3 = calendar.getTime();
//            System.out.println(i);
//            System.out.println(calendar.getTime());
//            arr.add(date3);
//        }
//        
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.println(i + ": " +arr.get(i));
//        }    
//    

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void SetFechaHoraInicio(Date horaInicio) {
        this.fechaHoraInicio = horaInicio;
    }

    public ArrayList<Franja> getFranjas() {
        return franjas;
    }

    public void setFranjas(ArrayList<Franja> franjas) {
        this.franjas = franjas;
    }

    public int getMinutosXSesion() {
        return minutosXSesion;
    }

    public void setMinutosXSesion(int minutosXSesion) {
        this.minutosXSesion = minutosXSesion;
    }

    public int getHorasLaboradas() {
        return horasLaboradas;
    }

    public void setHorasLaboradas(int horasLaboradas) {
        this.horasLaboradas = horasLaboradas;
    }

    
}
