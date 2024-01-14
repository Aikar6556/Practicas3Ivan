package Ex3;

import java.util.Observable;
import java.util.Observer;


public class ClienteObserver1 implements Observer {


    private String nombre;

    public ClienteObserver1(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public void update(Observable observable, Object arg) {


        if (observable instanceof ProductoObservable1) {
            ProductoObservable1 productoObservable = (ProductoObservable1) observable;
            System.out.println("Ex1.Cliente " + nombre + " recibiÃ³ la siguiente notificaciÃ³n: " + arg);
            System.out.println("Precio actual del producto: " + productoObservable.getPrecio());
        }
    }



}

