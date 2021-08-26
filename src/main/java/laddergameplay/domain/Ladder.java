package laddergameplay.domain;

import laddergameplay.strategy.LineStrategy;
import laddergameplay.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPeople, int heightOfLadder) {
        for (int i = 0; i < heightOfLadder; i++) {
            LineStrategy lineStrategy = new RandomLineStrategy();
            ladder.add(new Line(countOfPeople, lineStrategy));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
