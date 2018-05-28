/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadsalud.test;

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
        PaginaInicioVC paginaInicioVC = new PaginaInicioVC(dataBean);
        paginaInicioVC.show();
    }
}
