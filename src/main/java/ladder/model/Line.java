package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_INDEX = 0;
    private static final int STEP_INTERVAL = 1;

    private final List<Boolean> steps;

    public Line(int countOfStep, LadderGenerateStrategy generateStrategy) {
        steps = new ArrayList<>();

        for (int i = MIN_INDEX; i < countOfStep; i++) {
            steps.add(generateStep(i, generateStrategy));
        }
    }

    private boolean generateStep(int pointIndex, LadderGenerateStrategy generateStrategy) {
        return !hasBeforeStep(pointIndex) && generateStrategy.generate();
    }

    private boolean hasBeforeStep(int pointIndex) {
        validateIndex(pointIndex);
        return pointIndex > 0 && steps.get(pointIndex - STEP_INTERVAL);
    }

    private boolean hasNextStep(int pointIndex) {
        validateIndex(pointIndex);
        return pointIndex < steps.size() && steps.get(pointIndex);
    }

    private void validateIndex(int pointIndex) {
        if (pointIndex < 0 || pointIndex > steps.size()) {
            throw new IllegalArgumentException("index가 사다리 범위를 벗어났습니다.");
        }
    }

    public List<Boolean> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    public int movePoint(int pointIndex) {
        if (hasNextStep(pointIndex)) {
            return pointIndex + 1;
        }
        if (hasBeforeStep(pointIndex)) {
            return pointIndex - 1;
        }
        return pointIndex;
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
