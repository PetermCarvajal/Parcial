package Respository;

import entity.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosRepositoryImpl implements ProductosRepository {

    private final String fileName = "datos.dat";

    @Override
    public void crear(Producto producto) {
        List<Producto> productos = leerTodos();
        producto.setId(generarNuevoId(productos));  // Genera un nuevo ID único
        productos.add(producto);
        guardarProductos(productos);
    }

    @Override
    public Producto leer(Long id) {
        List<Producto> productos = leerTodos();
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public List<Producto> leerTodos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Producto>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();  // Si no existe el archivo, devolver lista vacía
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void Actualizar(Producto productoActualizado) {
        List<Producto> productos = leerTodos();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == productoActualizado.getId()) {
                productos.set(i, productoActualizado);  // Actualiza el producto
                break;
            }
        }
        guardarProductos(productos);
    }

    @Override
    public void eliminar(Long id) {
        List<Producto> productos = leerTodos();
        productos.removeIf(producto -> producto.getId() == id);
        guardarProductos(productos);
    }

    private void guardarProductos(List<Producto> productos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long generarNuevoId(List<Producto> productos) {
        if (productos.isEmpty()) {
            return 1L;  // Si no hay productos, el primer ID será 1
        } else {
            return productos.stream().mapToLong(Producto::getId).max().orElse(0L) + 1;
        }
    }
}
