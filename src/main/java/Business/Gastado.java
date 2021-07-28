package Business;

public class Gastado extends Condicion{

    public Gastado(JuegoSimple juego) {
        super(juego);
    }

    @Override
    public double pagar() {

        double precio = juegoSimple.pedirPrecio();

        double precioFinal = (precio - (precio*0.1));

        return precioFinal;
    }
}
