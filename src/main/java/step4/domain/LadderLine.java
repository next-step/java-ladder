package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return 0;
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        return new LadderLine(points);
    }
}
