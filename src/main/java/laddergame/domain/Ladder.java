package laddergame.domain;

import laddergame.strategy.LineStrategy;
import laddergame.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int widthOfLadder, int heightOfLadder) {
        for (int i = 0; i < heightOfLadder; i++) {
            LineStrategy lineStrategy = new RandomLineStrategy();
            ladder.add(new Line(widthOfLadder, lineStrategy));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
