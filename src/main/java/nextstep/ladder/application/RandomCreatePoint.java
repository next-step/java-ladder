package nextstep.ladder.application;

import java.util.Random;

public class RandomCreatePoint implements CreatePointStrategy{
    private static RandomCreatePoint randomCreatePoint = new RandomCreatePoint();
    private static final int MAX = 10;
    private static final int DRAW_NUM = 5;
    private static Random random = new Random();

    private RandomCreatePoint() {
    }

    public boolean isDraw() {
        return random.nextInt(MAX)>=DRAW_NUM;
    }

    public static CreatePointStrategy of() {
        return randomCreatePoint;
    }
}
