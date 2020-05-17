import 'dart:io';
import 'package:aes_crypt/aes_crypt.dart';

/**
 * @Algorithm: first encryption of context (file) ==> 
 * decrypt based on extension ==>
 */

var __file_dir;
var __de_file_dir;
var __complete = "Completed";
var __crypt = AesCrypt();
__cryptographic_algorithm_encryption __ca__ =
    new __cryptographic_algorithm_encryption();
__cryptographic_algorithm_decryption __cd__ =
    new __cryptographic_algorithm_decryption();

void main() {
  __get_user_input __onstart = new __get_user_input();
  __onstart.__welcome();
}

class __get_user_input {
  void __welcome() {
    stdout.write("Please select option \n [ENCRYPT] || [DECRYPT]?  {e/d}: \n");
    var __user_choice = stdin.readLineSync();
    if (__user_choice == "e") {
      __ca__.__encryption();
    } else if (__user_choice == "d") {
      __cd__.__decryption();
    } else {
      print("Please input a valid option {e/d} ");
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
    print(__complete);
  }

  void __encryption_picture() {
    var __output = "encrypted_image.aes";
    __crypt.setOverwriteMode(AesCryptOwMode.on);
    __crypt.encryptFileSync(__file_dir, __output);
    print(__complete);
  }

  void __encryption_audio() {
    var __output = "encrypted_audio.aes";
    __crypt.setOverwriteMode(AesCryptOwMode.on);
    __crypt.encryptFileSync(__file_dir, __output);
    print(__complete);
  }

  void __encryption_file() {
    var __output = "encrypted_file.aes";
    __crypt.setOverwriteMode(AesCryptOwMode.on);
    __crypt.encryptFileSync(__file_dir, __output);
    print(__complete);
  }
}

class __cryptographic_algorithm_decryption {
  void __decryption() {
    stdout.write("Input Password: ");
    var __password = stdin.readLineSync();
    __crypt.setPassword(__password);
    stdout.write(
        "Input directory: [.txt, .jpg, .png, .mp3, .pdf, etc] for decryption: \n");
    __de_file_dir = stdin.readLineSync();
    if (__de_file_dir.contains("text")) {
      __decryption_text();
    } else if (__de_file_dir.contains("image")) {
      __decryption_image();
    } else if (__de_file_dir.contains("audio")) {
      __decryption_audio();
    } else if (__de_file_dir.contains("file")) {
      __decryption_file();
    } else {
      print("Please input a valid {file} extension.");
    }
  }

  void __decryption_text() {
    var __output = "encrypted_text.txt";
    __crypt.decryptFileSync(__de_file_dir, __output);
    print(__complete);
  }

  void __decryption_image() {
    var __output = "encrypted_image.png";
    __crypt.decryptFileSync(__de_file_dir, __output);
    print(__complete);
  }

  void __decryption_audio() {
    var __output = "encrypted_audio.mp3";
    __crypt.decryptFileSync(__de_file_dir, __output);
    print(__complete);
  }

  void __decryption_file() {
    var __output = "encrypted_file.pdf";
    __crypt.decryptFileSync(__de_file_dir, __output);
    print(__complete);
  }
}
