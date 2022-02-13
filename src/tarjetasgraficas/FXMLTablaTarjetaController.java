/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarjetasgraficas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import modelo.Tarjeta;
import modelo.TarjetaDAO;

/**
 * FXML Controller class, es la clase que nos ayuda a implementar los métodos 
 * insertar una tarjeta en una base de datos a partir de un formulario.
 * @author pedro
 */
public class FXMLTablaTarjetaController implements Initializable {
    
    @FXML
    private TableView<Tarjeta> tablaTarjeta;
    @FXML
    private ObservableList<Tarjeta> listaTarjetas;
    
    
   
    /**
     * Este método nos ayuda a mostrar los datos encontrados en una base de 
     * datos en una tabla.
     */ 
    @FXML
    public void muestraTabla() throws Exception {
        listaTarjetas = FXCollections.observableArrayList();
        TarjetaDAO t1 = new TarjetaDAO();
        TarjetaDAO t2 = new TarjetaDAO();
        ArrayList<Tarjeta> t = new ArrayList<Tarjeta>();
        int j;
        j = t2.num();
        t = t1.buscarTarjetas(j);

        for(int i = 0; i < j; i++){
            listaTarjetas.add(t.get(i));
        }
        
        tablaTarjeta.setItems(listaTarjetas);//Incluyelalistaenlosregistrosdelatabal*/
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            muestraTabla();
        } catch (Exception ex) {
            Logger.getLogger(FXMLTablaTarjetaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
