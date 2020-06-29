package ladder.domain.line;

import ladder.domain.point.Point;
import ladder.domain.point.PointGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    public static final int MIN_COUNT = 2;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPlayer, PointGenerator pointGenerator) {
        validateArguments(countOfPlayer, pointGenerator);

        points.add(Point.first());
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

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public Position move(Position position) {
        if (canMoveRight(position)) {
            return position.right();
        }

        if (canMoveLeft(position)) {
            return position.left();
        }

        return position;
    }

    private boolean canMoveRight(Position position) {
        return !isLastPosition(position) && points.get(position.getValue() + 1).isMovable();
    }

    private boolean canMoveLeft(Position position) {
        return !isFirstPosition(position) && points.get(position.getValue()).isMovable();
    }

    private boolean isLastPosition(Position position) {
        return position.getValue() == points.size() - 1;
    }

    private boolean isFirstPosition(Position position) {
        return position.getValue() == 0;
    }
}
