/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author lfern
 */
public class ChatCliente {

    private static int puerto = 7000;
    private static String host = "localhost";

    public static void main(String[] args) throws IOException {
        Scanner rd = new Scanner(System.in);
        String mensaje = "";
        Socket puenteServidor = new Socket(host, puerto);
        System.out.println("Conexion establecida..!!");
        DataOutputStream salida = new DataOutputStream(puenteServidor.getOutputStream());
        DataInputStream entrada = new DataInputStream(puenteServidor.getInputStream());
        do {
            mensaje = entrada.readUTF();
            System.out.println("Servidor: " + mensaje);
            System.out.println("Responder al servidor");
            mensaje = rd.nextLine();
            salida.writeUTF(mensaje);
        } while (!mensaje.equalsIgnoreCase("cerrar"));

        salida.close();
        entrada.close();
        puenteServidor.close();
    }

}
