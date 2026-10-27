import java.util.List;
import java.util.NoSuchElementException;

// Participante ConcreteIterator: entrega solo los platos con precio entre minimo y maximo
public class IteradorPorPrecio implements IteradorPlato {
    private final List<Plato> platos;
    private final double precioMinimo;
    private final double precioMaximo;
    private int posicion = 0;

    public IteradorPorPrecio(List<Plato> platos, double precioMinimo, double precioMaximo) {
        if (precioMinimo < 0 || precioMaximo < precioMinimo) {
            throw new IllegalArgumentException("Rango de precios no valido: " + precioMinimo + " - " + precioMaximo);
        }
        this.platos = platos;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
    }

    @Override
    public boolean hasNext() {
        while (posicion < platos.size() && !estaEnRango(platos.get(posicion))) {
            posicion++;
        }
        return posicion < platos.size();
    }

    @Override
    public Plato getNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return platos.get(posicion++);
    }

    private boolean estaEnRango(Plato plato) {
        return plato.getPrecio() >= precioMinimo && plato.getPrecio() <= precioMaximo;
    }
}
