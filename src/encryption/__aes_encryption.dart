/**
 * Copyright 2020 © John Melody Me
 * Licensed under the John Melody Me, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    _crypt.decryptFileSync(_file_dir_decrypt, "decrypted_file.png");
  }
}
