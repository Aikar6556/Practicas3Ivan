package Ex2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {


        Socket conexionServidor = new Socket("localhost", 5555);

        ObjectInputStream input = new ObjectInputStream(conexionServidor.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(conexionServidor.getOutputStream());

        Thread cliente1 = new Thread(new ClienteThread(output,input));




    }

}
