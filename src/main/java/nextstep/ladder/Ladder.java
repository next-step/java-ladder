package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Point> points;

    public Ladder(int height) {
        points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(new Point());
        }
    }

    public int height() {
        return points.size();
    }
}
