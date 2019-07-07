package ladderGame.util;

import ladderGame.domain.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {

    private final static Boolean FIRST_LIMITED_BOUNDARY = false;
    private final static Boolean LAST_LIMITED_BOUNDARY = false;

    private List<Boolean> rungs = new ArrayList<>();
    private Random random = new Random();

    public List<Direction> generate(int count) {

        rungs.add(FIRST_LIMITED_BOUNDARY);
        for (int i = 0; i < count; i++) {
            rungs.add(randomRule(getPreviousValue()));
        }
        rungs.add(LAST_LIMITED_BOUNDARY);
        return DirectionConvert.newInstance().parse(rungs);
    }

    private Boolean getPreviousValue() {
        return rungs.get(rungs.size() - 1);
    }

    private Boolean randomRule(boolean previousValue) {
        if (previousValue) {
            return false;
        }
        return getRandom();
    }

    private Boolean getRandom() {
        return random.nextBoolean();
    }
}
