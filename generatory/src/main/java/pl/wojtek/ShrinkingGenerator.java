package pl.wojtek;

import java.util.Random;

public class ShrinkingGenerator {
    private Random random;
    private int bound;

    public ShrinkingGenerator() {
        this.random = new Random();
        this.bound = Integer.MAX_VALUE;
    }

    public int nextInt() {
        int num = random.nextInt(bound);
        bound = Math.max(bound - 1, 0);
        return num;
    }

    public void reset() {
        bound = Integer.MAX_VALUE;
    }
}
