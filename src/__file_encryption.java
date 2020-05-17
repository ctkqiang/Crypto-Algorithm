package src;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;

public class __file_encryption {
      private static String __algorithm = "AES";
      private static KeyGenerator __key_generator;
      
      public static void main(String args[]) throws Exception {
            __onStart();
            __onDestroy();
      }

      protected static void __onStart() throws NoSuchAlgorithmException {
            __key_generator = KeyGenerator.getInstance(__algorithm);
            __key_generator.init(new SecureRandom());
            __key_generator.generateKey();
            SecretKeyFactory.getInstance(__algorithm);
      }

      protected static void __onDestroy() {
            __algorithm = null;
            System.gc();
      }
}