package inventario.modelo;

/**
 * Clase que representa un producto del inventario del supermercado.
 * Autora: Danna Ramirez
 */
public class Producto {

    // Atributos
    private int    id;
    private String nombre;
    private String categoria;
    private double precio;
    private int    cantidad;

    // Constructor vacío
    public Producto() {}

    // Constructor con todos los campos
    public Producto(int id, String nombre, String categoria, double precio, int cantidad) {
        this.id        = id;
        this.nombre    = nombre;
        this.categoria = categoria;
        this.precio    = precio;
        this.cantidad  = cantidad;
    }

    // Constructor sin id (para insertar nuevos registros)
    public Producto(String nombre, String categoria, double precio, int cantidad) {
        this.nombre    = nombre;
        this.categoria = categoria;
        this.precio    = precio;
        this.cantidad  = cantidad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    // Método para mostrar el producto en consola
    @Override
    public String toString() {
        return String.format("| %-3d | %-20s | %-15s | $%-10.2f | %-8d |",
                id, nombre, categoria, precio, cantidad);
    }
}
