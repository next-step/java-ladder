package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_INDEX = 0;
    private static final int STEP_INTERVAL = 1;

    private final List<Boolean> steps;

    public Line(int countOfStep, LadderGenerateStrategy generateStrategy) {
        steps = new ArrayList<>();

        for (int i = MIN_INDEX; i < countOfStep; i++) {
            Boolean step = !hasBeforeStep(i) && generateStrategy.generate();
            steps.add(step);
        }
    }

    private boolean hasBeforeStep(int pointIndex) {
        return pointIndex > 0 && steps.get(pointIndex - STEP_INTERVAL);
    }

    private void validateLine(List<Boolean> steps) {
        boolean hasInvalidStep = IntStream.range(MIN_INDEX, steps.size())
                                        .anyMatch(i -> steps.get(i) && hasBeforeStep(i));

        if (hasInvalidStep) {
            throw new IllegalArgumentException("인접한 사다리 다리가 있습니다.");
        }
    }

    public List<Boolean> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    private boolean hasNextStep(int pointIndex) {
        validateIndex(pointIndex);
        return steps.get(pointIndex);
    }

    private void validateIndex(int pointIndex) {
        if (pointIndex < 0 || pointIndex >= steps.size()) {
            throw new IllegalArgumentException("index가 사다리 범위를 벗어났습니다.");
        }
    }

    public void processLine(Users users) {
        IntStream.range(0, steps.size())
                .filter(this::hasNextStep)
                .forEach(i -> users.swapUserPoint(i, i + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(steps, line.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }

}
