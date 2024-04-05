package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
        checkOverLabLine();
    }

    public Line(int countOfPerson) {
        this.points = new ArrayList<>(countOfPerson);

        points.add(new Point(RandomLine::getRandomValue));

        for (int i = 1; i < countOfPerson - 1; i++) {
            int prevIndex = i - 1;
            points.add(new Point(() -> isBeforeDrawLine(prevIndex)));
        }

        checkOverLabLine();
    }

    private boolean isBeforeDrawLine(int prevIndex) {
        return !findPoint(prevIndex).isActive() && RandomLine.getRandomValue();
    }

    private Point findPoint(int index) {
        return points.get(index);
    }

    private void checkOverLabLine() {
        boolean foundOverLab = IntStream.range(0, points.size() - 1)
                .anyMatch(this::isSamePosition);

        if (foundOverLab)
            throw new IllegalArgumentException("라인이 중복되면 안됩니다.");
    }

    private boolean isSamePosition(int index) {
        return findPoint(index).isActive() && findPoint(index + 1).isActive();
    }

    public List<Point> getPoints() {
        return points;
    }

}
