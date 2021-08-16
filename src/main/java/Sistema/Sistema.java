package Sistema;

import Business.*;
import Notificaciones.SMS;
import Notificaciones.notificarStrategy;
import Seguridad.Register;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {

    private static Sistema instancia = null;
    public static List<JuegoSimple> juegos;
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<Cliente>();
    public static Usuario totoUser = new Usuario("totomolino","Totoeslaonda12", "totomolino@hotmail.com");
    static List<notificarStrategy>medios = Arrays.asList(new SMS());
    public static Cliente toto = new Cliente("tomas", "Molino", totoUser, "+541166070996", medios);
    {{
        //HARDCODEO MI USER Y CLIENTE
        usuarios.add(totoUser);
        clientes.add(toto);
    }}
    //public static List<Usuario> usuarios = Arrays.asList(totoUser);
    //public static List<Cliente> clientes = Arrays.asList(toto);


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

    public List<JuegoSimple> dameJuegosDisponibles(){//Pide a la BD los juegos disponibles y los guarda en una lista para mostrar despues
        juegosDAO juegosDAO = new juegosDAO();
        List<JuegoSimple> juegos = juegosDAO.selectTodosLosJuegosStock();
        return juegos;
    }

    public Usuario crearUsuario(String nombre, String contrasenia, String email){
        Usuario unUsuario = new Usuario(nombre, contrasenia, email);
        usuarios.add(unUsuario);
        return unUsuario;
    }
/*
    public Alquiler crearAlquilerViejo(List<String>juegosTitulos, int cantDias){
        Component componente;
        if(juegosTitulos.size() == 1){ //Si cargo un solo juego
            componente = new JuegoSimple(juegosTitulos.get(0), Estado.PRESTADO, "Nuevo", 0, 0);
        }else{
            componente = new Paquete();
            juegosTitulos.forEach(juego -> ((Paquete) componente).add(new JuegoSimple(juego,Estado.PRESTADO, "Nuevo", 0, 0)));
        }
        Alquiler unAlquiler = new Alquiler(LocalDate.now(), LocalDate.now().plusDays(cantDias), componente);

        return unAlquiler;
    }*/

    public Alquiler crearAlquiler(List<JuegoSimple>juegosTitulos, int cantDias){
         Alquiler unAlquiler;
        if(juegosTitulos.size() == 1){ //Si cargo un solo juego
            Component componente = juegosTitulos.get(0);
            unAlquiler = new Alquiler(LocalDate.now(), LocalDate.now().plusDays(cantDias), componente);
        }else{
            Paquete paquete = new Paquete();
            juegosTitulos.forEach(juegoSimple -> paquete.add(juegoSimple));
            unAlquiler = new Alquiler(LocalDate.now(), LocalDate.now().plusDays(cantDias), paquete);
        }

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
        List<Usuario> lista = usuarios.stream().filter(usuario -> usuario.mismoUsuarioOEmail(usuarioOEmail)).collect(Collectors.toList());
        if(lista.isEmpty())return null;
        else return lista.get(0);
    }

    public void avisarFechaDevolucion() {

        //Primero filtro los que estan a un dia de la fecha

        List<Cliente> clientesPorDevolver = clientes.stream().filter(cliente -> cliente.tieneQueDevolver()).collect(Collectors.toList());

        clientesPorDevolver.forEach(cliente -> cliente.avisarDevolucion());


    }

    public List<String> dameTitulos(List<JuegoSimple> juegos){

        List<String> titulos = juegos.stream().map(juego -> juego.getTitulo()).collect(Collectors.toList());

        return titulos;

    }

}
