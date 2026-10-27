public class Plato {
    private final String nombre;
    private final double precio;
    private final boolean esVegetariano;

    public Plato(String nombre, double precio, boolean esVegetariano) {
        this.nombre = nombre;
        this.precio = precio;
        this.esVegetariano = esVegetariano;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean esVegetariano() {
        return esVegetariano;
    }
}
