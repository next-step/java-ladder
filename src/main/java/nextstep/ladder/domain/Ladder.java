package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Boolean> lines;

    public Ladder(List<Boolean> lines) {
        this.lines = lines;
    }

    public List<Boolean> getLines() {
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
        return result != 0 && lines.get(result - 1);
    }

    private boolean isRight(int result) {
        return lines.size() != result && lines.get(result);
    }

}
