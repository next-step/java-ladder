package nextstep.ladder.domain;


import java.util.*;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line ofRandom(int countOfParticipants) {
        List<Point> points = new ArrayList<>();
        for (int index = 0; index < countOfParticipants - 1; index++) {
            addPoint(points, index);
        }
        return new Line(points);
    }

    public static Line ofString(String input) {
        checkCanBeBoolean(input);
        List<Point> points = Arrays.stream(input.split(","))
                .map(point -> Point.of(new Boolean(point)))
                .collect(Collectors.toList());
        return new Line(points);
    }

    private static void addPoint(List<Point> points, int index) {
        if (index == 0) {
            points.add(Point.ofRandom());
        } else if (points.get(index - 1) == Point.of(true)) {
            points.add(Point.of(false));
        } else if (points.get(index - 1) == Point.of(false)) {
            points.add(Point.ofRandom());
        }
    }

    private static void checkCanBeBoolean(String input) {
        Optional<String> inputError = Arrays.stream(input.split(","))
                .filter(point -> !point.equals("false") && !point.equals("true"))
                .findFirst();
        if (inputError.isPresent()) {
            throw new IllegalArgumentException("Boolean 으로 변환될 수 없습니다.");
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
