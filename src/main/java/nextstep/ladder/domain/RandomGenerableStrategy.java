package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        int previousPosition = currentPosition - 1;
        int nextPosition = currentPosition + 1;
        if (hasCurrentLadder == false) {
            return;
        }
        if (previousPosition >= 0 && ladders.get(previousPosition)) {
            return;
        }
        if (nextPosition < ladders.size() - 1 && ladders.get(nextPosition)) {
            return;
        }

        ladders.set(currentPosition, true);
    }
}
