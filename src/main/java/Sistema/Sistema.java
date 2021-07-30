package Sistema;

import Business.JuegoSimple;
import Business.Usuario;
import Seguridad.Register;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private static Sistema instancia = null;
    List<JuegoSimple> juegos;
    List<Usuario> usuarios = new ArrayList<>();

    //SINGLETON

    public static Sistema getInstance(){
        if(instancia == null){
            instancia = new Sistema();
        }
        return instancia;
    }

    public boolean validarContrasenia(String contrasenia, String usuario){
        return Register.validarContrasenia(contrasenia, usuario);
    }

    public void mostrarJuegosDisponibles(){//Pide a la BD los juegos disponibles y los muestra

    }

    public void crearUsuario(String nombre, String contrasenia, String email){
        Usuario unUsuario = new Usuario(nombre, contrasenia, email);
        usuarios.add(unUsuario);
    }




}
