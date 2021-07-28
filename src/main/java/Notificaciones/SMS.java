package Notificaciones;

public class SMS extends notificarStrategy {

    @Override
    public void notificarA(String email, String telefono) {
        twilio.mandarSMS(telefono, "DEVOLVE EL JUEGO GATO");
    }

}
