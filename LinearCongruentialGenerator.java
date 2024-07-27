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
        int bitLength = 2048;
        BigInteger a = new BigInteger(bitLength, secureRandom);
        BigInteger c = new BigInteger(bitLength, secureRandom);
        BigInteger m = BigInteger.probablePrime(bitLength, secureRandom);
        BigInteger seed = new BigInteger(bitLength, secureRandom);

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator(a, c, m, seed);

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();

        // Generate and print 10 random numbers along with CPU, RAM, and time cost
        for (int i = 0; i < 10; i++) {
            // Measure start time and memory usage
            long startTime = System.nanoTime();
            long startMemory = runtime.totalMemory() - runtime.freeMemory();

            // Generate 1000 random numbers
            for (int z = 0; z < 1000; z++) {
                lcg.next();
            }
            
            // Measure end time and memory usage
            long endTime = System.nanoTime();
            long endMemory = runtime.totalMemory() - runtime.freeMemory();
            
            // Calculate total time taken and memory used
            double totalTimeTakenMs = (endTime - startTime) / 1_000_000.0;
            long totalUsedMemoryBytes = endMemory - startMemory;

            // Calculate average time and memory used per number
            double averageTimeTakenMs = totalTimeTakenMs / 1000;
            double averageUsedMemoryBytes = totalUsedMemoryBytes / 1000.0;

            // Generate one final random number to print
            BigInteger randomNumber = lcg.next();

            System.out.println("Random Number: " + randomNumber);
            System.out.println("Bit Length: " + randomNumber.bitLength());
            System.out.println("Average Time taken: " + averageTimeTakenMs + " ms");
            System.out.println("Average Used Memory: " + averageUsedMemoryBytes + " Bytes");
            System.out.println();
        }
    }
}
