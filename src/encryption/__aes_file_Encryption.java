package src.encryption;

/**
 * @Copyright:  2020 © John Melody Me
 * Licensed under the John Melody Me, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class __aes_file_Encryption {
      protected static final String __padding = "PBKDF2WithHmacSHA1";
      protected static final String __algorithm = "AES/CBC/PKCS5Padding";
      protected static AlgorithmParameters __algorithm_parameters;
      protected static byte[] __salt, __iv, __input, __output;
      protected static FileInputStream __inFile;
      protected static String __Password, __user_input;
      protected static SecretKeyFactory __secretKeyFactory;
      protected static KeySpec __KeySpec;
      protected static SecretKey __secret_key, __secret;
      private static Scanner __get_user_input, __user_set_password;
      private static String __encryption_type = "AES";
      private static SecureRandom __secure_random;
      private static int __read_bytes;

      public static void main(final String[] args) throws Exception {
            System.out.println("{ SHA 512 } \nEnter File for encryption: ");
            // Get User Input:
            __get_user_input = new Scanner(System.in);
            __user_input = __get_user_input.nextLine();

            // Declare File to be Encrypt:
            FileInputStream __inFile = new FileInputStream(__user_input);

            // Encrypted File:
            FileOutputStream __outFile = new FileOutputStream("encryptedFile.encrypted"); // .des

            // Set Password for encrypted File:
            __user_set_password = new Scanner(System.in);
            __Password = __user_set_password.nextLine();

            /**
             * @Method: Encode content with [salt], and will be sent to recipients securely
             *          for decoding automatically and decryption.
             * @Warning: pass, iv and salt should be transferred to the other end securely.
             */
            __salt = new byte[8];
            __secure_random = new SecureRandom();
            __secure_random.nextBytes(__salt);

            FileOutputStream __saltOutput = new FileOutputStream("salt.enc");
            __saltOutput.write(__salt);
            __saltOutput.close();

            /**
             * @API: SecretKeyFactory refer
             *       https://docs.oracle.com/javase/7/docs/api/javax/crypto/SecretKeyFactory.html
             *       KeySpec refer
             *       https://docs.oracle.com/javase/7/docs/api/java/security/spec/KeySpec.html
             * 
             * @Param: https://docs.oracle.com/javase/7/docs/api/java/security/AlgorithmParameters.html
             */

            __secretKeyFactory = SecretKeyFactory.getInstance(__padding);
            __KeySpec = new PBEKeySpec(__Password.toCharArray(), __salt, 65536, 256);
            __secret_key = __secretKeyFactory.generateSecret(__KeySpec);
            __secret = new SecretKeySpec(__secret_key.getEncoded(), __encryption_type);

            Cipher __cipher = Cipher.getInstance(__algorithm);
            __cipher.init(Cipher.ENCRYPT_MODE, __secret);
            __algorithm_parameters = __cipher.getParameters();

            /**
             * @Method: Random `char` implementation to the content increase security
             *          breaches while initialising the `__cipher` then file to stor the
             *          `iv`.
             */
            FileOutputStream __iv_output = new FileOutputStream("iv_output.enc");
            __iv = __algorithm_parameters.getParameterSpec(IvParameterSpec.class).getIV();
            __iv_output.write(__iv);
            __iv_output.close();

            // File Encryption:
            __input = new byte[64];
            while ((__read_bytes = __inFile.read(__input)) != -1) {
                  __output = __cipher.update(__input, 0, __read_bytes);
                  if (__output != null) {
                        __outFile.write(__output);
                  }
            }

            byte[] _output = __cipher.doFinal();
            if (_output != null) {
                  __outFile.write(__output);
            }

            __inFile.close();
            __outFile.flush();
            __outFile.close();

            System.out.println("Content Encrypted...");

            __clearMemory();
      }

      private static void __clearMemory() {
            for (int i = 0; i < 5; i++) {
                  System.gc();
            }
      }
}