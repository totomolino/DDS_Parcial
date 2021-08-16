package Business;

import java.io.IOException;
import java.util.List;

public interface Component {

    double calcularPrecio() throws IOException;

    void serAlquilado();

    void serDevuelto();

    void serRetrasado();

    List<String> mostrar();


}
