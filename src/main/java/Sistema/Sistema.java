package Sistema;

import Business.*;
import Notificaciones.notificarStrategy;
import Seguridad.Register;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {

    private static Sistema instancia = null;
    public static List<JuegoSimple> juegos;
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<Cliente>();

    //SINGLETON

    public static Sistema getInstance(){
        if(instancia == null){
            instancia = new Sistema();
        }
        return instancia;
    }

    public static boolean iniciarSesion(String usuarioOEmail, String contrasenia) {

        //Busco al usuario
        Usuario usuario = Sistema.buscarUsuario(usuarioOEmail);
        //Verifico con el usuario la contrasenia
        if(usuario == null){
         return false;
        }else {
            return usuario.verificarContrasenia(contrasenia); //Si devuelve true, la contrasenia es correcta, sino no xd
        }
    }



    public boolean validarContrasenia(String contrasenia, String usuario){
        return Register.validarContrasenia(contrasenia, usuario);
    }

    public List<JuegoSimple> mostrarJuegosDisponibles(){//Pide a la BD los juegos disponibles y los guarda en una lista para mostrar despues
        List<JuegoSimple>juegos = new ArrayList<>();
        return juegos;
    }

    public Usuario crearUsuario(String nombre, String contrasenia, String email){
        Usuario unUsuario = new Usuario(nombre, contrasenia, email);
        usuarios.add(unUsuario);
        return unUsuario;
    }

    public Alquiler crearAlquiler(List<String>juegosTitulos, int cantDias){
        Component componente;
        if(juegosTitulos.size() == 1){ //Si cargo un solo juego
            componente = new JuegoSimple(juegosTitulos.get(0), Estado.PRESTADO);
        }else{
            componente = new Paquete();
            juegosTitulos.forEach(juego -> ((Paquete) componente).add(new JuegoSimple(juego,Estado.PRESTADO)));
        }
        Alquiler unAlquiler = new Alquiler(LocalDate.now(), LocalDate.now().plusDays(cantDias), componente);

        return unAlquiler;
    }

    public void crearCliente(String nombre, String apellido, Usuario usuario, String telefono, List<notificarStrategy> formaNotificacion){
        Cliente unCliente = new Cliente(nombre, apellido, usuario, telefono, formaNotificacion);
        clientes.add(unCliente);
    }

    public boolean usuarioNoValido(String usuarioProvisorio) {
        return usuarios.stream().anyMatch(usuario -> usuario.getNombreUsuario().equals(usuarioProvisorio));
    }

    public boolean emailNoValido(String email) {
        return usuarios.stream().anyMatch(usuario -> usuario.getEmail().equals(email));
    }

    public static void mostrarUsuarios(){
        usuarios.forEach(usuario -> usuario.mostrarUsuario());
    }

    public Cliente buscarCliente(String usuarioOEmail) {

        Usuario unUsuario = Sistema.buscarUsuario(usuarioOEmail);
        Cliente unCliente = Sistema.buscarClienteConUsuario(unUsuario);
        return unCliente;
    }

    private static Cliente buscarClienteConUsuario(Usuario unUsuario) {
        return clientes.stream().filter(cliente -> cliente.tieneUsuario(unUsuario)).collect(Collectors.toList()).get(0);
    }

    private static Usuario buscarUsuario(String usuarioOEmail) {
        return usuarios.stream().filter(usuario -> usuario.mismoUsuarioOEmail(usuarioOEmail)).collect(Collectors.toList()).get(0);
    }
}
