package Business;

import java.io.IOException;

public abstract class Condicion {

    public JuegoSimple juegoSimple;

    public Condicion(JuegoSimple juego) {
        this.juegoSimple = juego;
    }

    public abstract double pagar() throws IOException;

    public JuegoSimple getJuegoSimple() {
        return juegoSimple;
    }
}
