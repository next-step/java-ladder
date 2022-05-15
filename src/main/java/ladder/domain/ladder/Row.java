package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.point.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Row {
    private final List<Point> points;

    public Row() {
        this(new ArrayList<>());
    }

    public Row(List<Point> points) {
        validate(points);
        this.points = new ArrayList<>(points);
    }

    private void validate(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("points는 null 일 수 없습니다.");
        }
    }

    private Row extend(Point point) {
        List<Point> points = new ArrayList<>(this.points);
        points.add(point);
        return new Row(points);
    }

    public static Row generateByWidth(int width) {
        return new Row()
                .extendFirst()
                .extend(width - 1)
                .extendLast();
    }

    private Row extendFirst() {
        return extend(Point.first());
    }

    private Row extend(int targetWidth) {
        if (width() >= targetWidth) {
            return this;
        }

        return extend(
                getLastPoint().next()
        ).extend(targetWidth);
    }

    private Row extendLast() {
        return extend(getLastPoint().nextLast());
    }

    private Point getLastPoint() {
        return points.get(points.size() - 1);
    }

    public Player trace(Player player) {
        return points.stream()
                .filter(player::isOnPoint)
                .map(point -> point.move(player))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사다리 위치가 올바르지 않습니다."));
    }

    public int width() {
        return points.size();
    }

    @Override
    public String toString() {
        return points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
