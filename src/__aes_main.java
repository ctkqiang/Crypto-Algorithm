package src;

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

import model.__aes;

public class __aes_main {
      private static String __secret_key, __user_input, __original_string;
      private static String __encrypted_string, __decrypted_string;
      private static Scanner __get_user_input;
      private static File __file;
      private static FileWriter __fileWriter;

      public static void main(final String[] args) {
            // :.. User input
            __welcome_method();

            // :... Configure
            __get_user_input = new Scanner(System.in);
            __secret_key = "this_is_a_secret_Key";
            __user_input = __get_user_input.nextLine();
            __original_string = __user_input;
            __encrypted_string = __aes.__encrypt(__original_string, __secret_key);
            __decrypted_string = __aes.__decrypt(__encrypted_string, __secret_key);
            __print_out();

            // :...Save Output
            __save_output();
      }

      private static void __welcome_method() {
            System.out.println("Please enter the input {string}: ");
      }

      private static void __print_out() {
            System.out.println("Performed at " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
            System.out.println("The Secret Key: " + __secret_key);
            System.out.println("The Original Content: " + __original_string);
            System.out.println("The Encrypted Content: " + __encrypted_string);
            System.out.println("The Decrypted Content: " + __decrypted_string);
            __get_user_input.close();
      }

      private static void __save_output() {
            try {
                  __file = new File("output/aes/" + new Random().nextInt(10) + "output.txt");
                  __fileWriter = new FileWriter(__file);
                  __fileWriter.write(
                              "Performed at " + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + "\n\n");
                  __fileWriter.write("The Secret Key: " + __secret_key + "\n");
                  __fileWriter.write("The Original Content: " + __original_string + "\n");
                  __fileWriter.write("The Encrypted Content: " + __encrypted_string + "\n");
                  __fileWriter.write("The Decrypted Content: " + __decrypted_string + "\n");
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