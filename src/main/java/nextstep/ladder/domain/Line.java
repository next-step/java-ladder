package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
        checkOverLabLine();
    }

    public Line(int countOfPerson) {
        this.points = new ArrayList<>(countOfPerson);
        Point beforePoint = new Point(RandomLine::getRandomValue);
        points.add(beforePoint);

        boolean isBeforePoint = beforePoint.isActive();

        for (int i = 1; i < countOfPerson - 1; i++) {
            boolean finalIsBeforePoint = isBeforePoint;
            Point currentPoint = new Point(() -> isBeforeDrawLine(finalIsBeforePoint));
            points.add(currentPoint);
            isBeforePoint = currentPoint.isActive();
        }

        checkOverLabLine();
    }

    private boolean isBeforeDrawLine(boolean isBeforePoint) {
        return !isBeforePoint && RandomLine.getRandomValue();
    }

    private Point findPoint(int index) {
        return points.get(index);
    }

    private void checkOverLabLine() {
        if (isFoundOverLab())
            throw new IllegalArgumentException("라인이 중복되면 안됩니다.");
    }

    private boolean isFoundOverLab() {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(this::isSamePosition);
    }

    private boolean isSamePosition(int index) {
        return findPoint(index).isActive() && findPoint(index + 1).isActive();
    }

    public List<Boolean> pointToBoolean() {
        return points.stream()
                .map(Point::isActive)
                .collect(Collectors.toList());
    }

}
