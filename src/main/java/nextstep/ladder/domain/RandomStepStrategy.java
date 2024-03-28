package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomStepStrategy implements StepStrategy {
    @Override
    public List<StepType> execute(int countOfUsers) {
        List<StepType> floor = new ArrayList<>();
        Random random = new Random();

        IntStream.range(1, countOfUsers)
                .forEach(index -> floor.add(getNextRandomStepType(random)));

        return floor;
    }

    private StepType getNextRandomStepType(Random random) {
        return StepType.of(random.nextBoolean());
    }
}
