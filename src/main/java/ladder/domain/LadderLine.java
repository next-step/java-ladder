package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(Players players) {
        List<Point> pass = new ArrayList<>();
        return new LadderLine(pass);
    }

    public int size() {
        return points.size();
    }
}
