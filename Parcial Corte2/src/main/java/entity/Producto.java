package entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String marca;
    private BigDecimal precio;
    private String procesador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return "Producto: \nId: " + id + "\nMarca: " + marca + "\nProcesador: " + procesador + "\nPrecio: " + precio;
    }
}
