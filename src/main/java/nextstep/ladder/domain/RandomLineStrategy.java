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

        for (int i = 1; i < countOfUsers; i++) {
            floor.add(getNextRandomStepType(random));
        }

        return Line.of(countOfUsers, floor);
    }

    private StepType getNextRandomStepType(Random random) {
        return StepType.from(random.nextBoolean());
    }
}
