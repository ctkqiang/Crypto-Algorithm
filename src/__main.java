package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import model.__aes;

public class __main {
      private static String __secret_key, __user_input, __original_string, __encrypted_string, __decrypted_string;
      private static Scanner __get_user_input;
      private static File __file;
      private static FileWriter __fileWriter;
      private static DateTimeFormatter __date_time_formatter;
      private static LocalDateTime __now;

      public static void main(final String[] args) {
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

            // :.. Get Current Date and Time
            __date_time_formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            __now = LocalDateTime.now();
      }

      private static void __welcome_method() {
            System.out.println("Please enter the input {string}: ");
      }

      private static void __print_out() {
            System.out.println("Performed at " + java.time.LocalDate.now());
            System.out.println("The Secret Key: " + __secret_key);
            System.out.println("The Original Content: " + __original_string);
            System.out.println("The Encrypted Content: " + __encrypted_string);
            System.out.println("The Decrypted Content: " + __decrypted_string);
            __get_user_input.close();
      }

      private static void __save_output() {
            try {
                  __file = new File("output/" + new Random().nextInt(45) + "output.txt");
                  __fileWriter = new FileWriter(__file);
                  __fileWriter.write("Performed at " + java.time.LocalDate.now() + "\n");
                  __fileWriter.write("The Secret Key: " + __secret_key + "\n");
                  __fileWriter.write("The Original Content: " + __original_string + "\n");
                  __fileWriter.write("The Encrypted Content: " + __encrypted_string + "\n");
                  __fileWriter.write("The Decrypted Content: " + __decrypted_string + "\n");
                  __fileWriter.close();
            } catch (final IOException ioException) {
                  System.out.println("Exception: " + ioException.toString());
            }
      }
}