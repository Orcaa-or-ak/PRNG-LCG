# Linear Congruential Generator (LCG) in Java

This project demonstrates the implementation of a Linear Congruential Generator (LCG) in Java. LCG is a simple and classic pseudorandom number generator algorithm.

## Overview

The LCG algorithm is defined by the recurrence relation:

\[ X_{n+1} = (a \cdot X_n + c) \mod m \]

Where:
- \(X\) is the sequence of pseudorandom values,
- \(a\) is the multiplier,
- \(c\) is the increment,
- \(m\) is the modulus,
- \(X_0\) is the seed or starting value.

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
