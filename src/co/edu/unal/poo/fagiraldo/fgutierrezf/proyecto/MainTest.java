/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto;

import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.ArchivoExistenteEx;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.Calendario;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.Cita;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.Cliente;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.EntidadSalud;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.Especialidad;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.Profesional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Flexxo333
 */
public class MainTest {
    public static void main(String[] args) {
        
        /*
        Notes to self
        
        1) 
        */
        
        
        EntidadSalud ent = new EntidadSalud("Entidad");
        ent.registrarCliente(1233488863, "Fellhipe", "Gutierrez");
//        
//        for (int i = 0; i < ent.getClientes().size(); i++) {
//            System.out.println(ent.getClientes().get(i).info());
//        }
//        
        //int y,z, w;
        Scanner sc = new Scanner(System.in);
        
//        y=sc.nextInt();
//        z=sc.nextInt();
//        w=sc.nextInt();
//        
//        String x = ""+y+ "-"+z+"-"+w+"";
//        
//        System.out.println(x);
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy");
//	String dateInString = "25-05-1997 10:20:56";
////      
//
        //Calendario agenda = new Calendario(10, 5, 75, 8);
        
        //System.out.println("HORA INICIO: " +agenda.getFechaHoraInicio());
        
//        for (int i = 0; i < agenda.getFranjas().size(); i++) {
//            System.out.println(agenda.getFranjas().get(i).getFecha());
//        }
        ent.registrarEspecialidad(10, "Osteo");
        //Especialidad esp = new Especialidad(10, "Osteo");
        //Calendario(8, 0, 75, 8);
        //Calendario(int horaInicio, int minuto, int minutosXSesion, int horasLaboradas) {
        ent.registrarProfesional(265, "Fellhipe", "Gutierrez",
                10, 8,0,75,8);
        ent.registrarProfesional(120, "Fellhipe", "Gutierrez",
                10, 9,0,75,8);
        ent.registrarProfesional(180, "Fellhipe", "Gutierrez",
                10, 10,0,75,8);
        //Profesional prof1 = new Profesional(1233488863, "Fellhipe", "Gutierrez", true, esp, 8 ,0 ,75 ,8);
        
//        System.out.println("Profesional");
//        for (int i = 0; i < prof1.getAgenda().getFranjas().size(); i++) {
//            System.out.println(prof1.getAgenda().getFranjas().get(i).getFecha());
//        }
        
        ent.registrarCliente(24444, "Karina", "Ramirez");
        
        
        //Cliente client1 = new Cliente(24444, "Karina", "Ramirez", true);
        ent.registrarCita(24444, 265, 1);
        ent.registrarCita(24444, 265, 2);
        
        ent.registrarCita(24444, 120, 4);
        
        
//        for (int i = 0; i < ent.getProfesionales().size(); i++) {
////            for (int j = 0; j < ent.getProfesionales().get(i).getCitasAgendadas().size(); j++) {
////                System.out.println(ent.getProfesionales().get(i).getCitasAgendadas().get(j).info());
////            }
//            Profesional x = ent.getProfesionales().get(i);
////            for (int j = 0; j < x.getCitasAgendadas().size(); j++) {
////                System.out.println(x.getCitasAgendadas().get(j).info());
////            }
//            for (int j = 0; j < x.getAgenda().getFranjas().size(); j++) {
//                System.out.println(x.getAgenda().getFranjas().get(j).info());
//            }
//            
//        }

        System.out.println("Info franjas");
        for (int i = 0; i < ent.getProfesionales().size(); i++) {
            System.out.println(ent.getProfesionales().get(i).getCedula());
            System.out.println(ent.getProfesionales().get(i).getAgenda().info());
            for (int j = 0; j < ent.getProfesionales().get(i).getAgenda().getFranjas().size(); j++) {
            System.out.println(ent.getProfesionales().get(i).getAgenda().getFranjas().get(j).info());
        }
        }
        
//        
//        System.out.println(ent.getProfesionales().get(0).getAgenda().info());
//        
//        System.out.println(ent.getProfesionales().get(0).getAgenda().getFranjas().size());
        
//        for (int i = 0; i < prof1.getAgenda().getFranjas().size(); i++) {
//            if (prof1.getAgenda().getFranjas().get(i).getCita()!=null) {
//                System.out.println(prof1.getAgenda().getFranjas().get(i).info());
//            }
//            
//        }
        
//        Cita cita1 = new Cita(1, client1, prof1, prof1.getAgenda().getFranjas().get(1));
        //prof1.getAgenda().getFranjas().get(1).setCita(cita1);
        
        //System.out.println(cita1.info());
        
        //System.out.println(prof1.getAgenda().getFranjas().get(1).info());
        
        
///	Date date=null;
//        Date date2=null;
//        Date date3 = null;
//        try {
//            date = sdf.parse(dateInString);
//            date2 = sdf2.parse(dateInString);
//            date3 = sdf2.parse(x);
//        } catch (ParseException ex) {
//            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("sdf1");
//	System.out.println(date);
//        System.out.println("sdf2");
//        System.out.println(date2);
//        System.out.println("X");
//        System.out.println(date3);
        
        
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date2);
//        System.out.println("CALENDAR");
//        System.out.println(calendar.getTime());
//        
//        
        
//        
//        double x = 600.0/75.0;
//        int y = (int) x+1;
//        
//        System.out.println("x: " +x);
//        System.out.println("y:" +y);
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
    }
//    
}
