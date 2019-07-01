package com.ladder.model;

import java.util.List;

public class Ladder {

    private final Lines ladder;

    private Ladder(Lines ladder) {
        this.ladder = ladder;
    }

    public static Ladder generate(int numberOfColumns, int numberOfPlayers) {
        return new Ladder(Lines.of(numberOfColumns, numberOfPlayers));
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}
