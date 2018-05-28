/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadsalud.test;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class PaginaInicio {
    
    private Scene scene;
    private Label label1;
    private GridPane grid1;
    private Button changeSceneButton;
    private Button resetButton;
    
    private TextField textField1;
    private TextField textField2;
    private Button registerButton;
    private Button consultarButton;

    public PaginaInicio() {
        label1 = new Label("Soy una prueba");
        changeSceneButton = new Button("Click me");
        resetButton = new Button("Jajajaja");
        textField1 = new TextField();
        textField2 = new TextField();
        registerButton = new Button("Registrar");
        consultarButton = new Button("Consultar");
        
        grid1 = new GridPane();
        grid1.add(label1, 0, 0);
        
        grid1.add(changeSceneButton, 1, 0);
        grid1.add(resetButton, 2, 0);
        grid1.add(textField1, 1, 1);
        grid1.add(textField2, 2, 1);
        grid1.add(registerButton, 2, 2);
        grid1.add(consultarButton, 2, 3);
        
        scene = new Scene(grid1, 300, 300);        
    }
    
    public void show(Stage stage){
      stage.setTitle("Pruebas cambio escenas");
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

    public GridPane getGrid1() {
        return grid1;
    }

    public void setGrid1(GridPane grid1) {
        this.grid1 = grid1;
    }

    public Button getChangeSceneButton() {
        return changeSceneButton;
    }

    public void setChangeSceneButton(Button changeSceneButton) {
        this.changeSceneButton = changeSceneButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public void setResetButton(Button resetButton) {
        this.resetButton = resetButton;
    }

    public TextField getTextField1() {
        return textField1;
    }

    public void setTextField1(TextField textField1) {
        this.textField1 = textField1;
    }

    public TextField getTextField2() {
        return textField2;
    }

    public void setTextField2(TextField textField2) {
        this.textField2 = textField2;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }
    
    
    
    
}
