package Business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paquete extends component {

    List<component> juegos;

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
}
