package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class UserRecord {

    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;

    private String name;
    private List<Integer> points = new ArrayList<>();

    public UserRecord(String name, int initPoint) {
        this.name = name;
        addPoint(initPoint);
    }

    public void addPoint(int point) {
        points.add(point);
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void recordPoints(List<Line> lines) {
        for (Line line : lines) {
            movePoint(line);
        }
    }

    private void movePoint(Line line) {

        if(line.isExist(getPreviousPoint())) {
            addPoint(getCurrentPoint() + MOVE_LEFT);
            return;
        }

        if(line.isExist(getCurrentPoint())) {
            addPoint(getCurrentPoint() + MOVE_RIGHT);
            return;
        }

        addPoint(getCurrentPoint());
    }

    private int getCurrentPoint() {
        return points.get(points.size() - 1);
    }

    private int getPreviousPoint() {
        return getCurrentPoint() - 1;
    }
}
