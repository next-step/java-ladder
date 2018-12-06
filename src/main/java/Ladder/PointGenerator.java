package Ladder;

import java.util.Random;

public class PointGenerator {

    public static boolean generatePoint() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
