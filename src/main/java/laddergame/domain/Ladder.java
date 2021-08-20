package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPeople, int heightOfLadder) {
        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(new Line(countOfPeople));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int height() {
        return ladder.size();
    }
}
