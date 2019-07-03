package ladder.util;

import ladder.model.Rung;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRungGenerator extends RungGenerator {

    private final Random random = new Random();

    @Override
    public List<Rung> generate(int countOfPlayers) {
        List<Rung> rungs = new ArrayList<>();

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
