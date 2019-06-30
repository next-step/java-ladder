package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRungsGenerator {

    private List<Boolean> rungs = new ArrayList<>();
    private Random random = new Random();

    public List<Boolean> generate(int count) {

        for (int i = 0; i < count; i++) {
            rungs.add(randomRule(getPreviousValue()));
        }
        return rungs;
    }

    private Boolean getPreviousValue() {
        if (rungs.isEmpty()) {
            return false;
        }
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
