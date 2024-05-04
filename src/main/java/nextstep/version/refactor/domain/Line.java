package nextstep.version.refactor.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Points> points;

    public Line(int size, int height, LineCreator lineCreator) {
        this(toLineList(size, height, lineCreator));
    }

    private static List<Points> toLineList(int size, int height, LineCreator lineCreator) {
        List<Points> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(new Points(lineCreator.createBooleanList(size)));
        }
        return points;
    }

    public Line(List<Points> points) {
        this.points = points;
    }

    public Points get(int index) {
        return points.get(index);
    }
}
