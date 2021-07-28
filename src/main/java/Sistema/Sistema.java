package Sistema;

import Business.JuegoSimple;
import Business.Usuario;
import Seguridad.Register;

import java.util.List;

public class Sistema {

    private static Sistema instancia;
    List<JuegoSimple> juegos;
    List<Usuario> usuarios;

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



}
