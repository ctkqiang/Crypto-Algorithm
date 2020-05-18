#include <stdio.h>
#include <math.h>


long long int power (long long int a, long long int b, long long int p) {
    if (b == 1) {
        return a;
    } else {
        return (((long long int)pow(a, b)) % p);
    }
}

int main () {
    long long int P, G, x, a, y, b, ka, kb;

    P = 23;
    G = 9;
    a = 4;
    b = 3;
    printf("The $P Value: " + P);
    printf("The $G value " + G);
    printf("The private Key for [Alice]: %lld\n", a);
    printf("The private Key for [Bob]: %lld\n", b);

    x = power(G, a, P);
    y = power(G, b, P);
    ka = power(y, a, P);
    kb = power(x, b, P);
    printf("The Secret Key for [Alice]: %lld\n", ka);
    printf("The Sewcret Key for [Bob]: %lld\n", kb);

    return 0;
}