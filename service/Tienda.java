package service;
import java.util.ArrayList;
import model.ItemCarrito;
import model.Producto;

import exceptions.ProductoNoEncontradoException;

public class Tienda {
    private String _nombre;
    private ArrayList<Producto> _listaProductos;

    public Tienda(String nombre){
        _nombre = nombre;
        _listaProductos = new ArrayList<Producto>();

    }

    public String nombre(){
        return _nombre;
    }

    public double comprarProducto(Producto producto, int unidades){
        double total;
        total = producto.getPrecio() * unidades;

        return total;
    }

    public Producto buscarProducto(String nombre){
        for(Producto p : _listaProductos){
            if(p.getNombre().equals(nombre)){
                return p;
            }
        }

        return null;
    }

    public void agregarProducto(Producto productoNuevo){
        _listaProductos.add(productoNuevo);
    }

    public void removerProducto(Producto producto){
        _listaProductos.remove(producto);
    }

        public void mostrarProductos(){
        for(Producto p : _listaProductos){
            System.out.println(p.getNombre());
        }
    }

    public double calcularImpuesto(Producto producto, double impuesto){
        return producto.getPrecio() * ((100 - impuesto) * 0.01);
    }

    public double calcularPrecioFinal(Producto producto, double impuesto, int cantidad){
        if(cantidad > 50){
            double impCant = impuesto * 1.25;
            if (impCant > 100){
                impCant = 100;
            }

            return producto.getPrecio() * cantidad * ((100 - impCant) * 0.01);
        }

        return producto.getPrecio() * cantidad * ((100 - impuesto) * 0.01);
    }

    public void reponerStock(Producto producto, int cantidad){
        if (producto != null){
            producto.agregarStock(cantidad);
        } else {
            throw new ProductoNoEncontradoException("El producto no existe");
        }
    }
}
