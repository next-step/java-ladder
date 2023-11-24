package ladder_v2.domain;

import ladder.domain.Height;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final int pointCount;
    private final Height height;

    public Ladder(int pointCount, Height height) {
        if (height.height() < 1) {
            throw new IllegalArgumentException("Ladder는 최소 1개의 Line을 가져야 한다.");
        }
        this.pointCount = pointCount;
        this.height = height;
        make(pointCount);
    }

    private void make(int pointCount) {
        for (int i = 0; i < this.height.height(); i++) {
            lines.add(Line.of(pointCount));
        }
    }

    public int pointCount() {
        return pointCount;
    }

    public List<Line> lines() {
        return lines;
    }
}
