package Notificaciones;

public class WHATSAPP extends notificarStrategy{

    @Override
    public void notificarA(String mensaje, String email, String telefono) {

        twilio.mandarWhatsapp(telefono, mensaje);


    }
}