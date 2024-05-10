package nextstep.version.refactor.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    /**
     * error: name clash: Points(List<Boolean>) and Points(List<Point>) have the same erasure
     */
    public Points(List<Point> points) {
        this.points = points;
    }

    public Points(Boolean[] booleanList) {
        this(createPointList(booleanList));
    }

    private static List<Point> createPointList(Boolean[] booleansArray) {
        if (booleansArray == null || booleansArray.length == 0) {
            throw new IllegalArgumentException("포인트가 하나도 존재하지 않아 라인을 생성할 수 없습니다.");
        }
        List<Boolean> pointBooleans = Arrays.stream(booleansArray).collect(Collectors.toUnmodifiableList());

        List<Point> points = new ArrayList<>();
        createFirstPoint(pointBooleans, points);

        addMiddlePoints(pointBooleans, points);

        createLastPoint(points, pointBooleans);
        return points;
    }

    private static void createFirstPoint(List<Boolean> pointBooleans, List<Point> points) {
        Point first = Point.first(pointBooleans.get(0));
        points.add(first);
    }

    private static void addMiddlePoints(List<Boolean> pointBooleans, List<Point> points) {
        if (sizeOverThanMinimumSize(pointBooleans, 2)) return;

        for (int i = 1; i < pointBooleans.size() - 1; i++) {
            points.add(points.get(i - 1).next(pointBooleans.get(i)));
        }
    }

    private static void createLastPoint(List<Point> points, List<Boolean> pointBooleans) {
        if (sizeOverThanMinimumSize(pointBooleans, 2)) return;
        points.add(points.get(pointBooleans.size() - 2).last());
    }

    private static boolean sizeOverThanMinimumSize(List<Boolean> pointBooleans, int size) {
        int pointBooleansSize = pointBooleans.size();
        return pointBooleansSize < size;
    }

    public boolean hasLine(int index) {
        return this.points.get(index).getCurrent();
    }

    public Integer move(int position) {
        Point point = this.points.get(position);
        return position + point.move();
//        Direction move = point.move();
//        if (move == Direction.BEFORE) {
//            return position - move.getDirectionValue();
//        }
//
//        if (move == Direction.PASS) {
//            return position;
//        }
//        return position + move.getDirectionValue();
    }

    public int size() {
        return this.points.size();
    }
}
