package inventario.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos MySQL mediante JDBC.
 * Autora: Danna Ramirez
 */
public class Conexion {

    // Datos de conexión - ajustar si tu contraseña de MySQL es diferente
    private static final String URL      = "jdbc:mysql://localhost:3306/inventario_supermercado";
    private static final String USUARIO  = "root";
    private static final String CLAVE    = "root"; // <-- cambia esto por tu contraseña MySQL

    /**
     * Abre y retorna una conexión a la base de datos.
     * @return objeto Connection listo para usar.
     */
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Crear la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver MySQL no encontrado. Agrega el JAR a las dependencias.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }

    /**
     * Cierra una conexión de forma segura.
     * @param conexion la conexión a cerrar.
     */
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
