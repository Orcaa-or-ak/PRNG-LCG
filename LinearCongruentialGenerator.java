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
