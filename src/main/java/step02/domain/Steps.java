package step02.domain;

import exception.InvalidCountOfStepsException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Steps {
    private final List<Step> steps;

    private Steps(List<Step> steps) {
        this.steps = steps;
    }

    public static Steps of(Integer countOfSteps, StepGenerator stepGenerator) {
        validate(countOfSteps);
        return new Steps(init(countOfSteps, stepGenerator));
    }
    private static List<Step> init(Integer countOfSteps, StepGenerator stepGenerator) {
        return Stream.generate(stepGenerator::generate)
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
                .collect(Collectors.toList());
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
