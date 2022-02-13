/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarjetasgraficas;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Tarjeta;
import modelo.TarjetaDAO;

/**
 * FXML Controller class, es la clase que nos ayuda a implementar los métodos 
 * insertar una tarjeta en una base de datos a partir de un formulario.
 *
 * @author pedro
 */
public class FXMLInsertarTarjetaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    /**
     * Este atributo sirve para identificar al botón
     */
    @FXML
    private Label etiquetaObjetivo;
    
    /**
     * Estre atributo nos permite recuperar el número de la tarjeta a insertar.
     */
    @FXML
    private TextField numTarjeta;
    
    /**
     * Estre atributo nos permite recuperar el anio de la fecha de la tarjeta insertar.
     */
    @FXML
    private TextField anio;
    
    /**
     * Estre atributo nos permite recuperar el mes de la fecha de la tarjeta insertar.
     */
    @FXML
    private TextField mes;
    
    /**
     * Estre atributo nos permite recuperar el dia de la fecha de la tarjeta insertar.
     */
    @FXML
    private TextField dia;
    
    /**
     * Estre atributo nos permite recuperar el saldo de la fecha de la tarjeta insertar.
     */
    @FXML
    private TextField saldo;
    
    /**
     * Este atributo nos permite recuperar el saldo de la tarjeta insertar.
     */
    @FXML
    private TextField tipo;
    
    /**
     * Este método nos ayuda a recuperar los datos introducidos en el formulario 
     * y a asignarlos a una nueva tarjeta en la base de datos.
     * @param event 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Tarjeta t = new Tarjeta();
        TarjetaDAO t2 = new TarjetaDAO();
        TarjetaDAO t3 = new TarjetaDAO();
        int a,m,y;
        int k;
        
        k = t3.buscarSiguienteId();
        t.setIdTarjeta(k);
        t.setNumTarjeta(numTarjeta.getText());
        a = Integer.parseInt(anio.getText());
        m = Integer.parseInt(mes.getText());
        y = Integer.parseInt(dia.getText());
        Date d = new Date(a, m, y);
        t.setFecha(d);
        t.setSaldo(Double.parseDouble(saldo.getText()));
        t.setTipo(Integer.parseInt(tipo.getText()));
        System.out.println(t.toString());
        t2.insertarTarjeta(t);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
