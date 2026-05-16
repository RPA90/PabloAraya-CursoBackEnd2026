package model;

public class Producto {
    private static int _idCounter = 0;
    private int _id;
    private String _nombre;
    private double _precio;    private int _stock;

    public Producto (String nombre, double precio){
        _id = _idCounter;
        _idCounter++;
        _nombre = nombre;
        _precio = precio;
        _stock = 0;
    }

    public Producto (String nombre, double precio, int stock){
        _id = _idCounter;
        _idCounter++;
        _nombre = nombre;
        _precio = precio;
        _stock = stock;
    }

    public int getId(){
        return _id;
    }

    public String getNombre(){
        return _nombre;
    }

    public double getPrecio(){
        return _precio;
    }
    public void setPrecio(double precioNuevo){
        _precio = precioNuevo;
    }

    public int getStock(){
        return _stock;
    }
    public void setStock(int cantidad){
        if (cantidad < 0){
            _stock = 0;
        } else {
            _stock = cantidad;
        }
    }
    public void agregarStock(int cantidad){
        if ((_stock + cantidad) < 0){
            _stock = 0;
        } else {
            _stock += cantidad;
        }
    }

    public void mostarInformacion(){
        System.out.println("Nombre: " + _nombre);
        System.out.println("Precio: " + _precio);
        System.out.println("Stock: " + _stock);
    }
}
