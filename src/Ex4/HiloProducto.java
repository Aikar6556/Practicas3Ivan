package Ex4;


public class HiloProducto implements Runnable {

    private ProductoObservable producto;

    public HiloProducto(ProductoObservable producto) {
        this.producto = producto;
    }


    @Override
    public void run() {

        int subidoPrecio;

        for (int i = 0; i < 5; i++) {
            subidoPrecio = (int) (Math.random()*100);
            double nuevoPrecio = producto.getPrecio()+subidoPrecio;
            producto.setPrecio(nuevoPrecio);
            try {
                Thread.sleep(3000); // cada tres segundos se cambia el precio del producto.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
