package Ex3;

import java.util.Observable;

public class ProductoObservable1  extends Observable {
    private double precio;

    public ProductoObservable1(double precioInicial) {
        this.precio = precioInicial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double nuevoPrecio) {
        if (this.precio != nuevoPrecio) {
            this.precio = nuevoPrecio;
            setChanged();
            notifyObservers("Nuevo precio: " + nuevoPrecio);
        }
    }

}
