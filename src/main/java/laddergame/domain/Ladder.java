package laddergame.domain;

import laddergame.strategy.LineStrategy;
import laddergame.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final LineStrategy lineStrategy = new RandomLineStrategy();

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int widthOfLadder, int heightOfLadder) {
        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(new Line(widthOfLadder, lineStrategy));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int height() {
        return ladder.size();
    }
}
