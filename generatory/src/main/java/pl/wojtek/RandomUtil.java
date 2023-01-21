package pl.wojtek;

import java.util.Random;

public class RandomUtil {
    private static final Random rand = new Random();


    public static int getRandInt(int min, int max) throws IllegalArgumentException {
        return rand.nextInt(max - min + 1) + min;
    }



    public static double getRandDouble(double min, double max) throws IllegalArgumentException {
        return (rand.nextDouble() * (max - min)) + min;
    }

    public static float getRandFloat(float min, float max) throws IllegalArgumentException {
        return (rand.nextFloat() * (max - min)) + min;
    }

    public static long getRandLong(long min, long max) throws IllegalArgumentException {
        return min + (long) (Math.random() * (max - min));
    }
}
