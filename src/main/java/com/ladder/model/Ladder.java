package com.ladder.model;

import java.util.List;

public class Ladder {

    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder generate(int numberOfColumns, int numberOfPlayers) {
        return new Ladder(Lines.of(numberOfColumns, numberOfPlayers));
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
