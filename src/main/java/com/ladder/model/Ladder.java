package com.ladder.model;

import java.util.List;

public class Ladder {

    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder generate(int numberOfColumns, int numberOfUsers) {
        return new Ladder(Lines.of(numberOfColumns, numberOfUsers));
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
