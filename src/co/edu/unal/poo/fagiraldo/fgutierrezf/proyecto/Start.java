/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto;

import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.modelo.DataBean;
import co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.controladores.PrincipalVC;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class Start extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        DataBean dataBean = new DataBean(primaryStage);
        PrincipalVC principalVC = new PrincipalVC(dataBean);
        principalVC.show();
    }
}
