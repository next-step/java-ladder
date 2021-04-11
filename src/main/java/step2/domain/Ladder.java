package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(int countOfPerson, int ladderHeight) {
        List<Line> newLadder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Line line = new Line(countOfPerson, new RandomGenerator());
            newLadder.add(line);
        }
        return new Ladder(newLadder);
    }

    public List<Line> getLadder() {
        return this.ladder;
    }

    public int getLadderRowSize() {
        return this.ladder.size();
    }
}
