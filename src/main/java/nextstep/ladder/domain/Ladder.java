package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int search(int index) {
        if (isLeft(index)) {
            return index - 1;
        }
        if (isRight(index)) {
            return index + 1;
        }
        return index;
    }

    private boolean isLeft(int result) {
        return result != 0 && lines.get(result - 1).isLine();
    }

    private boolean isRight(int result) {
        return lines.size() != result && lines.get(result).isLine();
    }

}
