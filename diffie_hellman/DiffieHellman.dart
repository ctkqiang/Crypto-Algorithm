import './model/Diffie_Hellman_base.dart';

/**
 * @Copyright  2020 © John Melody Me
 * Licensed under the John Melody Me, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

main() {

  /**
 * Lets Have [Alice] and [Bob] in the performace :
 */
  __generateKey __prototype__ = new __generateKey();
  __prototype__.Alice();
  __prototype__.Bob();
  __prototype__.__output__();
}

class __generateKey {
  static String __alice_Public_key, __bob_Public_key;
  static int __secretKey_one, __secretKey_two;
  static DHellmanGroup __alice, __bob;
  static John_Deffie_hellman_Key __aliceKey, __bobKey;

  void Alice() {
    __alice = new DHellmanGroup.byGroupId(1,1);
    __aliceKey = __alice.generateKey();
    __alice_Public_key = __aliceKey.publicKey;
  }

  void Bob() {
    __bob = new DHellmanGroup.byGroupId(__alice.prime, __alice.generator);
    __bobKey = __bob.generateKey();
    __bob_Public_key = __bobKey.publicKey;
  }

  void __output__() {
    __secretKey_one = __aliceKey.computeKey(
        new John_Deffie_hellman_Key.fromPublicKey(__bob_Public_key));
    __secretKey_two = __bobKey.computeKey(
        new John_Deffie_hellman_Key.fromPublicKey(__alice_Public_key));

    print(__secretKey_one);
    print(__secretKey_one == __secretKey_two);
  }
}
