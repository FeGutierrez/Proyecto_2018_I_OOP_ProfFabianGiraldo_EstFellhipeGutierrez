/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadsalud.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Flexxo333
 */
public class PaginaInicioVC {
    
    private DataBean databean;
    private PaginaInicio view;

    public PaginaInicioVC(DataBean databean) {
        this.databean = databean;
        this.view = new PaginaInicio();
        
        view.getChangeSceneButton().setOnAction(new changeSceneEventHandler());
        view.getResetButton().setOnAction(new resetSceneButtonHandler());
    }
    
    public void show(){
        view.show(databean.getPrimaryStage());
    }
    
    class changeSceneEventHandler implements EventHandler<ActionEvent>{
        
        @Override
        public void handle(ActionEvent e){
            PaginaNumero2VC paginaNumero2 = new PaginaNumero2VC(databean);
            
            paginaNumero2.show();
            paginaNumero2.getView().getLabel1().setText("He cambiado");
        }
    }
    
    class resetSceneButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            PaginaInicioVC inicio = new PaginaInicioVC(databean);
            inicio.show();
        }
    }
    
    ObjectOutputStream output = null;
    
    File archivoPrueba = new File("Carpeta Test/Pruebas-Juego.txt");
    
    class registerButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            //PaginaInicioVC inicio = new PaginaInicioVC(databean);
            
            String name = view.getTextField1().getText();;
            String sname = view.getTextField2().getText();
            ClienteT client = new ClienteT(name, sname);
            try {
                output = new ObjectOutputStream(new FileOutputStream(archivoPrueba));
                output.writeObject(client);
            } catch (Exception ex) {
                System.out.println("Archivo no existe");
            }
            
            
        }
    }

    

    public PaginaInicio getView() {
        return view;
    }
    
    
    
}
