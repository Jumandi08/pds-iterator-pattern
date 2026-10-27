import java.util.ArrayList;
import java.util.List;

// Participante ConcreteAggregate: carta permanente en un arbol de categorias.
// El criterio del iterador se fija al crear el menu, porque crearIterador() no recibe parametros.
public class MenuArbol implements MenuRestaurante {
    private final CategoriaPlato raiz;
    private final boolean porPrecio;
    private final double precioMinimo;
    private final double precioMaximo;

    // Menu que crea un IteradorVegetariano
    public MenuArbol(CategoriaPlato raiz) {
        this.raiz = raiz;
        this.porPrecio = false;
        this.precioMinimo = 0;
        this.precioMaximo = 0;
    }

    // Menu que crea un IteradorPorPrecio
    public MenuArbol(CategoriaPlato raiz, double precioMinimo, double precioMaximo) {
        this.raiz = raiz;
        this.porPrecio = true;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
    }

    @Override
    public IteradorPlato crearIterador() {
        List<Plato> platos = new ArrayList<>();
        recolectar(raiz, platos);
        if (porPrecio) {
            return new IteradorPorPrecio(platos, precioMinimo, precioMaximo);
        }
        return new IteradorVegetariano(platos);
    }

    // Recorre el arbol en profundidad; los iteradores no necesitan conocer esta estructura
    private void recolectar(CategoriaPlato categoria, List<Plato> platos) {
        platos.addAll(categoria.getPlatos());
        for (CategoriaPlato subcategoria : categoria.getSubcategorias()) {
            recolectar(subcategoria, platos);
        }
    }
}
