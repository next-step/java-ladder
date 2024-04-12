package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderGenerator;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private final List<Point> points = new ArrayList<>();

    public Points(int countOfPerson, LadderGenerator strategy) {
        this(new CountOfPerson(countOfPerson), strategy);
    }

    public Points(CountOfPerson countOfPerson, LadderGenerator strategy) {
        countOfPerson.rangOfZeroToCount()
                .forEach(i -> {
            boolean hasLadder = strategy.generate();
            if (isNotFirstPoint(i) && hasLadderAtPrevious(i).isExist()) {
                hasLadder = false;
            }
            addLadderPoints(new Point(hasLadder));
        });
    }

    public Points(List<Point> points) {
        this.points.addAll(points);
    }

    private boolean isNotFirstPoint(int i) {
        return i >= 1;
    }

    private Point hasLadderAtPrevious(int i) {
        return points.get(i - 1);
    }

    private void addLadderPoints(Point point) {
        points.add(point);
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Boolean> validatePoints() {
        List<Boolean> booleans = new ArrayList<>();
        for (Point point : points) {
            booleans.add(point.isExist());
        }
        return booleans;
    }

}
