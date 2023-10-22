/**
 * Clase que representa un tipo específico de producto, una "Bebida", que hereda de la clase Producto.
 */
public class Bebida extends Producto {
    private int mililitros; // Cantidad de mililitros de la bebida.
    private String tipo; // Tipo de la bebida (por ejemplo, "Refresco", "Agua", etc.).

    /**
     * Constructor para crear un objeto Bebida.
     *
     * @param id Identificador único de la bebida.
     * @param nombre Nombre de la bebida.
     * @param cantidadDisponible Cantidad de unidades disponibles en el inventario de la bebida.
     * @param cantidadVendidos Cantidad de unidades vendidas de la bebida.
     * @param estado Estado de la bebida.
     * @param precio Precio de la bebida.
     * @param mililitros Cantidad de mililitros de la bebida.
     * @param tipo Tipo de la bebida.
     */
    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, int mililitros, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio); // Llama al constructor de la clase base Producto.
        this.mililitros = mililitros;
        this.tipo = tipo;
    }

    /**
     * Obtiene la cantidad de mililitros de la bebida.
     *
     * @return La cantidad de mililitros de la bebida.
     */
    public int getMililitros() {
        return mililitros;
    }

    /**
     * Establece la cantidad de mililitros de la bebida.
     *
     * @param mililitros La nueva cantidad de mililitros de la bebida.
     */
    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    /**
     * Obtiene el tipo de la bebida.
     *
     * @return El tipo de la bebida.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la bebida.
     *
     * @param tipo El nuevo tipo de la bebida.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Genera una representación de cadena del objeto Bebida, incluyendo información heredada de Producto.
     *
     * @return Una cadena que describe la bebida con su ID, nombre, cantidad disponible, cantidad vendida, estado, precio, mililitros y tipo.
     */
    @Override
    public String toString() {
        return super.toString() + "\nMililitros: " + mililitros + "\nTipo: " + tipo;
    }
}