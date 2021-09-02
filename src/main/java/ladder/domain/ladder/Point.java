package ladder.domain.ladder;

import static java.util.Optional.ofNullable;

import java.util.Optional;

public class Point {

    private final int position;

    private final Point linkPoint;

    public Point(int position) {
        this.position = position;
        this.linkPoint = null;
    }

    public int position() {
        return position;
    }

    public Optional<Point> linkPoint() {
        return ofNullable(linkPoint);
    }

}
