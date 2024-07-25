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
        seed = (a.multiply(seed).add(c)).mod(m); //LCG formula
        return seed;
    }

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
}
