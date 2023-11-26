package nextstep.ladder.domain;

import java.util.Random;

public class RowCalculator implements LineCountCalculator {

    private Random random = new Random();

    @Override
    public int calculate(int participantCount) {
        return random.nextInt(participantCount);
    }
}
