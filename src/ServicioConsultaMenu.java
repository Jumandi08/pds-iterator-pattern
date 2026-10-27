// Participante Client: recorre cualquier menu sin saber si es lista o arbol
public class ServicioConsultaMenu {

    public void mostrarPlatos(MenuRestaurante menu) {
        IteradorPlato iterador = menu.crearIterador();
        while (iterador.hasNext()) {
            Plato plato = iterador.getNext();
            System.out.printf("- %s ($%.2f)%n", plato.getNombre(), plato.getPrecio());
        }
    }
}
