package pl.wojtek;

public class RandomUtil {
    private static final java.util.Random rand = new java.util.Random();
    private static final char[] chars;

    static {
        chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static int getRandInt(int min, int max) throws IllegalArgumentException {
        return rand.nextInt(max - min + 1) + min;
    }

    public static double getRandDouble(double min, double max) throws IllegalArgumentException {
        return (rand.nextDouble() * (max - min)) + min;
    }

    public static float getRandFloat(float min, float max) throws IllegalArgumentException {
        return (rand.nextFloat() * (max - min)) + min;
    }

    public static boolean getChance(double chance) {
        return (chance >= 100) || (chance >= getRandDouble(0, 100));
    }

    public static String getRandomColor() {
        return "&" + chars[getRandInt(0, chars.length - 1)];
    }
}
