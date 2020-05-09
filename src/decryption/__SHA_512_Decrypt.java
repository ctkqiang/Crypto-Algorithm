package src.decryption;
/**
 * Copyright 2020 © John Melody Me
 * Licensed under the John Melody Me, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import model.__sha_512_model;

public class __SHA_512_Decrypt {
      protected static String __secretKey = "this_is_@_SECRET_kEy#";
      private static Scanner __get_user_input;
      private static String __user_input, __decrypted_string, __post_decrypted_string;
      private static File __file;
      private static FileWriter __fileWriter;

      public static void main(final String[] args) {
            System.out.println("{ SHA 512 } \nEnter text for derypt: ");
            // Get user input:
            __get_user_input = new Scanner(System.in);
            __user_input = __get_user_input.nextLine();
            __post_decrypted_string = __sha_512_model.__decrypt(__user_input, __secretKey);
            __decrypted_string = __sha_512_model.__decrypt(__post_decrypted_string, __secretKey);
            System.out.println("Encrypted Content: " + __user_input);
            System.out.println("Decrypted String: " + __decrypted_string);
            __SaveTheOutput();
      }

      protected static void __SaveTheOutput() {
            try {
                  __file = new File("output/SHA512/" + new Random().nextInt(7) + "_output.decrypted");
                  __fileWriter = new FileWriter(__file);
                  __fileWriter.write(
                              "Performed at " + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "\n\n");
                  __fileWriter.write("Encrypted Content: " + __user_input + "\n");
                  __fileWriter.write("Decrypted String: " + __decrypted_string);
                  __fileWriter.close();
                  __clearMemory();
            } catch (final IOException ioException) {
                  System.out.println("Exception: " + ioException.toString());
            }
      }

      protected static void __clearMemory() {
            System.gc();
      }
}