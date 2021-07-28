package Business;

public abstract class Condicion {

    public JuegoSimple juegoSimple;

    public Condicion(JuegoSimple juego) {
        this.juegoSimple = juego;
    }

    public abstract double pagar();

    public JuegoSimple getJuegoSimple() {
        return juegoSimple;
    }
}
