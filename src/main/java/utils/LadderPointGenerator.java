package utils;

import domain.Difficult;

import java.util.Random;

public class LadderPointGenerator {
    private static Random random = new Random();

    public static boolean generatePoint(Difficult difficult) {
        return random.nextInt(difficult.getHeight()) > difficult.getRandom();
    }
}
