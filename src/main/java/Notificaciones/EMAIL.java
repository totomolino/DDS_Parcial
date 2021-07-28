package Notificaciones;

public class EMAIL extends notificarStrategy{

    @Override
    public void notificarA(String email, String telefono) {
        twilio.mandarEmail(email, "DEVOLVE EL JUEGO GATO");
    }


}
