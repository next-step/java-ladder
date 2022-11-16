package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int countOfMember, Height ladderHeight) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight.height(); i++) {
            ladder.add(new Line(countOfMember));
        }
        this.ladder = ladder;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
