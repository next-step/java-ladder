package nextstep.ladder.model;

import java.util.Objects;

public class Point {
    private boolean value;
    private LineGenerator lineGenerator;

    public Point(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Point(boolean value) {
        this.value = value;
    }

    public void next(boolean hasPreviousLine) {
        this.value = !hasPreviousLine && lineGenerator.generate();
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return getValue() == point.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
