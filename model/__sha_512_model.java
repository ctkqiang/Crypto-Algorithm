package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class __sha_512_model {
      protected static String __algorithm = "SHA-512";

      public static String __encryptString(String __input) {
            try {
                  MessageDigest __messageDigest = MessageDigest.getInstance(__algorithm);
                  byte[] __messageDisgest = __messageDigest.digest(__input.getBytes());
                  // Convert byte array into Signum:
                  BigInteger _num = new BigInteger(1, __messageDisgest);
                  // Convert __messageDigest to Hex:
                  String __hashText = _num.toString(16);
                  // Add preceding 0s to make it 32 bit
                  while (__hashText.length() < 32) {
                        __hashText = "0" + __hashText;
                  }
                  return __hashText;
            } catch (NoSuchAlgorithmException __no_such_stupid_algorithm) {
                  throw new RuntimeException(__no_such_stupid_algorithm);
            }

      }
}