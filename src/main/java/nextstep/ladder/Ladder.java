package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Point> points;

    public Ladder() {
        points = new ArrayList<>();
    }

    public Ladder(List<Point> points) {
        this.points = points;
    }

    public int height() {
        return points.size();
    }

    public void addHeight(Direction direction) {
        points.add(new Point(direction));
    }

    public Direction direction(int height) {
        return points.get(height).direction();
    }
}
