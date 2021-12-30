package nextstep.ladder.domain;


import java.util.*;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public static Line ofString(String input) {
        checkCanBePoint(input);
        List<Point> points = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (int index = 0; index < splitInput.length; index++) {
            points.add(Point.of(new Direction(splitInput[index]), index));
        }
        return new Line(points);
    }


    public static Line init(int countOfParticipants) {
        List<Point> points = new ArrayList<>();
        Point firstPoint = initFirst(points);
        Point point = initBody(points, countOfParticipants, firstPoint);
        initLast(points, point);
        return new Line(points);
    }

    public static Point initFirst(List<Point> points) {
        Point firstPoint = Point.first();
        points.add(firstPoint);
        return firstPoint;
    }

    public static Point initBody(List<Point> points, int countOfParticipants, Point point) {
        for (int index = 1; index < countOfParticipants - 1; index++) {
            point = point.next(index);
            points.add(point);
        }
        return point;
    }

    public static void initLast(List<Point> points, Point point) {
        points.add(point.last(points.size()));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
