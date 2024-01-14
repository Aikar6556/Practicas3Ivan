package Ex2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClienteThread extends Thread {

    private ObjectOutputStream out;
    private ObjectInputStream in;

    private int cantidadPedido;


    public ClienteThread(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    @Override
    public void run() {
        try {

            int cantidadPedido = (int) (Math.random() * 5) + 1;
            out.writeInt(cantidadPedido);
            out.flush();

            for (int i = 0; i < cantidadPedido; i++) {
                Refresco refresco = (Refresco) in.readObject();
                System.out.println("Cliente recibió: " + refresco.getNombre());
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
