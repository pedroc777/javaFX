package modelo;

import java.sql.*;

/**
 * Esta es la clase Conexión, aquí se establece el método necesario para hacer
 * la conexión con la base de datos.
 *
 * @author pedro
 */
public class Conexion {

    /**
     * Este es el método constructor por defecto de la clase Conexión
     */
    public Conexion() {
    }

    /**
     * Este es el método estático que nos sirve para generar la conexión 
     * con la base de datos. Es la misma para todas las instancias.
     * @return regresa un dato de tipo Connection, que es la conexión a la base.
     */
    public static Connection init() {
        Connection con = null;
        String host = "****";
        String bd = "****";
        String password = "****";
        String usuario = "****";
        String url = "jdbc:mysql://" + host + "/" + bd + "?user=" + usuario + "&password=" + password;
        try {
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}
