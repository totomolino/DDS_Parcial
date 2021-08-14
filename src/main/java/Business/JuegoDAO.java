package Business;

import java.sql.*;

public class JuegoDAO {

    private Connection conn;

    public Connection newConnection(){
        Connection conn = null;
        try{
            String connectionUrl = "jdbc:mysql://localhost:3306/juegos";
            conn = DriverManager.getConnection(connectionUrl, "root", "");

            //hacer algo
            //System.out.println("Conexion realizada");

            return conn;

        }catch (SQLException ex){

            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;

        }
    }

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

    public boolean updateActivo(int idPersona) {
        String consulta = "UPDATE persona SET activo = 0 WHERE id = " + idPersona + ";";

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



