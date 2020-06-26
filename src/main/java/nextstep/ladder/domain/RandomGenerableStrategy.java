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
        List<Boolean> ladders = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            ladders.add(false);
        }

        for (int i = 0; i < length; ++i) {
            putLadder(ladders, i);
        }
        return ladders;
    }

    private void putLadder(List<Boolean> ladders, int currentPosition) {
        Boolean hasCurrentLadder = random.nextBoolean();

        if (!hasCurrentLadder) {
            return;
        }
        if (hasPreviousPositionLadder(ladders, currentPosition)) {
            return;
        }
        if (hasNextPositionLadder(ladders, currentPosition)) {
            return;
        }

        ladders.set(currentPosition, true);
    }

    private boolean hasPreviousPositionLadder(List<Boolean> ladders, int currentPosition) {
        int previousPosition = currentPosition - 1;
        if (previousPosition >= 0 && ladders.get(previousPosition)) {
            return true;
        }
        return false;
    }

    private boolean hasNextPositionLadder(List<Boolean> ladders, int currentPosition) {
        int nextPosition = currentPosition + 1;
        if (nextPosition < ladders.size() - 1 && ladders.get(nextPosition)) {
            return true;
        }
        return false;
    }
}
