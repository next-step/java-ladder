package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.line.Lines;

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
}
