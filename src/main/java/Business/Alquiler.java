package Business;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

    public String mostrarJuegosAlquilados() {
       List<String> titulos = juegosAlquilados.mostrar();
       String titulosFinales = String.join(", ",titulos);
        return titulosFinales;
    }

    public double calcularPrecio() throws IOException {
        return juegosAlquilados.calcularPrecio();
    }

    public void mostrarAlquiler(int contador) {

        String estado = "OKAY";
        if(LocalDate.now().isAfter(fechaDeDevolucion))estado = "RETRASADO";

        System.out.println(contador + "- " + "fecha de retiro: " + fechaDeRetiro + " || fecha de devolucion: " + fechaDeDevolucion + " || juegos alquilados: " + this.mostrarJuegosAlquilados() + " || estado: " + estado);

        contador++;

    }

    public void serDevuelto() {
        juegosAlquilados.serDevuelto();

    }
}
