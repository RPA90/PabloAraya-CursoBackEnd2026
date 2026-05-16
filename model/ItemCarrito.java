public class ItemCarrito {
    private Producto _producto;
    private int _cantidad;
    private double _precioUnitario;

    public ItemCarrito(Producto producto, int cantidad){
        _producto = producto;
        _cantidad = cantidad;
        _precioUnitario = producto.getPrecio();
    }

    public Producto getProducto(){
        return _producto;
    }

    public int getCantidad(){
        return _cantidad;
    }
    public void setCantidad(int cantidad){
        _cantidad = cantidad;
    }

    public double getPrecioUnitario(){
        return _precioUnitario;
    }

    public void agregarCantidad(){
        _cantidad++;
    }
    public void agregarCantidad(int cantidad){
        _cantidad += cantidad;

        if(_cantidad < 0){
            _cantidad = 0;
        }
    }

    public void removerCantidad(){
        _cantidad--;

        if (_cantidad < 0){
            _cantidad = 0;
        }
    }
}