/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fagiraldo.fgutierrezf.proyecto.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Flexxo333
 */
public class PrincipalPage {
    
    private Scene scene;
    private GridPane topGpane1;
    private Text text1;
    private BorderPane bpane1;
    private Button changeSceneButton;
    private Button resetButton;
    private HBox hbox1;
    private VBox vbox1;
    private Label logo;
    private Label userImage;
    private GridPane centerGrid;
    private TextArea news;
    
    //Botones
    private Button pacientesButton;
    private Button citasButton;
    private Button agendaButton;
    private Button profesionalesButton;
    private Button proveedoresButton;
    private Button inventarioButton;

    public PrincipalPage() throws FileNotFoundException {
        bpane1 = new BorderPane();
        
        hbox1 = new HBox();
        pacientesButton = new Button("Pacientes");
        citasButton = new Button("Citas");
        agendaButton = new Button("Agenda");
        profesionalesButton = new Button("Profesionales");
        proveedoresButton = new Button("Proveedores");
        inventarioButton = new Button("Inventario");
        
        
        //Tamaño uniforme de los botnes
        int defaultGlobalButtonWidth = 135;
        pacientesButton.setMinWidth(defaultGlobalButtonWidth);
        citasButton.setMinWidth(defaultGlobalButtonWidth);
        agendaButton.setMinWidth(defaultGlobalButtonWidth);
        profesionalesButton.setMinWidth(defaultGlobalButtonWidth);
        proveedoresButton.setMinWidth(defaultGlobalButtonWidth);
        inventarioButton.setMinWidth(defaultGlobalButtonWidth);
        
        //Button font size
        int defaultButtonFontSize = 17;
        pacientesButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, defaultButtonFontSize));
        citasButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, defaultButtonFontSize));
        agendaButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, defaultButtonFontSize));
        profesionalesButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, defaultButtonFontSize));
        proveedoresButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, defaultButtonFontSize));
        inventarioButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, defaultButtonFontSize));
        
        //Agregar verticalmente
        vbox1 = new VBox(pacientesButton, citasButton, agendaButton, profesionalesButton,
            proveedoresButton, inventarioButton);
        
        //Elemento a la izquiera
        bpane1.setLeft(vbox1);
        //Espacio entre botones
        vbox1.setSpacing(20);
        
        topGpane1 = new GridPane();
        topGpane1.setPadding(new Insets(1, 1, 1, 1));
        
        FileInputStream logoInput = new FileInputStream("resources/img/533f7c18942a7801fe7effc436c07bcc_Logo.png");
        Image logoImg = new Image(logoInput);
        logo= new Label("", new ImageView(logoImg));
        text1 = new Text("Entidad de salud");
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(60);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);
        topGpane1.getColumnConstraints().addAll(col1, col2 , col3);
        topGpane1.add(logo, 0, 0, 2,1);
        topGpane1.add(text1, 1, 0);
        FileInputStream userImageInput = new FileInputStream("resources/img/if_user_female_172621.png");
        Image userImg = new Image(userImageInput);
        userImage= new Label("", new ImageView(userImg));
        topGpane1.add(userImage, 2, 0);
        
        //Center Grid
        centerGrid = new GridPane();
        centerGrid.setPadding(new Insets(10, 10, 10, 35));
        
        news = new TextArea("Las noticias");
        news.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        centerGrid.add(news, 0, 0);
        
        
        
        text1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        news.setMinWidth(1200);
        bpane1.setPadding(new Insets(20, 20, 10, 40));
        bpane1.setTop(topGpane1);
        bpane1.setCenter(centerGrid);
        
        
        scene = new Scene(bpane1, 1600, 950);   
    }
    
    
    
    public void show(Stage stage){
      stage.setTitle("Principal");
      stage.setScene(scene);
      stage.show();
    }
    
}
