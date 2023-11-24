package ladder_v2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public static Ladder of(int pointCount, int height) {
        if (height < 1) {
            throw new IllegalArgumentException("Ladder는 최소 1개의 Line을 가져야 한다.");
        }
        return new Ladder().make(pointCount, height);
    }

    private Ladder make(int pointCount, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(pointCount));
        }
        return this;
    }

    public List<Line> lines() {
        return lines;
    }
}
