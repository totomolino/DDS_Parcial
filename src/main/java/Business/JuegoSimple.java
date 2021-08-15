package Business;

import Business.Services.Api.apiGames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JuegoSimple extends Component {
    int id;
    String titulo;
    Estado estado;
    Condicion condicion;
    int cantUsos;
    //int precio;


    public JuegoSimple(String titulo, Estado estado, String condicion, int cantUsos, int id) {
        this.titulo = titulo;
        this.estado = estado;

        if(condicion.equalsIgnoreCase("Nuevo"))this.condicion = new Nuevo(this);//Se crea en nuevo
        else this.condicion = new Gastado(this);//Se crea en Gastado

        this.cantUsos = cantUsos;
        this.id = id;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public void setCantUsos(int cantUsos) {
        this.cantUsos = cantUsos;
    }

    public String getTitulo() {
        return titulo;
    }
}
