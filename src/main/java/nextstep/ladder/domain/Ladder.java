package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private Lines lines;
    private int height;

    public Ladder(List<Line> lines, int height) {
        this.lines = new Lines(lines);
        this.height = height;
    }

    public Ladder(int size, int height) {
        this.lines = new Lines(size, height);
        this.height = height;
    }

    public int size() {
        return lines.size();
    }

    public int height() {
        return height;
    }

    public Direction ladderDirection(int index, int height) {
        return lines.getDirection(index, height);
    }
}
