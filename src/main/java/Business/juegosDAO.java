package Business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Business.Conexion.newConnection;

public class juegosDAO {

    private List<JuegoSimple> personas;
    private Connection conn;


    public List<JuegoSimple> selectTodosLosJuegosStock() {

        try {

            // generacion de query
            String consulta = "SELECT * FROM juegosimple WHERE estado = 'STOCK'";

            // Conexión
            this.conn = newConnection();

            // Ejecución
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada línea retornada
            List<JuegoSimple> juegos = new ArrayList<>();

            while (rs.next()) {

                // get titulo
                String titulo = rs.getString("titulo");

                // get condicion

                String condicion = rs.getString("condicion");

                // get cantUsos

                int cantUsos = rs.getInt("cantUsos");

                // get id

                int id = rs.getInt("id_juegoSimple");

                JuegoSimple unJuego = new JuegoSimple(titulo,Estado.STOCK, condicion, cantUsos, id);


                juegos.add(unJuego);
            }

            return juegos;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }

}
