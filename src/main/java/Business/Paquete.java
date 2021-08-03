package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Paquete extends Component {

    List<Component> juegos = new ArrayList<>();

    @Override
    public double calcularPrecio() {
        Stream<Double> precios  = juegos.stream().map(component -> component.calcularPrecio());
        return precios.mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public void serAlquilado() {
        juegos.forEach(component -> component.serAlquilado());
    }

    @Override
    public void serDevuelto() {
        juegos.forEach(component -> component.serDevuelto());
    }

    @Override
    public void serRetrasado() {
        juegos.forEach(component -> component.serRetrasado());
    }

    public void add(Component unComponente){
        juegos.add(unComponente);
    }

}
