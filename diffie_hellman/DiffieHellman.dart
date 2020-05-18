import './model/Diffie_Hellman_base.dart';

/**
 * Lets Hav [Alice] and [Bob] in the performace :
 */

main() {
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
