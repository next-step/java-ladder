package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(int sizeOfLadder) {
        this.points = initializeLadder(sizeOfLadder);
    }

    private List<Point> initializeLadder(int sizeOfLadder) {
        List<Point> result = new ArrayList<>(sizeOfLadder);

        Point point = Point.firstOf();
        result.add(point);
        for (int i = 1; i < sizeOfLadder - 1; i++) {
            point = Point.of(point);
            result.add(point);
        }
        result.add(point.lastOf());

        return result;
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Point> getPoints() {
        return points;
    }


}
