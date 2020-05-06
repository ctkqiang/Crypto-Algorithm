package src;

import java.util.Scanner;
import model.__aes;

public class __main {
      public static void main(final String[] args) {
            __welcome_method();
            final Scanner __get_user_input = new Scanner(System.in);
            String __secret_key, __user_input, __original_string, __encrypted_string, __decrypted_string;
            __secret_key = "this_is_a_secret_Key";
            __user_input = __get_user_input.nextLine();
            __original_string = __user_input;
            __encrypted_string = __aes.__encrypt(__original_string, __secret_key);
            __decrypted_string = __aes.__decrypt(__encrypted_string, __secret_key);
            System.out.println("The Secret Key: " + __secret_key);
            System.out.println("The Original Content: " + __original_string);
            System.out.println("The Encrypted Content: " + __encrypted_string);
            System.out.println("The Decrypted Content: " + __decrypted_string);
            __get_user_input.close();
      }

      private static void __welcome_method() {
          System.out.println("Please enter the input {string}: ");
      }
}