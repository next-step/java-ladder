package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
    }

    public List<Line> getLadder() {
        return this.ladder;
    }
}
