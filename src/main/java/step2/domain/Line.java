package step2.domain;

import step2.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> line = new ArrayList<>();

    private Line() {
    }

    private Line(int width, LineCreateStrategy createStrategy) {
        this.line = createStrategy.create(width);
    }

    public static Line create(int width, LineCreateStrategy createStrategy) {
        return new Line(width, createStrategy);
    }

    public List<Boolean> getLine() {
        return line;
    }

    public int getLineSize() {
        return line.size();
    }

    public int move(int position) {
        Direction direction = Direction.findBy(isMovable(position), isMovable(position - 1));
        return direction.move(position);
    }

    private boolean isMovable(int position) {
        return line.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(getLine(), line1.getLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLine());
    }
}
