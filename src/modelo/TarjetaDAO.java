package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta es la clase TarjetaDAO, contiene los métodos para buscar y generar nuevas tarjetas.
 *
 * @author 2193000343.
 */
public class TarjetaDAO {

    /**
     * Este método sirve para insertar una nueva tarjeta en la tabla de la base
     * de datos.
     *
     * @param t es un parámetro de tipo tarjeta para recuper todos los datos a
     * insertar.
     * @return regresa un entero que se usa para la asignación de la tarjeta en
     * la tabla.
     */
    public int insertarTarjeta(Tarjeta t) {
        int result = 0;

        PreparedStatement stm = null;
        String sql = "insert into tarjeta (idTarjeta,numTarjeta,tipo,fecha,saldo) values(?,?,?,?,?)";

        Connection con = Conexion.init();

        try {
            stm = con.prepareStatement(sql);

            stm.setInt(1, t.getIdTarjeta());
            stm.setString(2, t.getNumTarjeta());
            stm.setInt(3, t.getTipo());
            stm.setDate(4, t.getFecha());
            stm.setDouble(5, t.getSaldo());

            result = stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    
    /**
     * Este método sirve para recuperar las tarjetas que se encuentran en la 
     * base de datos y deplegarlas en la tabla solicitada.
     *
     * @param num el número de tarjetas existentes en la base de datos.
     * @return regresa un ArrayList con todas las tarjetas existentes en la base de datos.
     */

    public ArrayList buscarTarjetas(int num) {
        ArrayList<Tarjeta> t = new ArrayList<Tarjeta>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select * from tarjeta where idTarjeta=? limit 1";

        Connection con = Conexion.init();

        for (int i = 1; i <= num; i++) {
            Tarjeta t2 = new Tarjeta();
            try {
                stm = con.prepareStatement(sql);
                stm.setInt(1, i);
                rs = stm.executeQuery();
                while (rs.next()) {
                    t2.setIdTarjeta(rs.getInt("idTarjeta"));
                    t2.setNumTarjeta(rs.getString("numTarjeta"));
                    t2.setTipo(rs.getInt("tipo"));
                    t2.setFecha(rs.getDate("fecha"));
                    t2.setSaldo(rs.getDouble("saldo"));
                }

                rs.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            t.add(t2);
        }

        return t;
    }

    /**
     * Este método sirve para buscar el último ID encontrado en la tabla 
     * y generar uno nuevo para registrar otra tarjeta.
     *
     * @return regresa un dato de tipo entero, que es el nuevo ID de la tabla.
     */
    public int buscarSiguienteId() {
        int id = 0;
        Tarjeta t = new Tarjeta();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select * from tarjeta order by idTarjeta desc limit 1";

        Connection con = Conexion.init();

        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                t.setIdTarjeta(rs.getInt("idTarjeta"));
                t.setNumTarjeta(rs.getString("numTarjeta"));
                t.setTipo(rs.getInt("tipo"));
                t.setFecha(rs.getDate("fecha"));
                t.setSaldo(rs.getDouble("saldo"));
            }
            id = t.getIdTarjeta() + 1;
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * Este método sirve para recuperar el número de filas que existen en la 
     * base de datos, el cual nos sirve para generar un nuevo ID para la siguiente tarjeta.
     * @return regresa el número de filas de la 
     * @throws Exception 
     */
    public int num() throws Exception {
        //para registrar el driver.
        int i;
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //para establecer la conexión.
        String mysqlUrl = "jdbc:mysql://****/pKjDbUYxIt?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con = DriverManager.getConnection(mysqlUrl, "****", "****");
        System.out.println("Conectado");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) from tarjeta");
        rs.next();
        i = rs.getInt("count(*)");
        
        return i;
    }

}
