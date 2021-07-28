package Notificaciones;

public class WHATSAPP extends notificarStrategy{

    @Override
    public void notificarA(String email, String telefono) {

        twilio.mandarWhatsapp(telefono, "DEVOLVE EL JUEGO GATO");


    }
}