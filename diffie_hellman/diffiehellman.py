#     Copyright 2020 © John Melody Me
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#             http://www.apache.org/licenses/LICENSE-2.0
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# @Author : John Melody Me
# @Copyright: John Melody Me & Tan Sin Dee © Copyright 2020

import random
import hashlib as HL
import sys

g = 9
p = 1001

a = random.randint(5, 10)
b = random.randint(10, 20)

A = (g ** a) % p
B = (g ** b) % p


def main():
    print('g: ', g, ' (a shared value), n: ', p, ' (a prime number)')
    print('\nAlice calculates:')
    print('a (Alice random): ', a)
    print('Alice value (A): ', A, ' (g^a) mod p')

    print('\nBob calculates:')
    print('b (Bob random): ', b)
    print('Bob value (B): ', B, ' (g^b) mod p')

    print('\nAlice calculates:')
    keyA = (B**a) % p
    print('Key: ', keyA, ' (B^a) mod p')
    print('Key: ', HL.sha256(str(keyA).encode()).hexdigest())

    print('\nBob calculates:')
    keyB = (A**b) % p
    print('Key: ', keyB, ' (A^b) mod p')
    print('Key: ', HL.sha256(str(keyB).encode()).hexdigest())


if __name__ == "__main__":
    main()
