package ladder.model;

import java.util.List;
import java.util.Objects;

public class Line {

    private final Steps steps;

    public Line(int countOfSteps, LadderGenerateStrategy generateStrategy) {
        steps = Steps.of(countOfSteps, generateStrategy);
    }

    public int movePoint(int pointIndex) {
        return steps.move(pointIndex);
    }

    public List<Step> getSteps() {
        return steps.getSteps();
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
