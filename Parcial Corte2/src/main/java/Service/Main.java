package Service;

import entity.Producto;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    private static final ProductosService productosService = new ProductosServiceImpl();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(null, """
                ---CRUD DE PRODUCTO DE LA TIENDA ElECTRONICA---
                1. Crear Producto
                2. Leer Producto
                3. Actualizar Producto
                4. Eliminar Producto
                5. Lista de Productos
                6. Salir
                """);

            switch (opcion) {
                case "1" -> crearProducto();
                case "2" -> leerProducto();
                case "3" -> actualizarProducto();
                case "4" -> eliminarProducto();
                case "5" -> listaProductos();
                case "6" -> salir = true;
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }

    public static void crearProducto() {
        String procesador = JOptionPane.showInputDialog("Ingrese la serie del procesador");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del portátil");
        BigDecimal precio = new BigDecimal(JOptionPane.showInputDialog("Ingrese el precio:"));

        Producto producto = new Producto();
        producto.setProcesador(procesador);
        producto.setMarca(marca);
        producto.setPrecio(precio);

        productosService.agregarProducto(producto);
    }

    public static void leerProducto() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        Producto producto = productosService.obtenerProducto(id);

        if (producto != null) {
            JOptionPane.showMessageDialog(null, producto);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }

    public static void actualizarProducto() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del producto a actualizar:"));
        Producto producto = productosService.obtenerProducto(id);

        if (producto != null) {
            String procesador = JOptionPane.showInputDialog("Ingrese el nuevo procesador:", producto.getProcesador());
            String marca = JOptionPane.showInputDialog("Ingrese la nueva marca:", producto.getMarca());
            BigDecimal precio = new BigDecimal(JOptionPane.showInputDialog("Ingrese el nuevo precio:", producto.getPrecio()));

            producto.setProcesador(procesador);
            producto.setMarca(marca);
            producto.setPrecio(precio);

            productosService.modificarProducto(producto);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }

    public static void eliminarProducto() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:"));
        productosService.borrarProducto(id);
    }

    public static void listaProductos() {
        List<Producto> productos = productosService.obtenerTodosLosProductos();
        StringBuilder lista = new StringBuilder("--- Lista de Productos ---\n");
        for (Producto p : productos) {
            lista.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
