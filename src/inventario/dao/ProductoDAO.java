package inventario.dao;

import inventario.conexion.Conexion;
import inventario.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) que contiene todas las operaciones
 * CRUD sobre la tabla 'productos' usando JDBC.
 * Autora: Danna Ramirez
 */
public class ProductoDAO {

    // ─────────────────────────────────────────────────
    // CREATE - Insertar un nuevo producto
    // ─────────────────────────────────────────────────
    /**
     * Inserta un nuevo producto en la base de datos.
     * @param producto objeto Producto con los datos a guardar.
     */
    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, categoria, precio, cantidad) VALUES (?, ?, ?, ?)";

        Connection conexion = Conexion.obtenerConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4,    producto.getCantidad());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto insertado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }

    // ─────────────────────────────────────────────────
    // READ - Consultar todos los productos
    // ─────────────────────────────────────────────────
    /**
     * Retorna la lista completa de productos del inventario.
     * @return List con todos los productos.
     */
    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        Connection conexion = Conexion.obtenerConexion();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
        return lista;
    }

    // ─────────────────────────────────────────────────
    // READ - Buscar producto por ID
    // ─────────────────────────────────────────────────
    /**
     * Busca un producto específico por su ID.
     * @param id identificador del producto.
     * @return objeto Producto si existe, null si no.
     */
    public Producto buscarPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        Producto producto = null;

        Connection conexion = Conexion.obtenerConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad")
                );
            } else {
                System.out.println("No se encontró producto con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
        return producto;
    }

    // ─────────────────────────────────────────────────
    // UPDATE - Actualizar un producto
    // ─────────────────────────────────────────────────
    /**
     * Actualiza los datos de un producto existente.
     * @param producto objeto Producto con los datos nuevos (debe tener el ID).
     */
    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre=?, categoria=?, precio=?, cantidad=? WHERE id=?";

        Connection conexion = Conexion.obtenerConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4,    producto.getCantidad());
            ps.setInt(5,    producto.getId());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("No se encontró producto con ID: " + producto.getId());
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }

    // ─────────────────────────────────────────────────
    // DELETE - Eliminar un producto
    // ─────────────────────────────────────────────────
    /**
     * Elimina un producto de la base de datos por su ID.
     * @param id identificador del producto a eliminar.
     */
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        Connection conexion = Conexion.obtenerConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("No se encontró producto con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }
}
