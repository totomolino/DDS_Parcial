package Business;

import Notificaciones.notificarStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nombre;
    String apellido;
    Usuario usuario;
    List<Alquiler> alquileres = new ArrayList<>();
    String telefono;
    List<notificarStrategy> formaNotificacion;

    public Cliente(String nombre, String apellido, Usuario usuario, String telefono, List<notificarStrategy> formaNotificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.telefono = telefono;
        this.formaNotificacion = formaNotificacion;
    }

    public void serNotificado() {

        for (int i = 0; i < formaNotificacion.size(); i++) {
            formaNotificacion.get(i).notificarA(usuario.email, telefono);
        }
    }


    public boolean tieneUsuario(Usuario unUsuario) {
        return usuario.mismoUsuarioOEmail(unUsuario.getNombreUsuario());
    }
}
