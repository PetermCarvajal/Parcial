package Respository;

import entity.Producto;
import java.util.List;

public interface ProductosRepository {
    void crear(Producto producto);
    Producto leer(Long id);
    List<Producto> leerTodos();
    void Actualizar(Producto producto);
    void eliminar(Long id);
}
