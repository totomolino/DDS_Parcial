package Business;

public class Usuario {
    String nombreUsuario;
    private String contrasenia;
    String email;

    public Usuario(String nombreUsuario, String contrasenia, String email) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void mostrarUsuario() {
        System.out.println("El nombre de usuario es: " + nombreUsuario);
        System.out.println("La contrasenia es: " + contrasenia);
        System.out.println("El mail es: " + email);
        System.out.println("__________________________________________________________________________");
    }

    public boolean mismoUsuarioOEmail(String usuarioOEmail) {
        return nombreUsuario.equals(usuarioOEmail) || email.equals(usuarioOEmail);
    }

    public boolean verificarContrasenia(String otraContrasenia) {
        return contrasenia.equals(otraContrasenia);
    }
}
