package Ex2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();


        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Servidor conectado");


        while (true) {

            Socket clienteSocket = serverSocket.accept();

            ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());

            ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());


            if (maquinaExpendedora.obtenerCantidadRefrescos() > 0) {

                ClienteThread clienteThread = new ClienteThread(out, in);
                clienteThread.start();

                synchronized (maquinaExpendedora) {
                    for (int i = 0; i < clienteThread.getCantidadPedido(); i++) {
                        Refresco refresco = maquinaExpendedora.dispensarRefresco();
                        out.writeObject(refresco);
                    }


                }


            } else {

                System.out.println("La máquina expendodra se ha quedado sin refrescos.");
                clienteSocket.close();

            }


        }


    }

}
