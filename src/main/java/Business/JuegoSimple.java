package Business;

public class JuegoSimple {

    String titulo;
    Estado estado;
    Condicion condicion;
    int cantUsos;
    //int precio;


    public JuegoSimple(String titulo, Estado estado) {
        this.titulo = titulo;
        this.estado = estado;
        this.condicion = new Nuevo(this);//Se crea en nuevo
        this.cantUsos = 0;//0 usos
    }

    public double calcularPrecio(){
        return condicion.pagar();
    }

    public void cambiarCondicion(Condicion condicion){
        this.condicion = condicion;
    }


    public void usar() {
        this.cantUsos += 1;
    }

    public double pedirPrecio() {//ACA LE PIDO A LA API EL PRECIO
        return 0;
    }
}
