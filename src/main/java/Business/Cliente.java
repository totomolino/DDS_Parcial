package Business;

import Notificaciones.notificarStrategy;

import java.util.List;

public class Cliente {
    String nombre;
    String apellido;
    Usuario usuario;
    Alquiler alquileres;
    String telefono;
    List<notificarStrategy> formaNotificacion;

    public void serNotificado() {

        for (int i = 0; i < formaNotificacion.size(); i++) {
            formaNotificacion.get(i).notificarA(usuario.email, telefono);
        }
    }

    

}
