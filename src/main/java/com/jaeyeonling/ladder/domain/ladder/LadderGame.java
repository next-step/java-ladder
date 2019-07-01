package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.point.Point;

public class LadderGame {

    private final Lines lines;

    private LadderGame(final Lines lines) {
        this.lines = lines;
    }

    public static LadderGame of(final Lines lines) {
        return new LadderGame(lines);
    }

    public Lines getLines() {
        return lines;
    }

    public int ride(final int indexOfLadder) {
        final Point point = Point.of(indexOfLadder, 0);
        final Point resultPoint = lines.ride(point);

        return resultPoint.getIndexOfLadder();
    }
}
