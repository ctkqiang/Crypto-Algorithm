package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class __sha_512_model {
      protected static String __algorithm = "SHA-512";
      protected static String __type = "AES";
      private static SecretKeySpec __secretKey;
      private static byte[] __key;
      private static int __Bitlength = 16;

      public static void __setKey(String __theKey) {
            MessageDigest __SHA = null;
            try {
                  __key = __theKey.getBytes("UTF-8");
                  __SHA = MessageDigest.getInstance(__algorithm);
                  __key = __SHA.digest(__key);
                  __key = Arrays.copyOf(__key, __Bitlength);
                  __secretKey = new SecretKeySpec(__key, __type);
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                  noSuchAlgorithmException.printStackTrace();
            } catch (Exception _exception) {
                  _exception.printStackTrace();
            }
      }

      public static String __encrypt(String _stringToEncrypt, String __Secret) {
            Cipher _cipher;
            String _transformation = "AES/ECB/PKCS5Padding";
            try {
                  __setKey(__Secret);
                  _cipher = Cipher.getInstance(_transformation);
                  _cipher.init(Cipher.ENCRYPT_MODE, __secretKey);
                  return Base64.getEncoder().encodeToString(_cipher.doFinal(_stringToEncrypt.getBytes("UTF-8")));
            } catch (Exception __exception) {
                  __exception.printStackTrace();
            }
            return null;
      }

      public static String __decrypt(String _stringTodecrypt, String __Secret) {
            Cipher _cipher;
            String _transformation = "AES/ECB/PKCS5PADDING";
            try {
                  __setKey(__Secret);
                  _cipher = Cipher.getInstance(_transformation);
                  _cipher.init(Cipher.DECRYPT_MODE, __secretKey);
                  return new String(_cipher.doFinal(Base64.getDecoder().decode(_stringTodecrypt)));
            } catch (Exception _exception) {
                  _exception.printStackTrace();
            }
            return null;
      }
}