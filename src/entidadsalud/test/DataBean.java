/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadsalud.test;

import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class DataBean {
    
    private Stage primaryStage=null;

    public DataBean(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
    
}
