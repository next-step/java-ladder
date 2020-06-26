package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerableStrategy implements GenerableStrategy {

    private Random random;

    public RandomGenerableStrategy() {
        random = new Random();
    }

    @Override
    public List<Boolean> generate(int length) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            points.add(false);
        }

        for (int i = 0; i < length; ++i) {
            putPoint(points, i);
        }
        return points;
    }

    private void putPoint(List<Boolean> points, int currentPosition) {
        Boolean hasCurrentLadder = random.nextBoolean();

        if (!hasCurrentLadder) {
            return;
        }
        if (hasPreviousPositionPoint(points, currentPosition)) {
            return;
        }
        if (hasNextPositionPoint(points, currentPosition)) {
            return;
        }

        points.set(currentPosition, true);
    }

    private boolean hasPreviousPositionPoint(List<Boolean> points, int currentPosition) {
        int previousPosition = currentPosition - 1;
        if (previousPosition >= 0 && points.get(previousPosition)) {
            return true;
        }
        return false;
    }

    private boolean hasNextPositionPoint(List<Boolean> points, int currentPosition) {
        int nextPosition = currentPosition + 1;
        if (nextPosition < points.size() - 1 && points.get(nextPosition)) {
            return true;
        }
        return false;
    }
}
