package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int ladderHeight, int countOfPerson, HorizontalLineStrategy horizontalLineStrategy) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(countOfPerson, horizontalLineStrategy));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

}
