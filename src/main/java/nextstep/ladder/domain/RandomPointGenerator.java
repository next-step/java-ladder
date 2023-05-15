package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private int startIdx, endIdx;

    public RandomPointGenerator(int startIdx, int endIdx) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    @Override
    public Point generate(boolean left, int x) {
        Random random = new Random();

        boolean right = false;
        if (x != endIdx && !left) {
            right = random.nextBoolean();
        }

        return new Point(left, right);
    }
}
