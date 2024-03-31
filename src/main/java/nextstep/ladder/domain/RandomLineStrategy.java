package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    @Override
    public Line execute(int countOfUsers) {
        List<StepType> floor = new ArrayList<>();
        Random random = new Random();

        floor.add(getNextRandomStepType(StepType.EMPTY, random));
        for (int i = 1; i < countOfUsers - 1; i++) {
            floor.add(getNextRandomStepType(floor.get(i - 1), random));
        }

        return Line.of(countOfUsers, floor);
    }

    private StepType getNextRandomStepType(StepType beforeStepType, Random random) {
        if (beforeStepType == StepType.STEP) {
            return StepType.EMPTY;
        }

        return StepType.from(random.nextBoolean());
    }
}
