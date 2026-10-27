import java.util.List;

// Participante ConcreteAggregate: platos del dia en una lista plana.
// El criterio del iterador se fija al crear el menu, porque crearIterador() no recibe parametros.
public class MenuLista implements MenuRestaurante {
    private final List<Plato> platos;
    private final boolean porPrecio;
    private final double precioMinimo;
    private final double precioMaximo;

    // Menu que crea un IteradorVegetariano
    public MenuLista(List<Plato> platos) {
        this.platos = platos;
        this.porPrecio = false;
        this.precioMinimo = 0;
        this.precioMaximo = 0;
    }

    // Menu que crea un IteradorPorPrecio
    public MenuLista(List<Plato> platos, double precioMinimo, double precioMaximo) {
        this.platos = platos;
        this.porPrecio = true;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
    }

    @Override
    public IteradorPlato crearIterador() {
        if (porPrecio) {
            return new IteradorPorPrecio(platos, precioMinimo, precioMaximo);
        }
        return new IteradorVegetariano(platos);
    }
}
