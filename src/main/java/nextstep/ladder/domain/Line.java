package nextstep.ladder.domain;


import java.util.*;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.Point.*;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line ofRandom(int countOfParticipants) {
        List<Point> points = new ArrayList<>();
        points.add(Point.ofRandomFirstPoint());
        for (int index = 1; index < countOfParticipants - 1; index++) {
            addPoint(points, index);
        }
        points.add(Point.ofRandomLastPoint(points.get(countOfParticipants - 2)));
        return new Line(points);
    }

    public static Line ofString(String input) {
        checkCanBePoint(input);
        List<Point> points = Arrays.stream(input.split(","))
                .map(point -> Point.of(point))
                .collect(Collectors.toList());
        return new Line(points);
    }

    private static void addPoint(List<Point> points, int index) {
        int randomNumber = RANDOM.nextInt(RANDOM_END);
        if (points.get(index - 1) == Point.of("right")) {
            points.add(Point.of("left"));
            return;
        }
        if (points.get(index - 1) != Point.of("right") && randomNumber > RANDOM_BOUNDARY) {
            points.add(Point.of("right"));
            return;
        }
        if (points.get(index - 1) != Point.of("right") && randomNumber <= RANDOM_BOUNDARY) {
            points.add(Point.of("none"));
            return;
        }
    }

    private static void checkCanBePoint(String input) {
        Optional<String> inputError = Arrays.stream(input.split(","))
                .filter(point -> !point.equals("left") && !point.equals("right") && !point.equals("none"))
                .findFirst();
        if (inputError.isPresent()) {
            throw new IllegalArgumentException("Point 로 변환될 수 없습니다.");
        }
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
