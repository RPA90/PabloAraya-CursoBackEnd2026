package service;
import java.util.ArrayList;
import model.ItemCarrito;
import model.Producto;

public class Carrito {
    private ArrayList<ItemCarrito> _carrito;
    private static int _idCounter;
    private int _id;

    public Carrito (){
        _carrito = new ArrayList<ItemCarrito>();
        _id = _idCounter;
        _idCounter++;
    }

    public int getId(){
        return _id;
    }

    public void agregarItem(Producto producto, int cantidad){
        ItemCarrito item = buscarItem(producto);
        if (buscarItem(producto) != null){
            item.agregarCantidad(cantidad);
        } else {
            _carrito.add(new ItemCarrito(producto, cantidad));
        }
    }

    public void removerItem(Producto producto){
        boolean encontrado = false;
        for (ItemCarrito p : _carrito){
            if(p.getProducto().equals(producto)){
                _carrito.remove(p);
                encontrado = true;
                System.out.println("El producto " + producto.getNombre() + " ha sido removido del carrito");
                break;
            }
        }

        if (!encontrado){
            System.out.println("El producto no fue encontrado en el carrito");
        }
    }

    public double obtenerTotal(){
        double total = 0;
        if(_carrito.size() > 0){
            for(ItemCarrito p : _carrito){
                total += p.getPrecioUnitario();
            }
        }

        return total;
    }

    private ItemCarrito buscarItem(Producto producto){
        ItemCarrito item = null;
        for (ItemCarrito p : _carrito){
            if(p.getProducto().equals(producto)){
                item = p;
                break;
            }
        }
        return item;
    }

    public void vaciarCarrito(){
        _carrito.clear();
    }

}
