
# Linear Congruential Generator (LCG)

This project demonstrates the implementation of a Linear Congruential Generator (LCG) in Java. LCG is a simple and classic Pseudorandom-Number Generator algorithm.

## Overview

The LCG algorithm is defined by the recurrence relation:

$$
X_{n+1} = (a \cdot X_n + c) \mod m
$$

Where:
- $\(X\)$ is the sequence of pseudorandom values,
- $\(a\)$ is the multiplier,
- $\(c\)$ is the increment,
- $\(m\)$ is the modulus,
- $\(X_0\)$ is the seed or starting value.

## Implementation

The Java implementation of the LCG is encapsulated in a class named `LinearCongruentialGenerator`.

### Class: `LinearCongruentialGenerator`

- **Fields**:
  - `private long a;`
  - `private long c;`
  - `private long m;`
  - `private long seed;`

- **Constructor**:
  ```java
  public LinearCongruentialGenerator(long a, long c, long m, long seed) {
      this.a = a;
      this.c = c;
      this.m = m;
      this.seed = seed;
  }
  ```

- **Method**:
  - `public long next()`: Computes and returns the next number in the sequence using the LCG formula.

### Main Method

The `main` method demonstrates how to use the `LinearCongruentialGenerator` class to generate and print 10 pseudorandom numbers.

```java
public class LinearCongruentialGenerator {
    private long a;
    private long c;
    private long m;
    private long seed;

    public LinearCongruentialGenerator(long a, long c, long m, long seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
    }

    public long next() {
        seed = (a * seed + c) % m;
        return seed;
    }

    public static void main(String[] args) {
        // Parameters for the LCG
        long a = 1664525;
        long c = 1013904223;
        long m = (long) Math.pow(2, 32);
        long seed = 42; // Initial seed

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator(a, c, m, seed);

        // Generate and print 10 random numbers
        for (int i = 0; i < 10; i++) {
            System.out.println(lcg.next());
        }
    }
}
```

This will generate and print 10 pseudorandom numbers based on the LCG algorithm.

## Parameters

The default parameters used in this implementation are:
- Multiplier (`a`): 1664525
- Increment (`c`): 1013904223
- Modulus (`m`): \(2^{32}\)
- Initial seed  $\(X_0\)$ (`seed`): 42
