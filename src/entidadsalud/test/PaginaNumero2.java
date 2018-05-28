/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadsalud.test;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class PaginaNumero2 {
    private Scene scene;
    private Label label1;
    private GridPane gpane1;
    private Button buttonGoBack;

    public PaginaNumero2() {
        label1 = new Label();
        gpane1 = new GridPane();
        buttonGoBack = new Button("Take me back!");
        gpane1.add(label1, 0, 0);
        gpane1.add(buttonGoBack, 1, 0);
        scene = new Scene(gpane1, 400, 400);
        
    }
    
    public void show(Stage stage){
        stage.setTitle("Escena 2");
        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public GridPane getGpane1() {
        return gpane1;
    }

    public void setGpane1(GridPane gpane1) {
        this.gpane1 = gpane1;
    }

    public Button getButtonGoBack() {
        return buttonGoBack;
    }

    public void setButtonGoBack(Button buttonGoBack) {
        this.buttonGoBack = buttonGoBack;
    }
    
    
    
}
