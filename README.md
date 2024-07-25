
# Linear Congruential Generator (LCG)

This project demonstrates the implementation of a Linear Congruential Generator (LCG) in Java.

## Overview

The LCG algorithm is defined by the recurrence relation:

$$
X_{n+1} = (a \cdot X_n + c) \mod m
$$

Where:
- $X$ is the sequence of pseudorandom values,
- $X_0$ is the seed or starting value.
- $X_{n+1}$ is the next number in sequence,
- $a$ is the multiplier,
- $c$ is the increment,
- $m$ is the modulus,

## Implementation

The Java implementation of the LCG is encapsulated in a class named `LinearCongruentialGenerator`. The BigInteger class of the java.math package is used to handle large integer and the SecureRandom class of the java.security package is used to generates strong numbers. These two classes are suitale for cryptographic purposes.

### Class: `LinearCongruentialGenerator`

- **Constructor**:
  ```java
  public LinearCongruentialGenerator(BigInteger a, BigInteger c, BigInteger m, BigInteger seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
    }
  ```

- **Method**:
  - `public BigInteger next()`: Computes and returns the next number in the sequence using the LCG formula.

### Main Method

The `main` method demonstrates how to use the `LinearCongruentialGenerator` class to generate and print 10 pseudorandom numbers.

```java
public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        
        // Generate parameters for the LCG
        int BitLength = 512;
        BigInteger a = new BigInteger(BitLength, secureRandom);
        BigInteger c = new BigInteger(BitLength, secureRandom);
        BigInteger m = BigInteger.probablePrime(BitLength, secureRandom);
        BigInteger seed = new BigInteger(BitLength, secureRandom);

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator(a, c, m, seed);

        // Generate and print 10 random numbers
        for (int i = 0; i < 10; i++) {
            System.out.println(lcg.next());
            System.out.println();
        }
    }
```

This will generate and print 10 pseudorandom numbers based on the LCG algorithm.
