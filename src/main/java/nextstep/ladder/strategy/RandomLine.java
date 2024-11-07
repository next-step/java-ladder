package nextstep.ladder.strategy;

import nextstep.ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLine implements LineCreatableStrategy {
    private final Random random = new Random();

    @Override
    public Line create(final int countOfPerson) {
        boolean previous = false;
        int sizePoints = countOfPerson - 1;
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < sizePoints; i++) {
            boolean current = random.nextBoolean();
            current = isTrueContinuous(current, previous);
            points.add(current);
            previous = current;
        }

        return new Line(points);
    }

    private boolean isTrueContinuous(boolean current, boolean previous) {
        return !previous || !current;
    }
}
