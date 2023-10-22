/**
 * Clase que representa un tipo específico de producto, un "Snack", que hereda de la clase Producto.
 */
public class Snack extends Producto {
    private int gramos; // Cantidad de gramos del snack.
    private String sabor; // Sabor del snack.
    private String tamaño; // Tamaño del snack (por ejemplo, "Pequeño", "Grande", etc.).

    /**
     * Constructor para crear un objeto Snack.
     *
     * @param id Identificador único del snack.
     * @param nombre Nombre del snack.
     * @param cantidadDisponible Cantidad de unidades disponibles en el inventario del snack.
     * @param cantidadVendidos Cantidad de unidades vendidas del snack.
     * @param estado Estado del snack.
     * @param precio Precio del snack.
     * @param gramos Cantidad de gramos del snack.
     * @param sabor Sabor del snack.
     * @param tamaño Tamaño del snack.
     */
    public Snack(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, int gramos, String sabor, String tamaño) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio); // Llama al constructor de la clase base Producto.
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    /**
     * Obtiene la cantidad de gramos del snack.
     *
     * @return La cantidad de gramos del snack.
     */
    public int getGramos() {
        return gramos;
    }

    /**
     * Establece la cantidad de gramos del snack.
     *
     * @param gramos La nueva cantidad de gramos del snack.
     */
    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    /**
     * Obtiene el sabor del snack.
     *
     * @return El sabor del snack.
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * Establece el sabor del snack.
     *
     * @param sabor El nuevo sabor del snack.
     */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    /**
     * Obtiene el tamaño del snack.
     *
     * @return El tamaño del snack.
     */
    public String getTamaño() {
        return tamaño;
    }

    /**
     * Establece el tamaño del snack.
     *
     * @param tamaño El nuevo tamaño del snack.
     */
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Genera una representación de cadena del objeto Snack, incluyendo información heredada de Producto.
     *
     * @return Una cadena que describe el snack con su ID, nombre, cantidad disponible, cantidad vendida, estado, precio, gramos, sabor y tamaño.
     */
    @Override
    public String toString() {
        return super.toString() + "\nGramos: " + gramos + "\nSabor: " + sabor + "\nTamaño: " + tamaño;
    }
}