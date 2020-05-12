import 'dart:io';
import 'package:aes_crypt/aes_crypt.dart';

/**
 * @Algorithm: first encryption of context (file) ==> 
 * decrypt based on extension ==>
 */

var __file_dir;
var __de_file_dir;
var __crypt = AesCrypt();

void main() {
  __get_user_input __onstart = new __get_user_input();
  __onstart.__welcome();
}

class __get_user_input {
  void __welcome() {
    stdout.write("Please select option \n [ENCRYPT] || [DECRYPT]?  {e/d}: \n");
    var __user_choice = stdin.readLineSync();
    if (__user_choice == "e") {
      __cryptographic_algorithm_encryption __ca__ =
          new __cryptographic_algorithm_encryption();
      __ca__.__encryption();
    }
  }
}

class __cryptographic_algorithm_encryption {
  void __encryption() {
    stdout.write("Input Password: ");
    var __password = stdin.readLineSync();
    __crypt.setPassword(__password);
    stdout.write(
        "Input directory: [.txt, .jpg, .png, .mp3, .pdf, etc] for encryption: \n");
    __file_dir = stdin.readLineSync();
    if (__file_dir.contains(".txt")) {
      __encryption_text();
    } else if (__file_dir.contains(".jpg") ||
        __file_dir.contains(".png") ||
        __file_dir.contains(".jpeg")) {
      __encryption_picture();
    } else if (__file_dir.contains(".mp3") || __file_dir.contains(".ogg")) {
      __encryption_audio();
    } else if (__file_dir.contains(".pdf")) {
      __encryption_file();
    } else {
      print("Please input a valid {file} extension.");
    }
  }

  void __encryption_text() {
    var __output = "encrypted_text.aes";
    __crypt.setOverwriteMode(AesCryptOwMode.on);
    __crypt.encryptFileSync(__file_dir, __output);
  }

  void __encryption_picture() {
    var __output = "encrypted_image.aes";
    __crypt.setOverwriteMode(AesCryptOwMode.on);
    __crypt.encryptFileSync(__file_dir, __output);
  }

  void __encryption_audio() {
    var __output = "encrypted_audio.aes";
    __crypt.setOverwriteMode(AesCryptOwMode.on);
    __crypt.encryptFileSync(__file_dir, __output);
  }

  void __encryption_file() {
    var __output = "encrypted_file.aes";
    __crypt.setOverwriteMode(AesCryptOwMode.on);
    __crypt.encryptFileSync(__file_dir, __output);
  }
}

class __cryptographic_decryption {
  void __decryption() {
    stdout.write("Input Password: ");
    var __password = stdin.readLineSync();
    __crypt.setPassword(__password);
    stdout.write(
        "Input directory: [.txt, .jpg, .png, .mp3, .pdf, etc] for decryption: \n");
    __de_file_dir = stdin.readLineSync();
    if (__de_file_dir.contains(".txt")) {
      __decryption_text();
    } else if (__de_file_dir.contains(".jpg") ||
        __de_file_dir.contains(".jpeg") ||
        __de_file_dir.contains(".png")) {
      __decryption_image();
    } else if (__de_file_dir.contains(".mp3") ||
        __de_file_dir.contains(".ogg")) {
      __decryption_audio();
    } else if (__de_file_dir.contains(".pdf")) {
      __decryption_file();
    } else {
      print("Please input a valid {file} extension.");
    }
  }

  void __decryption_text() {
    var __output = "encrypted_text.txt";
    __crypt.decryptFileSync(__de_file_dir, __output);
  }

  void __decryption_image() {
    var __output = "encrypted_image.png";
    __crypt.decryptFileSync(__de_file_dir, __output);
  }

  void __decryption_audio() {
    var __output = "encrypted_audio.mp3";
    __crypt.decryptFileSync(__de_file_dir, __output);
  }

  void __decryption_file() {
    var __output = "encrypted_file.pdf";
    __crypt.decryptFileSync(__de_file_dir, __output);
  }
}
