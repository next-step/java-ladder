package ladder.domain.ladder;

import ladder.strategy.StepRandomStrategy;
import ladder.strategy.StepStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_COUNT_OF_USER = 2;

    private final List<Boolean> steps = new ArrayList<>();

    private Line(int countOfUser) {
        this(countOfUser, new StepRandomStrategy());
    }

    private Line(int countOfUser, StepStrategy stepStrategy) {
        validate(countOfUser);

        IntStream.range(1, countOfUser)
                .forEach(i -> steps.add(stepStrategy.nextStep()));
    }

    public static Line of(int countOfUser) {
        return new Line(countOfUser);
    }

    public static Line byStrategy(int countOfUser, StepStrategy stepStrategy) {
        return new Line(countOfUser, stepStrategy);
    }

    private void validate(int countOfUser) {
        if (countOfUser < MIN_COUNT_OF_USER) {
            throw new IllegalArgumentException("Line을 생성할 수 없습니다.");
        }
    }

    public List<Boolean> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return this.steps.stream()
                .map(b -> b ? "-----" : "     ")
                .collect(Collectors.joining("|", "|", "|"));
    }
}
