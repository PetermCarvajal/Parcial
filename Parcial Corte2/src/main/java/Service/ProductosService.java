package Service;

import entity.Producto;

import java.util.List;

public interface ProductosService {
    void agregarProducto(Producto producto);
    Producto obtenerProducto(Long id);
    List<Producto> obtenerTodosLosProductos();
    void modificarProducto(Producto producto);
    void borrarProducto(Long id);
}

