package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.point.PointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    public static final int MIN_COUNT = 2;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPlayer, PointGenerator pointGenerator) {
        validateArguments(countOfPlayer, pointGenerator);

        points.add(Point.zero());
        points.addAll(generatePoints(countOfPlayer, pointGenerator));
    }

    private List<Point> generatePoints(int countOfPlayer, PointGenerator pointGenerator) {
        return Stream.generate(pointGenerator::next)
                .limit(countOfPlayer - points.size())
                .collect(Collectors.toList());
    }

    private void validateArguments(int countOfPlayer, PointGenerator pointGenerator) {
        if (countOfPlayer < MIN_COUNT) {
            throw new IllegalArgumentException(String.format("Line 생성은 최소 %d명의 Player가 필요합니다.", MIN_COUNT));
        }

        if (pointGenerator == null) {
            throw new IllegalArgumentException("Point 생성 전략이 필요합니다.");
        }
    }

    public static Line create(int countOfPlayer, PointGenerator pointGenerator) {
        return new Line(countOfPlayer, pointGenerator);
    }

    public List<Integer> getLengths() {
        return points.stream()
                .map(Point::getCount)
                .collect(Collectors.toList());
    }
}
