import java.security.Provider;
import java.security.Security;

public class CryptographyProvider {
    public static Provider[] __provider;
    private static String __name, __info;
    private static double __version;

    public static void main(final String[] args) {
        __provider = Security.getProviders();

        for (int i = 0; i < __provider.length; i++) {
            __name = __provider[i].getName();
            __info = __provider[i].getInfo();
            __version = __provider[i].getVersion();
            System.out.println("Providers [" + i + "] ==>" + "" + __name + "[" 
            + __version + "]" + " " + "\n" +__info);
        }
    }
}