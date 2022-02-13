package modelo;

import java.sql.Date;

/**
 * Esta es la clase Tarjeta, en ella se declaran los atributos y métodos necesarios para generar objetos de tipo tarjeta.
 * @author 2193000343
 */
public class Tarjeta {
    /**
     * Este atributo nos ayuda a indicar el ID de la tarjeta.
     */
    private int idTarjeta;
    /**
     * Este atributo nos ayuda a indicar el número de la tarjeta.
     */
    private String numTarjeta;
    /**
     * Este atributo nos ayuda a indicar el tipo de la tarjeta 1 o 0.
     */
    private int tipo;
    /**
     * Este atributo nos ayuda a indicar la fecha de la tarjeta.
     */
    private Date fecha;
    /**
     * Este atributo nos ayuda a indicar el saldo de la tarjeta.
     */
    private double saldo;

    /**
     * Este es el método constructor por defecto de la clase Tarjeta.
     */
    public Tarjeta() {
    }

    /**
     * Este es el método constructor con parámetros de la clase tarjeta.
     * @param idTarjeta sirve para recibir un dato de tipo int y asignarlo como ID de la tarjeta.
     * @param numTarjeta sirve para recibir un dato de tipo String y asignarlo como número de la tarjeta.
     * @param tipo sirve para recibir un dato de tipo int y asignarlo como tipo de la tarjeta.
     * @param fecha sirve para recibir un dato de tipo Date y asignarlo como fecha de la tarjeta.
     * @param saldo sirve para recibir un dato de tipo double y asignarlo como saldo de la tarjeta.
     */
    public Tarjeta(int idTarjeta, String numTarjeta, int tipo, Date fecha, double saldo) {
        this.idTarjeta = idTarjeta;
        this.numTarjeta = numTarjeta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.saldo = saldo;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Es el método toString de la clase tarjeta
     * @return 
     */
    @Override
    public String toString() {
        return "Tarjeta{" + "idTarjeta=" + idTarjeta + ", numTarjeta=" +
                numTarjeta + ", tipo=" + tipo + ", fecha=" +
                fecha + ", saldo=" + saldo + '}';
    }
    
    
   
    
    
}
