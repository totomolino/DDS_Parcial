package Notificaciones;

public class EMAIL extends notificarStrategy{

    @Override
    public void notificarA(String mensaje, String email, String telefono) {
        twilio.mandarEmail(email, mensaje);
    }


}
