package src.decryption;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.spec.KeySpec;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class __aes_file_Decryption {
      protected static byte[] __salt, __iv, __output;
      protected static Scanner __get_user_encrypted_file_input, __get_password, __get_salt_file, __get_iv_file;
      protected static SecretKeyFactory __secret_key_factory;
      protected static KeySpec __key_spec;
      protected static SecretKey __tmp, __secret;
      protected static String __algorithm_padding = "PBKDF2WithHmacSHA1";
      protected static String __algorithm = "AES/CBC/PKCS5Padding";
      protected static String __encryption_type = "AES";
      protected static Cipher __cipher;
      private static String __user_file_input, __password, __salt_file, __iv_file;
      private static String __output_path = "output/file/decrypted/decrypted_file.txt";
      private static int _read;

      public static void main(final String[] args) throws Exception {
            System.out.println("{ SHA 512 } \nEnter File {path} for decryption: ");
            // Get User Input:
            __get_user_encrypted_file_input = new Scanner(System.in);
            __get_password = new Scanner(System.in);
            __get_salt_file = new Scanner(System.in);
            __get_iv_file = new Scanner(System.in);
            __user_file_input = __get_user_encrypted_file_input.nextLine();
            System.out.println("Please Enter Password: ");
            __password = __get_password.nextLine();
            System.out.println("Please Enter the {path} of _salt file (\".enc\"): ");
            __salt_file = __get_salt_file.nextLine();
            System.out.println("Please Enter the {path} of _iv file (\".enc\"): ");
            __iv_file = __get_iv_file.nextLine();

            /**
             * @Method: read [salt], users should already have a secured mechanism for
             *          transferring the [salt] , password and iv_.
             */

            final FileInputStream __input_salt_file = new FileInputStream(__salt_file);
            __salt = new byte[8];
            __input_salt_file.read(__salt);
            __input_salt_file.close();

            // Read Iv:
            final FileInputStream __input_iv_file = new FileInputStream(__iv_file);
            __iv = new byte[16];
            __input_iv_file.read(__iv);
            __input_iv_file.close();

            __secret_key_factory = SecretKeyFactory.getInstance(__algorithm_padding);
            __key_spec = new PBEKeySpec(__password.toCharArray(), __salt, 65536, 256);
            __tmp = __secret_key_factory.generateSecret(__key_spec);
            __secret = new SecretKeySpec(__tmp.getEncoded(), __encryption_type);

            // File decryption:
            __cipher = Cipher.getInstance(__algorithm);
            __cipher.init(Cipher.DECRYPT_MODE, __secret, new IvParameterSpec(__iv));
            final FileInputStream __input_file = new FileInputStream(__user_file_input);
            final FileOutputStream __output_file = new FileOutputStream(__output_path);
            final byte [] _in = new byte[64];
            while ((_read = __input_file.read(_in)) != -1) {
                  __output = __cipher.update(_in, 0, _read);
                  if (__output != null) {
                        __output_file.write(__output);
                  }
            }
            final byte [] _output = __cipher.doFinal();
            if (_output != null) {
                  __output_file.write(__output);
            }
            __input_file.close();
            __output_file.flush();
            __output_file.close();
            System.out.println("User File Decrypted...");
      }
}