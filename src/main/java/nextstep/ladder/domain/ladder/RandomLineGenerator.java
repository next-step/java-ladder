package nextstep.ladder.domain.ladder;

import java.util.Random;

public class RandomLineGenerator {

    private static final Random RANDOM = new Random();

    private final int minimumPosition;
    private final int maximumPosition;

    public RandomLineGenerator(int minimumPosition, int maximumPosition) {
        this.minimumPosition = minimumPosition;
        this.maximumPosition = maximumPosition;
    }

    public Line generate(int position) {
        return null;
    }
}
