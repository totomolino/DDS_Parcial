package Business;

import java.time.LocalDate;

public class Alquiler {
    LocalDate fechaDeRetiro;
    LocalDate fechaDeEntrega;
    Component juegosAlquilados;

    public Alquiler(LocalDate fechaDeRetiro, LocalDate fechaDeEntrega, Component juegosAlquilados) {
        this.fechaDeRetiro = fechaDeRetiro;
        this.fechaDeEntrega = fechaDeEntrega;
        this.juegosAlquilados = juegosAlquilados;
    }


    public LocalDate getFechaDeEntrega() {
        return fechaDeEntrega;
    }
}
