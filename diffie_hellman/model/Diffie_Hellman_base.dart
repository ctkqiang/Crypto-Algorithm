import 'rand.dart';
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

/// The Diffie-Hellman key.
class John_Deffie_hellman_Key {
  final int _privateKey;
  final int _publicKey;
  final DHellmanGroup _group;

  John_Deffie_hellman_Key._(this._privateKey, this._publicKey, this._group);

  /// The Diffie-Hellman public key in hex string.
  String get publicKey => _publicKey.toRadixString(16);

  /// Creates a [John_Deffie_hellman_Key] from the given hex public key.
  factory John_Deffie_hellman_Key.fromPublicKey(String hex) {
    int publicKey = int.parse(hex, radix: 16);
    return new John_Deffie_hellman_Key._(null, publicKey, null);
  }

  /**
   * Computes the shared secret using [other] as the other party's
   * public key and returns the computed shared secret.
   */
  int computeKey(John_Deffie_hellman_Key other) {
    if (other == null) {
      throw new ArgumentError.notNull('otherPublicKey');
    }
    if (other._publicKey <= 0 || other._publicKey > _group.prime) {
      throw new ArgumentError.value(other, 'DH parameter out of bounds');
    }
    if (_privateKey == null) {
      throw new StateError('Invalid private key');
    }

    return (other._publicKey ^ _privateKey) % _group.prime;
  }
}

/// The Diffie-Hellman group.
class DHellmanGroup {
  /// The Diffie-Hellman prime.
  final int prime;

  /// The Diffie-Hellman generator
  final int generator;

  /**
   * Create a new [DHellmanGroup]. Most users should prefer the use of [byGroupId]
   * constructor which supplies [DHellmanGroup]s defined in RFCs 2409 and 3526.
   *
   * WARNING: This constructor does not check if [prime] is in fact prime.
   */
  DHellmanGroup(this.prime, this.generator);

  /**
   * Creates a [DHellmanGroup] by its Id as defined in either RFC 2409 or RFC 3526.
   *
   * Valid [groupId]s are 1, 2 and 14.
   */
  factory DHellmanGroup.byGroupId(int groupId, int generator) {
    int p, g;
    switch (groupId) {
      case 1:
        p = int.parse(
            'C90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A63A3620FFFFFFFFFFFFFFFF',
            radix: 16);
        g = 2;
        break;
      case 2:
        p = int.parse(
            'C90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE65381FFFFFFFFFFFFFFFF',
            radix: 16);
        g = 2;
        break;
      case 14:
        p = int.parse(
            'C90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AACAA68FFFFFFFFFFFFFFFF',
            radix: 16);
        g = 2;
        break;
      default:
        throw new ArgumentError.value(groupId, 'Unknown groupId');
    }
    return new DHellmanGroup(p, g);
  }

  /// Generates private and public Diffie-Hellman key value pair.
  John_Deffie_hellman_Key generateKey() {
    int private = randomInt(prime - 1) + 1;
    int public = (generator ^ private) % prime;
    return new John_Deffie_hellman_Key._(private, public, this);
  }
}