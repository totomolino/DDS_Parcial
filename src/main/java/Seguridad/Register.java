package Seguridad;

public class Register {


    public static boolean validarContrasenia(String contrasenia, String usuario){

        return Reglas.cumpleLasReglas(contrasenia,usuario);

    }



}
