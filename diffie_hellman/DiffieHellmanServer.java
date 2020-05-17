package diffie_hellman;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DiffieHellmanServer {
    protected static ServerSocket __serverSocket;
    protected static Socket __server;
    private static int __port = 8088;
    private static int __server_key = 3;

    public static void main(String[] args) {
        try {
            __serverSocket = new ServerSocket(__port);
            __server = __serverSocket.accept();

            // Established the Connection 
            System.out.println("Waiting For Client on the port " + __serverSocket.getLocalPort() + "...");
            System.out.println("Connected To " + __server.getRemoteSocketAddress());

            // Server's Private Key 
            System.out.println("From Server : Private Key = " + __server_key); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}