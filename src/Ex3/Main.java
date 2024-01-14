package Ex3;

public class Main {

    public static void main(String[] args) {

        ProductoObservable1 portatil = new ProductoObservable1(1000);

        ClienteObserver1 cliente1 = new ClienteObserver1("Pedrito");
        ClienteObserver1 cliente2 = new ClienteObserver1("Mamasota");

        portatil.addObserver(cliente1);
        portatil.addObserver(cliente2);

        portatil.setPrecio(2000);




    }



}
