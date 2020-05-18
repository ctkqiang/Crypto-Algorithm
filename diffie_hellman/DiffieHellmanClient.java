package diffie_hellman;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DiffieHellmanClient {
    protected static Socket __client_socket;
    private static DataInputStream __dataInputStream;
    private static OutputStream __outputStreamToServer;
    private static DataOutputStream __dataOutputStream;
    private static String __PSTR, __GSTR, __ASTR;
    private static String __SERVER_NAME;
    private static int __PORT = 8088;
    private static double __ADASH, __SERVER_B;
    
    public static void main(String[] args) {
        try {
            // Key of client:
            int __p = 23;
            int __g = 9;
            int __a = 4;

            // Established the connection :
            System.out.println("Connected to ===> " + __SERVER_NAME + "on Port ===> " + __PORT);
            __client_socket = new Socket(__SERVER_NAME, __PORT);
            System.out.println("Just COnnected To " + __client_socket.getRemoteSocketAddress());

            // Sends the [DATA] to [CLIENT]
            __outputStreamToServer = __client_socket.getOutputStream();
            __dataOutputStream = new DataOutputStream(__outputStreamToServer);

            // sending p, g, a 
            __PSTR = Integer.toString(__p);
            __dataOutputStream.writeUTF(__PSTR);

            __GSTR = Integer.toString(__g);
            __dataOutputStream.writeUTF(__GSTR);

            final double __A = ((Math.pow(__g, __a)) % __p);
            __ASTR = Double.toString(__A);
            __dataOutputStream.writeUTF(__ASTR);

            // Client's Private Key 
            System.out.println("From Client ==> Private Key ==> " + __a);

            // Accepting the Data :
            __dataInputStream = new DataInputStream(__client_socket.getInputStream());
            __SERVER_B = Double.parseDouble(__dataInputStream.readUTF());
            System.out.println("From Server ==> Public Key ==> " + __SERVER_B);

            // ADASH CALCULATION :
            __ADASH = ((Math.pow(__SERVER_B, __a)) % __p);
            System.out.println("Secret Key to perform Symmetric Encryption ==> " + __ADASH);
            __client_socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}