package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStepStrategy implements StepStrategy {
    @Override
    public List<StepType> execute(int countOfUsers) {
        List<StepType> floor = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i < countOfUsers; i++) {
            floor.add(getNextRandomStepType(random));
        }

        return floor;
    }

    private StepType getNextRandomStepType(Random random) {
        return StepType.of(random.nextBoolean());
    }
}
