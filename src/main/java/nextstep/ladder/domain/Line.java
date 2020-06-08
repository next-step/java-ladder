package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line newInstance(List<Point> points) {
        validate(points);
        return new Line(points);
    }

    private static void validate(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("라인이 존재하지 않습니다.");
        }

        if (points.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("존재하지 않은 라인이 포함되어 있습니다.");
        }

        for (int i = 1; i < points.size(); i++) {
            points.get(i).validate(points.get(i - 1));
        }
    }

    public Position move(Position position) {
        int current = position.value();
        if (isMoveLeft(current)) {
            return position.left();
        }

        if (isMoveRight(current)) {
            return position.right();
        }

        return position;
    }

    private boolean isMoveLeft(int position) {
        return position - Position.DEFAULT_MOVE_POSITION >= 0
                && this.points.get(position - Position.DEFAULT_MOVE_POSITION).hasPoint();
    }

    private boolean isMoveRight(int position) {
        return position < this.points.size()
                && this.points.get(position).hasPoint();
    }

    public List<Point> toList() {
        return Collections.unmodifiableList(this.points);
    }
}
