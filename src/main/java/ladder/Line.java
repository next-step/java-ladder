package ladder;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_INDEX = 0;
    private static final int STEP_INTERVAL = 1;
    private final int size;
    private final List<Boolean> steps;

    public Line(List<Boolean> steps) {
        this.steps = steps;
        size = steps.size();
        validateLine();
    }

    public Line(int countOfStep, LadderGenerateStrategy generateStrategy) {
        steps = new ArrayList<>();
        size = countOfStep;

        for (int i = MIN_INDEX; i < size; i++) {
            Boolean step = !hasBeforeStep(i) && generateStrategy.generate();
            steps.add(step);
        }
    }

    private boolean hasBeforeStep(int pointIndex) {
        return pointIndex > 0 && steps.get(pointIndex - STEP_INTERVAL);
    }

    private void validateLine() {
        boolean hasInvalidStep = IntStream.range(MIN_INDEX, size)
                                        .anyMatch(i -> steps.get(i) && hasBeforeStep(i));

        if (hasInvalidStep) {
            throw new IllegalArgumentException("인접한 사다리 다리가 있습니다.");
        }
    }

    public boolean hasStepBetween(int left, int right) {
        if (right - left != STEP_INTERVAL) {
            return false;
        }

        return steps.get(left);
    }

    public List<Boolean> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return size == line.size &&
                Objects.equals(steps, line.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, steps);
    }

}
