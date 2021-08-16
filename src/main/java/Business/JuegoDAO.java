package Business;

import java.sql.*;

import static Business.Conexion.newConnection;

public class JuegoDAO {

    private Connection conn;




    public boolean alquilarJuego(int idJuego, Estado estado) {

        String nuevoEstado = null;

        if(estado == Estado.PRESTADO) nuevoEstado = "PRESTADO";
        if(estado == Estado.STOCK) nuevoEstado = "STOCK";
        if(estado == Estado.RETRASADO) nuevoEstado = "RETRASADO";

        String consulta = "UPDATE juegosimple SET estado = '" + nuevoEstado + "' WHERE id_juegoSimple = " + idJuego + ";";

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


    public boolean usarJuego(int idJuego, int cantUsos) {
        String consulta = "UPDATE juegosimple SET cantUsos = " + cantUsos + " WHERE id_juegoSimple = " + idJuego + ";";

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

    public boolean gastarJuego(int idJuego) {

        String consulta = "UPDATE juegosimple SET condicion = 'Gastado' WHERE id_juegoSimple = " + idJuego + ";";

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
}



