import java.util.List;
import java.util.NoSuchElementException;

// Participante ConcreteIterator: entrega solo los platos vegetarianos
public class IteradorVegetariano implements IteradorPlato {
    private final List<Plato> platos;
    private int posicion = 0;

    public IteradorVegetariano(List<Plato> platos) {
        this.platos = platos;
    }

    @Override
    public boolean hasNext() {
        while (posicion < platos.size() && !platos.get(posicion).esVegetariano()) {
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
}
