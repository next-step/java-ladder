package ladder;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_INDEX = 0;
    private static final int STEP_INTERVAL = 1;
    private final int size;

    private List<Boolean> steps = new ArrayList<>();

    public Line(int size, MakingStepCondition condition) {
        this.size = size;

        for (int i = MIN_INDEX; i < size; i++) {
            Boolean point = !hasBeforeStep(i) && condition.makeStep();
            steps.add(point);
        }
    }

    public Line(List<Boolean> steps) {
        this.steps = steps;
        this.size = steps.size();
        validateLine();
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

    public boolean canSwapLocation(int left, int right) {
        if (right - left != STEP_INTERVAL) {
            return false;
        }

        return steps.get(left);
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
