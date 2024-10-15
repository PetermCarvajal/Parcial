package Service;

import Respository.ProductosRepository;
import Respository.ProductosRepositoryImpl;
import entity.Producto;

import java.util.List;

public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository repository = new ProductosRepositoryImpl();

    @Override
    public void agregarProducto(Producto producto) {
        repository.crear(producto);
    }

    @Override
    public Producto obtenerProducto(Long id) {
        return repository.leer(id);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return repository.leerTodos();
    }

    @Override
    public void modificarProducto(Producto producto) {
        repository.Actualizar(producto);
    }

    @Override
    public void borrarProducto(Long id) {
        repository.eliminar(id);
    }
}
