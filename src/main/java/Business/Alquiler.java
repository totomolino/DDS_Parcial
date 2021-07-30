package Business;

public class Alquiler {
    String fechaDeRetiro;
    String fechaDeEntrega;
    component juegosAlquilados;

    public Alquiler(String fechaDeRetiro, String fechaDeEntrega, component juegosAlquilados) {
        this.fechaDeRetiro = fechaDeRetiro;
        this.fechaDeEntrega = fechaDeEntrega;
        this.juegosAlquilados = juegosAlquilados;
    }
}
