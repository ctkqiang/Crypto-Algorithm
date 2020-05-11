import 'dart:io';
import 'package:aes_crypt/aes_crypt.dart';

void main() {
  stdout.write("[ENCRYPT] || [DECRYPT]?  {e/d}: \n");
  var __user_choice = stdin.readLineSync();
  __function __encrypt = new __function();
  if (__user_choice == "e") {
    __encrypt.__encrypt();
  } else if (__user_choice == "d") {
    __encrypt.__decrypt();
  } else {
    print("Please input a valid {choice}?");
    exit(0);
  }
}

class __function {
  static var _crypt = AesCrypt();
  void __encrypt() {
    stdout.write("Input password: ");
    var _user_input = stdin.readLineSync();
    _crypt.setPassword(_user_input);
    stdout.write("Input File for encryption {path}: ");
    var _file_dir = stdin.readLineSync();
    _crypt.setOverwriteMode(AesCryptOwMode.on);
    _crypt.encryptFileSync(_file_dir, "encrypted.aes");
  
  }

  void __decrypt() {
    stdout.write("Input password: ");
    var _user_input = stdin.readLineSync();
    _crypt.setPassword(_user_input);
    stdout.write("Input File decryption {path}: ");
    var _file_dir_decrypt = stdin.readLineSync();
    _crypt.decryptFileSync(_file_dir_decrypt, "decrypted_file.txt");
  }
}
