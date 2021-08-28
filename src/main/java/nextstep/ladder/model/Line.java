package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();
    private final int index;

    public Line(int height, int index) {
        for (int i = 0; i < height; i++) {
            points.add(new Point());
        }

        this.index = index;
    }

    public Point getPoint(int index) {
        if (index >= points.size() || index < 0) {
            throw new IllegalArgumentException("잘못된 인덱스를 입력하였습니다. index : " + index);
        }

        return points.get(index);
    }

    public int getIndex() {
        return index;
    }
}
