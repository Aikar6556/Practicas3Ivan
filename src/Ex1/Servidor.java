package Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {


    public static void main(String[] args) {

        int conteo = 0;

        try {

            ServerSocket servidor = new ServerSocket(5555);
            System.out.println("Ex1.Servidor iniciado, esperando conexión del cliente");

            while (true) {

                Socket cliente = servidor.accept();
                conteo++;
                System.out.println("Ex1.Cliente "+conteo+" conectado desde: "+cliente.getInetAddress());

                BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

                PrintWriter salidaCliente = new PrintWriter(cliente.getOutputStream(),true);


                salidaCliente.println("Conexion exitosa. Eres el cliente número: "+conteo);

                String mensajeCliente = entradaCliente.readLine();
                System.out.println("Mensaje del cliente "+conteo+": "+mensajeCliente);

                String mensajeAlCliente = "Hola, cliente "+ conteo + " soy el servidor";
                salidaCliente.println(mensajeAlCliente);
                entradaCliente.close();
                salidaCliente.close();
                cliente.close();


            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
