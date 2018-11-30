package Ladder;

import java.util.Random;

public class PointGenerator {

    public Point getRandomBoolean() {
        Random random = new Random();
        return Point.of(random.nextBoolean());
    }
}
