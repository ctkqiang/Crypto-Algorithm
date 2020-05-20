package diffie_hellman;

import java.util.Scanner;

public class diffieHellmanlgorithm {
    private static Scanner __user_enter_modulus;
    private static int p, g, a, b, __alice, __bob;
    protected static int __secret_key_alice, __secret_key_bob;

    public static void main(String args[]) {
        __user_enter_modulus = new Scanner(System.in);
        System.out.println("Enter a {modulus}: "); 
        p = __user_enter_modulus.nextInt();
        System.out.println("Enter primitive root of " + p); // lets say 7
        g = __user_enter_modulus.nextInt();
        System.out.println("Enter Secret Number for [Alice] ==> ");
        a = __user_enter_modulus.nextInt();
        System.out.println("Enter Secret Number for [Bob] ==> ");
        b = __user_enter_modulus.nextInt();
        
        __alice = (int) Math.pow(g, a) % p;
        __bob = (int) Math.pow(g, b) % p;

        __secret_key_alice = (int) Math.pow(__bob, a) % p;
        __secret_key_bob = (int) Math.pow(__alice, b) % p;

        if (__secret_key_alice == __secret_key_bob) {
            System.out.println("Alice and Bob can communicate with each other.");
            System.out.println("They share the secret number of ===> " + __secret_key_alice);
        } else {
            System.out.println("Alice and Bob failed to communicate with each other.");
        }
    }
}