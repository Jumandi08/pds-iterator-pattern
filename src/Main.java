import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Platos del dia (lista plana)
        List<Plato> platosDelDia = List.of(
                new Plato("Locro de papa", 4.50, true),
                new Plato("Seco de pollo", 6.00, false),
                new Plato("Tortilla de verde", 3.75, true),
                new Plato("Encebollado", 5.50, false));

        // Carta permanente (arbol de categorias)
        CategoriaPlato sopas = new CategoriaPlato("Sopas", List.of(
                new Plato("Crema de zapallo", 3.50, true),
                new Plato("Caldo de gallina", 5.00, false)), List.of());
        CategoriaPlato carnes = new CategoriaPlato("Carnes", List.of(
                new Plato("Lomo saltado", 9.50, false),
                new Plato("Churrasco", 11.00, false)), List.of());
        CategoriaPlato entradas = new CategoriaPlato("Entradas", List.of(
                new Plato("Empanada de queso", 2.00, true)), List.of(sopas));
        CategoriaPlato platosFuertes = new CategoriaPlato("Platos fuertes", List.of(
                new Plato("Llapingachos", 7.00, true)), List.of(carnes));
        CategoriaPlato postres = new CategoriaPlato("Postres", List.of(
                new Plato("Helado de paila", 2.50, true)), List.of());
        CategoriaPlato carta = new CategoriaPlato("Carta", List.of(),
                List.of(entradas, platosFuertes, postres));

        ServicioConsultaMenu servicio = new ServicioConsultaMenu();

        System.out.println("Platos del dia vegetarianos (lista):");
        servicio.mostrarPlatos(new MenuLista(platosDelDia));

        System.out.println("Platos del dia entre $4 y $6 (lista):");
        servicio.mostrarPlatos(new MenuLista(platosDelDia, 4, 6));

        System.out.println("Carta vegetariana (arbol):");
        servicio.mostrarPlatos(new MenuArbol(carta));

        System.out.println("Carta entre $5 y $10 (arbol):");
        servicio.mostrarPlatos(new MenuArbol(carta, 5, 10));
    }
}
