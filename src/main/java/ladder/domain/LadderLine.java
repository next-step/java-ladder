package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(int sizeOfLadder) {
        this.points = InitializeLadder(sizeOfLadder);
    }

    private List<Point> InitializeLadder(int sizeOfLadder) {
        List<Point> points = new ArrayList<>(sizeOfLadder);

        Point point = Point.firstOf();
        points.add(point);
        for (int i = 1; i < sizeOfLadder - 1; i++) {
            point = Point.of(point);
            points.add(point);
        }
        points.add(point.lastOf());

        return points;
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Point> getPoints() {
        return points;
    }


}
