/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.controladores;

import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.DataBean;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.vista.PrincipalPage;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Flexxo333
 */

public class PrincipalVC {
    private DataBean databean;
    private PrincipalPage view;

    public PrincipalVC(DataBean databean){
        this.databean = databean;
        try {
            this.view = new PrincipalPage();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(PrincipalVC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Archivos de imagen no encontrados en pagina Principal");
            System.out.println("Archivo no encontrado:" +ex.getLocalizedMessage() + " revisar ruta");
        }
        
    }
    
    public void show(){
        view.show(databean.getPrimaryStage());
    }
    
}
