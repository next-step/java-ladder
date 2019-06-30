package ladder;

import java.util.List;

public class Ladder {
    List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public int height() {
        return ladder.size();
    }

    public int sizeOfLine() {
        return ladder.get(0).size();
    }
}
