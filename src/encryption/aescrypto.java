package src.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class aescrypto {
      protected static SecretKeySpec __secret_key;
      protected static Cipher __cipher, _cipher;
      protected static byte[] __key;
      protected static String __transformation_encryption = "AES/ECB/PKCS5Padding";
      protected static String __transformation_decryption = "AES/ECB/PKCS5PADDING";
      private static Scanner __user_input;
      private static String __decrypted_string, __encrypted_string;
      private static String __algorithm = "SHA-512";
      private static String __encryption = "AES";

      public static void main(String args[]) {
            final String __userInput, __password, __strToDecrypt;

            System.out.println("{ SHA 256-AES } \nEnter text for encrypt: ");
            __password = "7721569pass3c";
            __user_input = new Scanner(System.in);
            __userInput = __user_input.nextLine();
            aescrypto._setKey(__password);
            aescrypto.__encrypt(__userInput);
            __strToDecrypt = aescrypto.get__encrypted_string();
            aescrypto.__decrypt(__strToDecrypt.trim());
            System.out.println("Original String: " + __userInput);
            System.out.println("Encrypted String: " + aescrypto.get__encrypted_string());
            System.out.println("Decrypted String: " + aescrypto.get__decrypted_string());
            __clearMemory();
      }

      public static void _setKey(String __myKey) {
            MessageDigest __SHA = null;
            try {
                  __key = __myKey.getBytes("UTF-8");
                  // System.out.println(__key.length);
                  __SHA = MessageDigest.getInstance(__algorithm);
                  __key = __SHA.digest(__key);
                  __key = Arrays.copyOf(__key, 32); // (8{64}), (16{128}, (32{256}), (64{512}), (128{1024}))
                  // System.out.println(__key.length);
                  // System.out.println(new String(__key, "UTF-8"));
                  __secret_key = new SecretKeySpec(__key, __encryption);
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                  noSuchAlgorithmException.printStackTrace();
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                  unsupportedEncodingException.printStackTrace();
            }
      }

      public static String get__decrypted_string() {
            return __decrypted_string;
      }

      public static void set__decrypted_string(String __decrypted_string) {
            aescrypto.__decrypted_string = __decrypted_string;
      }

      public static String get__encrypted_string() {
            return __encrypted_string;
      }

      public static void set__encrypted_string(String __encrypted_string) {
            aescrypto.__encrypted_string = __encrypted_string;
      }

      public static String __encrypt(String __strToEncrypt) {
            try {
                  __cipher = Cipher.getInstance(__transformation_encryption);
                  __cipher.init(Cipher.ENCRYPT_MODE, __secret_key);
                  set__encrypted_string(
                              Base64.getEncoder().encodeToString(__cipher.doFinal(__strToEncrypt.getBytes("UTF-8"))));
            } catch (Exception __exception) {
                  System.out.println("Error while encrypting: " + __exception.toString());
            }
            return null;
      }

      public static String __decrypt(String __strToDecrypt) {
            try {
                  _cipher = Cipher.getInstance(__transformation_decryption);
                  _cipher.init(Cipher.DECRYPT_MODE, __secret_key);
                  set__decrypted_string(new String(_cipher.doFinal(Base64.getDecoder().decode(__strToDecrypt))));
            } catch (Exception _exception) {
                  _exception.printStackTrace();
            }
            return null;
      }

      public static void __clearMemory() {
            System.gc();
      }
}