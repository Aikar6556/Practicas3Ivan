package Ex4;

import Ex3.ProductoObservable1;

import java.util.Observable;
import java.util.Observer;

public class ClienteObserver implements Observer {

    private String nombre;

    public ClienteObserver(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public void update(Observable observable, Object arg) {


        if (observable instanceof ProductoObservable) {
            ProductoObservable productoObservable = (ProductoObservable) observable;
            System.out.println("Ex1.Cliente " + nombre + " recibe lo siguiente: " + arg);
            System.out.println("Precio actual del producto: " + productoObservable.getPrecio());
        }
    }

}
