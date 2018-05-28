/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadsalud.test;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Flexxo333
 */
public class PaginaNumero2VC {
    
    private DataBean databean;
    private PaginaNumero2 view;
    
    public PaginaNumero2VC(DataBean databean) {
        this.databean = databean;
        this.view = new PaginaNumero2();
        
        view.getButtonGoBack().setOnAction(new buttonGoBackHandler());
    }
    
    public void show(){
        view.show(databean.getPrimaryStage());
    }

    public PaginaNumero2 getView() {
        return view;
    }
    
    class buttonGoBackHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            PaginaInicioVC paginaInicioVC = new PaginaInicioVC(databean);
            paginaInicioVC.show();
            paginaInicioVC.getView().getLabel1().setText("He regresado");
        }
    }
    
    
}
