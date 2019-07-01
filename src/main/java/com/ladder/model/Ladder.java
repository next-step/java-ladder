package com.ladder.model;

import java.util.List;

public class Ladder {

    private final Lines ladder;

    private Ladder(Lines ladder) {
        this.ladder = ladder;
    }

    static Ladder of(Lines ladder) {
        return new Ladder(ladder);
    }

    public static Ladder generate(int numberOfColumns, int numberOfPlayers) {
        return new Ladder(Lines.of(numberOfColumns, numberOfPlayers));
    }

    Position playByOnePosition(Position playerOfPosition) {
        for (Line line : ladder.getLines()) {
            playerOfPosition = line.move(playerOfPosition);
        }
        return playerOfPosition;
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}
