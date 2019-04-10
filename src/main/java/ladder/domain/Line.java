package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    int startWith(final int index) {
        return this.points.get(index)
                .move()
                ;
    }

    public Point getPoint(final int index) {
        return this.points.get(index);
    }

    public int getLength() {
        return this.points.size();
    }

    static class Builder {
        private final List<Point> points;
        private Point current;

        public Builder() {
            this.points = new ArrayList<>();
        }

        public Builder point(final boolean value) {
            if (isEmpty()) {
                add(Point.first(value));
                return this;
            }
            add(this.current.next(value));
            return this;
        }

        public Line build() {
            validate();
            add(this.current.last());
            return new Line(this.points);
        }

        private boolean isEmpty() {
            return this.points.size() == 0 && this.current == null;
        }

        private void add(final Point current) {
            this.current = current;
            this.points.add(current);
        }

        private void validate() {
            if (isEmpty()) {
                throw new IllegalStateException();
            }
        }
    }
}
