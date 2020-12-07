package ladder.domain.ladder;

import ladder.exception.InsufficientLadderHeightException;

import java.util.List;

public class Ladder {

    private static final int MIN_LADDER_HEIGHT = 2;
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        if(lines.size() < MIN_LADDER_HEIGHT) {
            throw new InsufficientLadderHeightException();
        }
        this.lines = lines;
    }

    public Line findByIndex(int index) {
       return lines.get(index);
    }

    public int sizeHeight() {
        return lines.size();
    }

    public int sizeWidth() {
        return lines.get(0).sizeWidth();
    }
}
