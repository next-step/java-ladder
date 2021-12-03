package step2.domain;

import step2.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    public static final int START_POSITION = 0;

    private List<Boolean> line = new ArrayList<>();

    private Line() {
    }

    private Line(int width, LineCreateStrategy createStrategy) {
        this.line = createStrategy.create(width);
    }

    private Line(List<Boolean> line) {
        this.line = line;
    }

    public static Line create(int width, LineCreateStrategy createStrategy) {
        return new Line(width, createStrategy);
    }

    public static Line create(List<Boolean> line) {
        return new Line(line);
    }

    public List<Boolean> getLine() {
        return line;
    }

    public int getLineSize() {
        return line.size();
    }

    public int move(int position) {
        Direction direction = Direction.findBy(movable(position - 1), movable(position));
        return direction.move(position);
    }

    private boolean movable(int position) {
        if (edged(position)) {
            return false;
        }
        return line.get(position);
    }

    private boolean edged(int position) {
        return position < START_POSITION;
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
