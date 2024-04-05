package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        checkOverLabLine(points);
        this.points = points;
    }

    public Line(int countOfPerson) {
        this.points = new ArrayList<>(countOfPerson);

        points.add(new Point(() -> RandomLine.getRandomValue()));

        for (int i = 1; i < countOfPerson - 1; i++) {
            int prevIndex = i - 1;
            points.add(new Point(() -> isBeforeDrawLine(prevIndex)));
        }

        checkOverLabLine(points);
    }

    private boolean isBeforeDrawLine(int prevIndex) {
        return !points.get(prevIndex).isPoint() && RandomLine.getRandomValue();
    }

    private void checkOverLabLine(List<Point> points) {
        boolean foundOverLab = IntStream.range(0, points.size() - 1)
                .anyMatch(i -> isSamePosition(points, i));

        if (foundOverLab)
            throw new IllegalArgumentException("라인이 중복되면 안됩니다.");
    }

    private static boolean isSamePosition(List<Point> points, int i) {
        return points.get(i).isPoint() && points.get(i + 1).isPoint();
    }

    public List<Point> getPoints() {
        return points;
    }

}
