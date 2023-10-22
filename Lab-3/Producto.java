/**
 * Clase que representa un producto en un sistema de inventario.
 */
public class Producto {
    private int id; // Identificador único del producto.
    private String nombre; // Nombre del producto.
    private int cantidadDisponible; // Cantidad de unidades disponibles en el inventario.
    private int cantidadVendidos; // Cantidad de unidades vendidas.
    private String estado; // Estado del producto (por ejemplo, "Nuevo", "Usado").
    private double precio; // Precio del producto.
    private String categoria; // Categoría o tipo del producto.

    /**
     * Constructor para crear un nuevo objeto Producto.
     *
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param cantidadDisponible Cantidad de unidades disponibles en el inventario.
     * @param cantidadVendidos Cantidad de unidades vendidas.
     * @param estado Estado del producto.
     * @param precio Precio del producto.
     */
    public Producto(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return El identificador del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param id El nuevo identificador del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad de unidades disponibles en el inventario.
     *
     * @return La cantidad de unidades disponibles.
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece la cantidad de unidades disponibles en el inventario.
     *
     * @param cantidadDisponible La nueva cantidad de unidades disponibles.
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Obtiene la cantidad de unidades vendidas.
     *
     * @return La cantidad de unidades vendidas.
     */
    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    /**
     * Establece la cantidad de unidades vendidas.
     *
     * @param cantidadVendidos La nueva cantidad de unidades vendidas.
     */
    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    /**
     * Obtiene el estado del producto.
     *
     * @return El estado del producto.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del producto.
     *
     * @param estado El nuevo estado del producto.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la categoría o tipo del producto.
     *
     * @return La categoría del producto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría o tipo del producto.
     *
     * @param categoria La nueva categoría del producto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Genera una representación de cadena del objeto Producto.
     *
     * @return Una cadena que describe el producto con su ID, nombre, cantidad disponible, cantidad vendida, estado, precio y categoría.
     */
    @Override
    public String toString() {
        return "ID: " + id +
               "\nNombre: " + nombre +
               "\nCantidad Disponible: " + cantidadDisponible +
               "\nCantidad Vendidos: " + cantidadVendidos +
               "\nEstado: " + estado +
               "\nPrecio: $" + precio +
               "\nCategoría: " + categoria;
    }
}