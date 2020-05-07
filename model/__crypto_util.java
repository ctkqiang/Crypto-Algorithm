package model;

import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class __crypto_util {
      private static String __algorithm = "AES";
      // private static String __secret_key = "ajklsasdkewpiuercjnnmdpop2w99s=";
      private static String __cipher_instance = "AES/CBC/PKCS5Paddin";
      // private static String __iv = "hashes";
      private static String __encryption_type = "MD6";

      public static String __encrypt_binary_file(String __key, String __iv, String __message) throws Exception {
            MessageDigest __MessageDigest = MessageDigest.getInstance(__encryption_type);
            byte[] _bytesKey, _keyBytes;
            _bytesKey = __key.getBytes("UTF-8");
            _keyBytes = __MessageDigest.digest(_bytesKey);

            final byte[] _iv_Bytes = __iv.getBytes();
            SecretKeySpec __secretKeySpec = new SecretKeySpec(_keyBytes, __algorithm);
            Cipher __cipher = Cipher.getInstance(__cipher_instance);
            __cipher.init(Cipher.ENCRYPT_MODE, __secretKeySpec, new IvParameterSpec(_iv_Bytes));

            final byte[] _resultBytes = __cipher.doFinal(__message.getBytes());
            return Base64.getMimeEncoder().encodeToString(_resultBytes);
      }

      public static String __decrypt_binary_file(String __key, String __iv, String __encrypted_message)
                  throws Exception {
            byte[] __bytes_key, __key_bytes;
            MessageDigest __MessageDigest = MessageDigest.getInstance(__encryption_type);
            __bytes_key = __key.getBytes("UTF-8");
            __key_bytes = __MessageDigest.digest(__bytes_key);

            final byte[] _iv_bytes, __encrypted_bytes;
            _iv_bytes = __iv.getBytes();
            __encrypted_bytes = Base64.getMimeDecoder().decode(__encrypted_message);

            SecretKeySpec __secretKeySpec = new SecretKeySpec(__key_bytes, __algorithm);
            Cipher __cipher = Cipher.getInstance(__cipher_instance);
            __cipher.init(Cipher.DECRYPT_MODE, __secretKeySpec, new IvParameterSpec(_iv_bytes));

            final byte[] __resultBytes = __cipher.doFinal(__encrypted_bytes);
            return new String(__resultBytes);
      }
}