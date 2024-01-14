package Ex4;

import Ex3.ProductoObservable1;

import java.util.Observable;

public class ProductoObservable extends Observable {
    private double precio;

    public ProductoObservable(double precioInicial) {
        this.precio = precioInicial;
    }

    public synchronized double getPrecio() {
        return precio;
    }

    public synchronized void setPrecio(double nuevoPrecio) {
        if (this.precio != nuevoPrecio) {
            this.precio = nuevoPrecio;
            setChanged();
            notifyObservers("Nuevo precio: " + nuevoPrecio);
        }
    }
}
