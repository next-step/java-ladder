package laddergame.service;

import java.util.Random;

public class LadderPointGenerator{
    private static Random random = new Random();

    public static Boolean generatePoint() {
        return random.nextBoolean();
    }
}