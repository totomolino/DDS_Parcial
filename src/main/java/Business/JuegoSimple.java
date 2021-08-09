package Business;

import Business.Services.Api.apiGames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JuegoSimple extends Component {

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

    @Override
    public double calcularPrecio() throws IOException {
        return condicion.pagar();
    }

    @Override
    public void serAlquilado() {
        cambiarEstado(Estado.PRESTADO);
    }

    @Override
    public void serDevuelto() {
        cambiarEstado(Estado.STOCK);
    }

    @Override
    public void serRetrasado() {
        cambiarEstado(Estado.RETRASADO);
    }

    @Override
    public List<String> mostrar() {
        List<String> lista = new ArrayList<String>();
        lista.add(titulo);
        return lista;
    }

    public void cambiarCondicion(Condicion condicion){
        this.condicion = condicion;
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    public void usar() {
        this.cantUsos += 1;
    }

    public double pedirPrecio() throws IOException {//ACA LE PIDO A LA API EL PRECIO
        apiGames api = apiGames.getInstacia();
        return api.damePrecio(titulo);

    }
}
