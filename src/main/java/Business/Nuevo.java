package Business;

import java.io.IOException;

public class Nuevo extends Condicion {


    public Nuevo(JuegoSimple juego) {
        super(juego);
    }

    @Override
    public double pagar() throws IOException {
        //Le pido a la api el precio
        double precio = juegoSimple.pedirPrecio();

        juegoSimple.usar();

        if(juegoSimple.cantUsos == 4){
            juegoSimple.cambiarCondicion(new Gastado(juegoSimple));
        }


        return precio;
    }
}
