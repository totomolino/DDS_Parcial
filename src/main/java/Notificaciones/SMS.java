package Notificaciones;

public class SMS extends notificarStrategy {

    @Override
    public void notificarA(String mensaje, String email, String telefono) {
        twilio.mandarSMS(telefono, mensaje);
    }

}
