package Business;

import java.sql.*;

import static Business.Conexion.newConnection;

public class JuegoDAO {

    private Connection conn;



    public int insert(String nombre, int edad) {
        String consulta = "INSERT INTO persona (nombre, edad) VALUES ('" + nombre + "'," + edad + ");";

        try {

            this.conn = newConnection();

            // Ejecución
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

            // obtener último id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }

    }

    public boolean updateActivo(int idJuego) {
        String consulta = "UPDATE juegoSimple SET activo = 0 WHERE id_juegoSimple = " + idJuego + ";";

        try {

            this.conn = newConnection();

            // Ejecución
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.executeUpdate();
            return true;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Update");
            return false;
        }
    }

    public boolean delete(int idPersona) {
        String consulta = "DELETE FROM persona WHERE id = " + idPersona + ";";

        try {

            this.conn = newConnection();

            // Ejecución
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.execute();
            return true;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Delete");
            return false;
        }

    }

}



