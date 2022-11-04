/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author lfern
 */
public class ChatServidor {

    private static int puerto = 7000;

    public static void main(String[] args) throws IOException {
        Scanner rd = new Scanner(System.in);
        String mensaje = "";
        ServerSocket miServer = new ServerSocket(puerto);
        System.out.println("Esperando Conexion del chatCliente...");
        Socket puenteCliente = miServer.accept();

        DataOutputStream salida = new DataOutputStream(puenteCliente.getOutputStream());
        DataInputStream entrada = new DataInputStream(puenteCliente.getInputStream());
        salida.writeUTF("Servidor: Hola");
        do {
            mensaje = entrada.readUTF();
            System.out.println("David: " + mensaje);
            System.out.println("Responde: David");
            mensaje = rd.nextLine();
            salida.writeUTF(mensaje);
        } while (!mensaje.equalsIgnoreCase("cerrar"));

        salida.close();
        entrada.close();
        puenteCliente.close();
    }
}
