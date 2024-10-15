package entity;

import jakarta.persistence.*;

import javax.swing.*;

public class ProductosLista {

    @PrePersist
    public void prePersist(Producto producto) {
        JOptionPane.showMessageDialog(null, "El Producto a Persistir es: " + producto);
    }
    @PostPersist
    public void postPersist(Producto producto) {
        JOptionPane.showMessageDialog(null, "El Producto Persistido es: " + producto);
    }

    @PreUpdate
    public void preUpdate(Producto producto) {
        JOptionPane.showMessageDialog(null, "El Producto a Modificar es: " + producto);
    }
    @PostUpdate
    public void postUpdate(Producto producto) {
        JOptionPane.showMessageDialog(null, "El Producto Que Fue Modificado es: " + producto);
    }

    @PreRemove
    public void preRemove(Producto producto) {
        JOptionPane.showMessageDialog(null, "El Producto a eliminar es: " + producto);
    }
    @PostRemove
    public void postRemove(Producto producto) {
        JOptionPane.showMessageDialog(null, "El Producto Que Fue eliminar es: " + producto);
    }

}

