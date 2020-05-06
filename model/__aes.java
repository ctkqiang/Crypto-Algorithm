package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class __aes {
      public static SecretKeySpec __secret_key;
      public static byte[] __key;

      public static void _setKey(String __mykey) {
            MessageDigest __SHA;
            String __SHA_Alogirthm, __key_specification;
            int __hashes_length;
            __SHA = null;
            __SHA_Alogirthm = "SHA-256";
            __key_specification = "AES";
            __hashes_length = 16;

            try {
                  __key = __mykey.getBytes("UTF-8");
                  __SHA = MessageDigest.getInstance(__SHA_Alogirthm);
                  __key = __SHA.digest(__key);
                  __key = Arrays.copyOf(__key, __hashes_length);
                  __secret_key = new SecretKeySpec(__key, __key_specification);
            } catch (NoSuchAlgorithmException e) {
                  e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
            }
      }

      // @Method: Encryption:
      public static String __encrypt(String __string_to_encrypt, String __secret) {
            try {
                  String __tranformation;
                  __tranformation = "AES/ECB/PKCS5Padding";
                  _setKey(__secret);
                  Cipher __cipher = Cipher.getInstance(__tranformation);
                  __cipher.init(Cipher.ENCRYPT_MODE, __secret_key);
                  return Base64.getEncoder().encodeToString(__cipher.doFinal(__string_to_encrypt.getBytes("UTF-8")));
            } catch (Exception e) {
                  System.out.println("Error while encrypting: " + e.toString());
            }
            return null;
      }

      // @Method: Decryption:
      public static String __decrypt(String __string_to_decrypt,  String __secret) {
            try {
                  String __transformation;
                  __transformation = "AES/ECB/PKCS5PADDING";
                  _setKey(__secret);
                  Cipher __cipher = Cipher.getInstance(__transformation);
                  __cipher.init(Cipher.DECRYPT_MODE,  __secret_key);
                  return new String(__cipher.doFinal(Base64.getDecoder().decode(__string_to_decrypt)));
            } catch (Exception exception) {
                  System.out.println("Error while decrypting: " + exception.toString());
            }
            return null;
      }
}