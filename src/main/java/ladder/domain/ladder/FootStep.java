package ladder.domain.ladder;

import ladder.strategy.StepRandomStrategy;
import ladder.strategy.StepStrategy;

import java.util.ArrayList;
import java.util.List;

public class FootStep {
    private static final int MIN_COUNT_OF_USER = 2;
    private final List<Boolean> steps = new ArrayList<>();

    public FootStep(int countOfUser) {
        this(countOfUser, new StepRandomStrategy());
    }

    public FootStep(int countOfUser, StepStrategy stepStrategy) {
        validate(countOfUser);

        for (int i = 1; i < countOfUser; i++) {
            steps.add(stepStrategy.nextStep());
        }
    }

    private void validate(int countOfUser) {
        if (countOfUser < MIN_COUNT_OF_USER) {
            throw new IllegalArgumentException("FootStep을 생성할 수 없습니다.");
        }
    }

    public List<Boolean> getSteps() {
        return steps;
    }
}
