package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private Lines lines;
    private int height;

    public Ladder(Lines lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public Ladder(List<Line> lines, int height) {
        this(new Lines(lines), height);
    }

    public Ladder(int size, int height) {
        this(new Lines(size, height), height);
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

    public int result(int index) {
        for (int i = 0; i < height; i++) {
            Direction direction = lines.getDirection(index, i);
            index = direction.nextIndex(index);
        }

        return index;
    }
}
