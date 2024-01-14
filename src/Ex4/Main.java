package Ex4;

import Ex3.ProductoObservable1;

public class Main {

    public static void main(String[] args) {


        ProductoObservable lavadora = new ProductoObservable(400);

        ClienteObserver cliente1 = new ClienteObserver("Juan Mecanico");
        ClienteObserver cliente2 = new ClienteObserver("Paca");

        lavadora.addObserver(cliente1);
        lavadora.addObserver(cliente2);

        Thread modificador1 = new Thread(new HiloProducto(lavadora));
        Thread modificador2 = new Thread(new HiloProducto(lavadora));

        modificador1.start();
        modificador2.start();



    }



}
