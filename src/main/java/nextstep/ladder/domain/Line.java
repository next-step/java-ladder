package nextstep.ladder.domain;


import java.util.*;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line ofRandom(int countOfParticipants) {
        List<Point> points = new ArrayList<>();
        Point point = Point.randomFirstPoint();
        points.add(point);
        for (int index = 1; index < countOfParticipants - 1; index++) {
            point = point.nextPoint(index);
            points.add(point);
        }
        points.add(Point.randomLastPoint(point, countOfParticipants - 1));
        return new Line(points);
    }

    public static Line ofString(String input) {
        checkCanBePoint(input);
        List<Point> points = new ArrayList<>();
        int i = 0;
        for (String pointString : (input.split(","))) {
            points.add(Point.of(new Direction(pointString), i));
            i++;
        }
        return new Line(points);
    }

    private static void checkCanBePoint(String input) {
        Optional<String> inputError = Arrays.stream(input.split(","))
                .filter(point -> !point.equals("left") && !point.equals("right") && !point.equals("none"))
                .findFirst();
        if (inputError.isPresent()) {
            throw new IllegalArgumentException("Point 로 변환될 수 없습니다.");
        }
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
