package Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {


    public static void main(String[] args) {

        try {

            for (int i=0;i<5;i++){

         Socket conexionServidor = new Socket("localhost",5555);
         System.out.println("Conectado al servidor");



            BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(conexionServidor.getInputStream()));
            PrintWriter salidaCliente = new PrintWriter(conexionServidor.getOutputStream(),true);


            String mensajeDelServidor = entradaCliente.readLine();
            System.out.println("Ex1.Servidor: "+mensajeDelServidor);

            salidaCliente.println("Gracias por aceptar");

            String respuestaServidor = entradaCliente.readLine();
            System.out.println("Ex1.Servidor: "+respuestaServidor);
            entradaCliente.close();
            salidaCliente.close();
            conexionServidor.close();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
