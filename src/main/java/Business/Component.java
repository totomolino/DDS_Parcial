package Business;

import java.io.IOException;
import java.util.List;

public abstract class Component {

    public abstract double calcularPrecio() throws IOException;

    public abstract void serAlquilado();

    public abstract void serDevuelto();

    public abstract void serRetrasado();

    public abstract List<String> mostrar();


}
