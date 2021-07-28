package Seguridad;

public class Reglas {


    public static boolean cumpleLasReglas(String contrasenia, String usuario) {

        return Reglas.cumpleLargo(contrasenia)&&
               Reglas.cumpleReglasSintacticas(contrasenia)&&
               Reglas.usuarioYContraDistintos(contrasenia, usuario);

    }

    static boolean cumpleLargo(String unaContrasenia) {

        int longitud = unaContrasenia.length();

        return (8 <= longitud && longitud <= 30);
    }

    static boolean usuarioYContraDistintos(String unaContrasenia, String unUsuario) {
        return !(unUsuario.equals(unaContrasenia));
    }

    static boolean cumpleReglasSintacticas(String unaContrasenia) {
        char clave;
        int contNumero = 0, contLetraMay = 0, contLetraMin = 0;

        for (int i = 0; i < unaContrasenia.length(); i++) {
            clave = unaContrasenia.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[A-Z]")) {
                contLetraMay++;
            } else if (passValue.matches("[a-z]")) {
                contLetraMin++;
            } else if (passValue.matches("[0-9]")) {
                contNumero++;
            }
        }

        return (contNumero != 0) && (contLetraMay != 0) && (contLetraMin != 0);
    }

}
