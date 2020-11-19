package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int i) {
        points = new ArrayList<>(i - 1);
        for (int j = 0; j < i - 1; j++) {
            points.add(false);
        }
    }

    public int size() {
        return points.size();
    }
}
