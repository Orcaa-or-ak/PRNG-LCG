import java.math.BigInteger;
import java.security.SecureRandom;

public class LinearCongruentialGenerator {
    private BigInteger a;
    private BigInteger c;
    private BigInteger m;
    private BigInteger seed;

    public LinearCongruentialGenerator(BigInteger a, BigInteger c, BigInteger m, BigInteger seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
    }

    public BigInteger next() {
        seed = (a.multiply(seed).add(c)).mod(m);
        return seed;
    }

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();

        // Generate parameters for the LCG
        int bitLength = 1024;
        BigInteger a = new BigInteger(bitLength, secureRandom);
        BigInteger c = new BigInteger(bitLength, secureRandom);
        BigInteger m = BigInteger.probablePrime(bitLength, secureRandom);
        BigInteger seed = new BigInteger(bitLength, secureRandom);

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator(a, c, m, seed);

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();

        // Generate and print 10 random numbers along with CPU, RAM, and time cost
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            BigInteger randomNumber = lcg.next();
            long endTime = System.nanoTime();
            double timeTakenMs = (endTime - startTime) / 1_000_000.0;
            double usedMemoryMb = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0);

            System.out.println("Random Number: " + randomNumber);
            System.out.println("Bit Length: " + randomNumber.bitLength());
            System.out.println("Time taken: " + timeTakenMs + " ms");
            System.out.println("Used Memory: " + usedMemoryMb + " MB");
            System.out.println();
        }
    }
}
