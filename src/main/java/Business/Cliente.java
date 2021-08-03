package Business;

import Notificaciones.notificarStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void serNotificado(String mensaje) {

        for (int i = 0; i < formaNotificacion.size(); i++) {
            formaNotificacion.get(i).notificarA(mensaje, usuario.email, telefono);
        }
    }

    public void notificarDevolucion(Alquiler unAlquiler){

        String mensaje = "Mañana " + unAlquiler.getFechaDeDevolucion() + " tienes que devolver los juegos " + unAlquiler.juegosAlquilados + ", Saludos!! :)";

        this.serNotificado(mensaje);

    }


    public boolean tieneUsuario(Usuario unUsuario) {
        return usuario.mismoUsuarioOEmail(unUsuario.getNombreUsuario());
    }

    public boolean tieneQueDevolver() {//Si alguno de sus alquileres se entrega maniana

        return alquileres.stream().anyMatch(alquiler -> alquiler.faltaUnDia());

    }

    public void avisarDevolucion() {

        List<Alquiler>alquileresPorVencer = alquileres.stream().filter(alquiler -> alquiler.faltaUnDia()).collect(Collectors.toList());

        alquileresPorVencer.forEach(alquiler -> this.notificarDevolucion(alquiler));

    }

    public void addAlquiler(Alquiler unAlquiler) {
        alquileres.add(unAlquiler);
    }
}
