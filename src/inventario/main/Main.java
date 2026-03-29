package inventario.main;

import inventario.dao.ProductoDAO;
import inventario.modelo.Producto;

import java.util.List;

/**
 * Clase principal que demuestra todas las operaciones CRUD
 * del sistema de inventario del supermercado.
 *
 * CÓMO PROBAR:
 * 1. Ejecutar el script SQL primero en MySQL.
 * 2. Correr esta clase desde NetBeans (clic derecho > Run File).
 * 3. Ver los resultados en la consola de NetBeans.
 *
 * Autora: Danna Ramirez
 */
public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // ────────────────────────────────────────────
        // 1. LISTAR todos los productos (READ)
        // ────────────────────────────────────────────
        System.out.println("\n========== LISTA DE PRODUCTOS ==========");
        System.out.println("| ID  | Nombre               | Categoria       | Precio      | Cantidad |");
        System.out.println("|-----|----------------------|-----------------|-------------|----------|");
        List<Producto> lista = dao.listarProductos();
        for (Producto p : lista) {
            System.out.println(p.toString());
        }

        // ────────────────────────────────────────────
        // 2. INSERTAR un nuevo producto (CREATE)
        // ────────────────────────────────────────────
        System.out.println("\n========== INSERTANDO PRODUCTO ==========");
        Producto nuevo = new Producto("Jabon de manos", "Aseo", 3500.00, 20);
        dao.insertarProducto(nuevo);

        // Listar para ver el nuevo producto
        System.out.println("\n--- Lista después de insertar ---");
        for (Producto p : dao.listarProductos()) {
            System.out.println(p.toString());
        }

        // ────────────────────────────────────────────
        // 3. BUSCAR un producto por ID (READ)
        // ────────────────────────────────────────────
        System.out.println("\n========== BUSCANDO PRODUCTO ID=1 ==========");
        Producto encontrado = dao.buscarPorId(1);
        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado.toString());
        }

        // ────────────────────────────────────────────
        // 4. ACTUALIZAR un producto (UPDATE)
        // ────────────────────────────────────────────
        System.out.println("\n========== ACTUALIZANDO PRODUCTO ID=1 ==========");
        Producto actualizado = new Producto(1, "Arroz 2kg", "Granos", 4800.00, 45);
        dao.actualizarProducto(actualizado);

        // Ver el cambio
        System.out.println("Producto después de actualizar:");
        System.out.println(dao.buscarPorId(1).toString());

        // ────────────────────────────────────────────
        // 5. ELIMINAR un producto (DELETE)
        // ────────────────────────────────────────────
        System.out.println("\n========== ELIMINANDO PRODUCTO ID=5 ==========");
        dao.eliminarProducto(5);

        // Lista final
        System.out.println("\n--- Lista final del inventario ---");
        System.out.println("| ID  | Nombre               | Categoria       | Precio      | Cantidad |");
        System.out.println("|-----|----------------------|-----------------|-------------|----------|");
        for (Producto p : dao.listarProductos()) {
            System.out.println(p.toString());
        }

        System.out.println("\n========== FIN DE LA PRUEBA CRUD ==========");
    }
}
