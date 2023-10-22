/**
 * Clase que representa un producto específico, un "Dulce", que hereda de la clase Producto.
 */
public class Dulce extends Producto {
    private String ingrediente; // Ingrediente principal del dulce.
    private String textura; // Descripción de la textura del dulce.

    /**
     * Constructor para crear un objeto Dulce.
     *
     * @param id Identificador único del dulce.
     * @param nombre Nombre del dulce.
     * @param cantidadDisponible Cantidad de unidades disponibles en el inventario del dulce.
     * @param cantidadVendidos Cantidad de unidades vendidas del dulce.
     * @param estado Estado del dulce.
     * @param precio Precio del dulce.
     * @param ingrediente Ingrediente principal del dulce.
     * @param textura Descripción de la textura del dulce.
     */
    public Dulce(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, String ingrediente, String textura) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio); // Llama al constructor de la clase base Producto.
        this.ingrediente = ingrediente;
        this.textura = textura;
    }

    /**
     * Obtiene el ingrediente principal del dulce.
     *
     * @return El ingrediente principal del dulce.
     */
    public String getIngrediente() {
        return ingrediente;
    }

    /**
     * Establece el ingrediente principal del dulce.
     *
     * @param ingrediente El nuevo ingrediente principal del dulce.
     */
    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    /**
     * Obtiene la descripción de la textura del dulce.
     *
     * @return La descripción de la textura del dulce.
     */
    public String getTextura() {
        return textura;
    }

    /**
     * Establece la descripción de la textura del dulce.
     *
     * @param textura La nueva descripción de la textura del dulce.
     */
    public void setTextura(String textura) {
        this.textura = textura;
    }

    /**
     * Genera una representación de cadena del objeto Dulce, incluyendo información heredada de Producto.
     *
     * @return Una cadena que describe el dulce con su ID, nombre, cantidad disponible, cantidad vendida, estado, precio, ingrediente y textura.
     */
    @Override
    public String toString() {
        return super.toString() + "\nIngrediente: " + ingrediente + "\nTextura: " + textura;
    }
}