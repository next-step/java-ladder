package nextstep.step3.domain.strategy;

import java.util.List;
import java.util.Random;

public class RandomDrawLineStrategy implements DrawLineStrategy {
    private static final int FIRST_INDEX = 0;
    private Random random = new Random();

    @Override
    public boolean isDrawLine(List<Boolean> points, int idx) {
        if(idx == FIRST_INDEX) {
            return random.nextBoolean();
        }
        return !points.get(idx - 1) && random.nextBoolean();
    }
}
