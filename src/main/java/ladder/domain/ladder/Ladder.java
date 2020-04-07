package ladder.domain.ladder;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int width) {
        for (int i = 0; i < height; i++) {
            ladder.add(new LadderLine(width));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
