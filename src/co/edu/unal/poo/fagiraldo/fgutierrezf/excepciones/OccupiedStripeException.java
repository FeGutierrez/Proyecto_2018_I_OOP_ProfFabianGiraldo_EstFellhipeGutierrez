/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.excepciones;

/**
 *
 * @author Flexxo333
 */
public class OccupiedStripeException extends Exception{

    public OccupiedStripeException() {
        super("Franja ya cuenta con cita asignada");
    }
    
    
}
