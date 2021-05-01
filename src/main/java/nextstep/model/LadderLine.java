package nextstep.model;

import nextstep.constant.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.constant.Constant.EMPTY_LADDER_STRING;
import static nextstep.constant.Constant.HORIZON_LADDER_STRING;
import static nextstep.model.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public String pointsString() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, this.points.size() - 1)
                .forEach((index) -> {
                    stringBuilder.append(Constant.SPLIT_LADDER_STRING);
                    if (points.get(index).getDirection().isRight()) {
                        stringBuilder.append(HORIZON_LADDER_STRING);
                    } else {
                        stringBuilder.append(EMPTY_LADDER_STRING);
                    }
                });
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
