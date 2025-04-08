package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, SelectStrategy selectStrategy) {
        initializePoints(countOfPerson);
        selectPoints(selectStrategy);
    }
    private void initializePoints(int countOfPerson) {
        for (int i = 0; i < countOfPerson; ++i) {
            points.add(new Point());
        }
    }

    private void selectPoints(SelectStrategy selectStrategy) {
        for (int i = 1; i < points.size(); ++i) {
            points.get(i).selectPoint(points.get(i-1), selectStrategy);
        }
    }

    public List<Point> getLine() {
        return points;
    }

    public int down(int inputColumn) {
        if (points.get(inputColumn).equals(new Point(true))) {
            return inputColumn - 1;
        }
        if (inputColumn + 1 < points.size() && points.get(inputColumn + 1).equals(new Point(true))) {
            return inputColumn + 1;
        }
        return inputColumn;
    }
}
