package step03.domain;

import exception.InvalidCountOfStepsException;
import strategy.PointStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Steps {
    private final List<Step> steps;

    private Steps(List<Step> steps) {
        this.steps = steps;
    }

    public static Steps of(Integer countOfSteps, PointStrategy pointStrategy) {
        validate(countOfSteps);
        return new Steps(init(countOfSteps, pointStrategy));
    }
    private static List<Step> init(Integer countOfSteps, PointStrategy pointStrategy) {
        return Stream.generate(() -> Step.of(countOfSteps, pointStrategy))
                .limit(countOfSteps)
                .collect(Collectors.toList());
    }

    private static void validate(Integer countOfSteps) {
        if (countOfSteps < 1)
            throw new InvalidCountOfStepsException();
    }

    public List<List<Boolean>> getSteps() {
        return steps.stream()
                .map(Step::getPoints)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Steps steps1 = (Steps) o;
        return Objects.equals(steps, steps1.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }
}
