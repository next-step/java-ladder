package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Point> points;

    public Ladder() {
        points = new ArrayList<>();
    }

    public int height() {
        return points.size();
    }

    public void initHeight(Direction direction) {
        points.add(new Point(direction));
    }

    public Direction direction(int height) {
        return points.get(height).direction();
    }
}
