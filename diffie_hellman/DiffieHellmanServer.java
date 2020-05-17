package diffie_hellman;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class DiffieHellmanServer {
    protected static ServerSocket __serverSocket;
    protected static DataInputStream __dataInputStream;
    protected static DataOutputStream __dataOutputStream;
    protected static Socket __server;
    protected static OutputStream __outOutputStream;
    private static int __port = 8088;
    private static int __server_key = 3;
    private static double __client_P, __client_G, __client_A, __B, __BDASH;
    private static String __BSTR;

    public static void main(String[] args) throws IOException {
        try {
            __serverSocket = new ServerSocket(__port);
            __server = __serverSocket.accept();

            // Established the Connection
            System.out.println("Waiting For Client on the port " + __serverSocket.getLocalPort() + "...");
            System.out.println("Connected To " + __server.getRemoteSocketAddress());

            // Server's Private Key
            System.out.println("From Server : Private Key = " + __server_key);

            // Accepts the data from client:
            __dataInputStream = new DataInputStream(__server.getInputStream());

            // Accept Client P:
            __client_P = Integer.parseInt(__dataInputStream.readUTF());
            System.out.println("From Client: P ==> " + __client_P);

            // Accept Client G:
            __client_G = Integer.parseInt(__dataInputStream.readUTF());
            System.out.println("From Client: G ==> " + __client_G);

            // Accept Client P:
            __client_A = Integer.parseInt(__dataInputStream.readUTF());
            System.out.println("From Client: [PUBLIC KEY] ==> " + __client_A);

            // Calculation of B:
            __B = ((Math.pow(__client_G, __server_key)) % __client_P);
            __BSTR = Double.toString(__B);

            // Send [DATA] to [CLIENT] && value of __B && send to __B :
            __outOutputStream = __server.getOutputStream();
            __dataOutputStream = new DataOutputStream(__outOutputStream);
            __dataOutputStream.writeUTF(__BSTR);

            // Calculation of BDASH:
            __BDASH = ((Math.pow(__client_A, __server_key)) % __client_P);
            System.out.println("Secret Key to perform Symmetric Encryption = " + __BDASH);
            __server.close();
        }  catch (SocketTimeoutException socketTimeoutException) { 
            System.out.println("Socket timed out: " + socketTimeoutException); 
        }  catch (final IOException exception) {
            exception.printStackTrace();
        }
    }
}