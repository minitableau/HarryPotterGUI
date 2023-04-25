package utils;

import java.util.Random;

public class MathUtils {

    public static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int random(int max) {
        return random(0, max);
    }
}
