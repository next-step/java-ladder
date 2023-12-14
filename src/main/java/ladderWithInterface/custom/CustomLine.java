package ladderWithInterface.custom;

import ladderWithInterface.engin.Line;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CustomLine implements Line {

    private final List<Direction> values;

    public CustomLine(List<Direction> values) {
        this.values = values;
    }

    @Override
    public int move(int position) {
        Direction direction = this.values.get(position);
        return direction.move() + position;
    }

    @Override
    public List<Direction> draw() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomLine line = (CustomLine) o;
        return Objects.equals(values, line.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "CustomLine{" +
                "values=" + values +
                '}';
    }
}
