package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public int startWith(final int index) {
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

    public static class Builder {
        private final List<Point> points;
        private Point current;

        public Builder(final boolean value) {
            this.current = Point.first(value);
            this.points = new ArrayList<>();
            this.points.add(this.current);
        }

        public Builder point(final boolean value) {
            this.current = this.current.next(value);
            this.points.add(this.current);
            return this;
        }

        public Line build() {
            this.current = this.current.last();
            this.points.add(this.current);
            return new Line(this.points);
        }
    }
}
