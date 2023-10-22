import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;

public class Sistema {
    private List<Producto> productos = new ArrayList<>();
    private Random random = new Random();

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.mostrarMenu();
    }

    /**
     * Muestra el menú principal del sistema y gestiona las opciones elegidas por el usuario.
     */
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Cargar datos desde CSV");
            System.out.println("2. Agregar nuevo producto");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Calcular ventas");
            System.out.println("5. Generar informe");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    cargarDatos();
                    break;
                case 2:
                    agregarNuevoProducto();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    int idBuscar = scanner.nextInt();
                    Producto productoBuscado = buscarProducto(idBuscar);
                    if (productoBuscado != null) {
                        System.out.println("Producto encontrado:\n" + productoBuscado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    calcularVentas();
                    break;
                case 5:
                    generarInforme();
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }

    /**
     * Permite al usuario agregar un nuevo producto al inventario.
     */
    public void agregarNuevoProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Categoría del nuevo producto (Bebida, Snack, Dulce): ");
        String categoria = scanner.nextLine();
        int id = generarID();
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad disponible: ");
        int cantidadDisponible = scanner.nextInt();
        System.out.print("Cantidad vendidos: ");
        int cantidadVendidos = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Estado (disponible o no disponible): ");
        String estado = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        switch (categoria.toLowerCase()) {
            case "bebida":
                System.out.print("Mililitros: ");
                int mililitros = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Tipo (energética, con licor, natural, agua pura): ");
                String tipo = scanner.nextLine();
                Bebida bebida = new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, mililitros, tipo);
                agregarProducto(bebida);
                break;
            case "snack":
                System.out.print("Gramos: ");
                int gramos = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Sabor (barbacoa, picante, natural): ");
                String sabor = scanner.nextLine();
                System.out.print("Tamaño (individual, familiar): ");
                String tamaño = scanner.nextLine();
                Snack snack = new Snack(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamaño);
                agregarProducto(snack);
                break;
            case "dulce":
                System.out.print("Ingrediente: ");
                String ingrediente = scanner.nextLine();
                System.out.print("Textura: ");
                String textura = scanner.nextLine();
                Dulce dulce = new Dulce(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, ingrediente, textura);
                agregarProducto(dulce);
                break;
            default:
                System.out.println("Categoría no válida.");
                return; 
        }
        
        try {
            String archivoCSV = "Inventario.csv";
            FileWriter fileWriter = new FileWriter(archivoCSV, true);

            String linea = nombre + "," + cantidadDisponible + "," + cantidadVendidos + "," + estado + "," + precio + "," + categoria;

            if (categoria.equalsIgnoreCase("bebida")) {
                System.out.print("Mililitros: ");
                int mililitros = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Tipo (energética, con licor, agua pura): ");
                String tipo = scanner.nextLine();
                linea += "," + mililitros + "," + tipo;
            } else if (categoria.equalsIgnoreCase("snack")) {
                System.out.print("Gramos: ");
                int gramos = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Sabor (barbacoa, picante, limón): ");
                String sabor = scanner.nextLine();
                System.out.print("Tamaño (individual, familiar): ");
                String tamaño = scanner.nextLine();
                linea += "," + gramos + "," + sabor + "," + tamaño;
            } else if (categoria.equalsIgnoreCase("dulce")) {
                System.out.print("Ingrediente: ");
                String ingrediente = scanner.nextLine();
                System.out.print("Textura: ");
                String textura = scanner.nextLine();
                linea += "," + ingrediente + "," + textura;
            }

            fileWriter.write("\n" + linea);
            fileWriter.close();
            
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Carga los datos de productos desde un archivo CSV.
     */
    public void cargarDatos() {
        String archivoCSV = "Inventario.csv";

        try {
            File archivo = new File(archivoCSV);
            FileReader lectorArchivo = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(lectorArchivo);

            bufferedReader.readLine();

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 6) {
                    int id = generarID();
                    String nombre = partes[0];
                    int cantidadDisponible = Integer.parseInt(partes[1]);
                    int cantidadVendidos = Integer.parseInt(partes[2]);
                    String estado = partes[3];
                    double precio = Double.parseDouble(partes[4]);
                    String categoria = partes[5];
                    Producto producto = null;

                    if (categoria.equalsIgnoreCase("bebida") && partes.length >= 8) {
                        int mililitros = Integer.parseInt(partes[6]);
                        String tipo = partes[7];
                        producto = new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, mililitros, tipo);
                    } else if (categoria.equalsIgnoreCase("snack") && partes.length >= 11) {
                        int gramos = Integer.parseInt(partes[8]);
                        String sabor = partes[9];
                        String tamaño = partes[10];
                        producto = new Snack(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamaño);
                    } else if (categoria.equalsIgnoreCase("dulce") && partes.length >= 13) {
                        String ingrediente = partes[11];
                        String textura = partes[12];
                        producto = new Dulce(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, ingrediente, textura);
                    }

                    if (producto != null) {
                        agregarProducto(producto);
                    }
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error al cargar datos desde el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Agrega un producto al inventario.
     *
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Genera un identificador único para productos.
     *
     * @return El identificador único generado.
     */
    public int () {
        return random.nextInt(1000) + 1;
    }

    /**
     * Busca un producto por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return El producto encontrado o null si no se encontró ninguno.
     */
    public Producto buscarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Calcula las ventas totales y las comisiones por categoría de productos.
     */
    public void calcularVentas() {
        double ventasBebidas = 0.0;
        double ventasSnacks = 0.0;
        double ventasDulces = 0.0;
        double comisionDulces = 0.0;

        for (Producto producto : productos) {
            if (producto instanceof Bebida) {
                ventasBebidas += producto.getPrecio() * producto.getCantidadVendidos();
            } else if (producto instanceof Snack) {
                ventasSnacks += producto.getPrecio() * producto.getCantidadVendidos();
            } else if (producto instanceof Dulce) {
                ventasDulces += producto.getPrecio() * producto.getCantidadVendidos();
                comisionDulces += producto.getPrecio() * producto.getCantidadVendidos() * 0.20;
            }
        }

        double totalVentas = ventasBebidas + ventasSnacks + ventasDulces - comisionDulces;
        
        System.out.println("Ventas de Bebidas: $" + ventasBebidas);
        System.out.println("Ventas de Snacks: $" + ventasSnacks);
        System.out.println("Ventas de Dulces: $" + ventasDulces);
        System.out.println("Comisión por ventas de Dulces: $" + comisionDulces);
        System.out.println("Total de Ventas (sin comisión): $" + totalVentas);
    }

    /**
     * Genera un informe que muestra la información de todos los productos y las ventas totales.
     */
    public void generarInforme() {
        double totalVentas = 0;

        System.out.println("=== Informe ===");
        System.out.printf("%-4s %-15s %-18s %-12s %-8s %-9s %-10s\n", "ID", "Nombre", "Cantidad Disponible", "Cantidad Vendidos", "Estado", "Precio", "Categoría");

        for (Producto producto : productos) {
            totalVentas += producto.getPrecio() * producto.getCantidadVendidos();

            System.out.printf("%-4d %-15s %-18d %-12d %-8s $%-8.2f %s\n",
                producto.getId(), producto.getNombre(), producto.getCantidadDisponible(),
                producto.getCantidadVendidos(), producto.getEstado(), producto.getPrecio(), producto.getClass().getSimpleName());
        }

        System.out.println("\nTotal de Ventas: $" + totalVentas);
    }
}