package ladder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRungGenerator extends RungGenerator {

    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int countOfPlayers) {
        List<Boolean> rungs = new ArrayList<>();

        for(int i = 0; i < countOfPlayers; i++) {
            boolean previousValue = getPreviousValue(rungs);
            rungs.add(generate(randomRule(previousValue)));
        }
        return rungs;
    }

    boolean randomRule(boolean previousValue) {
        if (previousValue) {
            return false;
        }
        return random.nextBoolean();
    }
}
