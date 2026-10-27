import java.util.List;

public class CategoriaPlato {
    private final String nombre;
    private final List<Plato> platos;
    private final List<CategoriaPlato> subcategorias;

    public CategoriaPlato(String nombre, List<Plato> platos, List<CategoriaPlato> subcategorias) {
        this.nombre = nombre;
        this.platos = platos;
        this.subcategorias = subcategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public List<CategoriaPlato> getSubcategorias() {
        return subcategorias;
    }
}
