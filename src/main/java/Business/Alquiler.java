package Business;

import java.time.LocalDate;

public class Alquiler {
    LocalDate fechaDeRetiro;
    LocalDate fechaDeDevolucion;
    Component juegosAlquilados;

    public Alquiler(LocalDate fechaDeRetiro, LocalDate fechaDeEntrega, Component juegosAlquilados) {
        this.fechaDeRetiro = fechaDeRetiro;
        this.fechaDeDevolucion = fechaDeEntrega;
        this.juegosAlquilados = juegosAlquilados;
    }


    public LocalDate getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public boolean faltaUnDia() {
        return LocalDate.now().plusDays(1).equals(fechaDeDevolucion);
    }
}
