package game.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by yusik on 2019/11/09.
 */
public class Line {

    private List<Point> points = new ArrayList<>();

    public Line(int countOfPlayer, LinkStrategy linkStrategy) {
        Point prevPoint = Point.of(false);
        for (int i = 0; i < countOfPlayer - 1; i++) {
            Point point = prevPoint.createNextPoint(linkStrategy);
            points.add(point);
            prevPoint = point;
        }
        points.add(Point.of(false));
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        Direction direction = Direction.getDirection(
                canMoveLeft(position),
                canMoveRight(position));

        return direction.move(position);
    }

    private boolean canMoveLeft(int position) {
        return Optional.ofNullable(getPoint(position - 1))
                .map(Point::isLinkable)
                .orElse(false);
    }

    private boolean canMoveRight(int position) {
        return Optional.ofNullable(getPoint(position))
                .map(Point::isLinkable)
                .orElse(false);
    }

    private Point getPoint(int position) {
        if (position < 0) {
            return null;
        }
        return points.get(position);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
