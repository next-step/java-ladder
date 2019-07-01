package com.ladder.model;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LadderGame {

    private final int numberOfPlayers;
    private final Lines ladder;

    LadderGame(int numberOfPlayers, Lines ladder) {
        this.numberOfPlayers = numberOfPlayers;
        this.ladder = ladder;
    }

    public static LadderGame generate(int numberOfColumns, int numberOfPlayers) {
        return new LadderGame(numberOfPlayers, Lines.of(numberOfColumns, numberOfPlayers));
    }

    Position playByOnePosition(Position playerOfPosition) {
        return ladder.playByOnePosition(playerOfPosition);
    }

    PlayReport play() {
        List<Position> results = IntStream.range(0, numberOfPlayers)
                .mapToObj(Position::of)
                .map(ladder::playByOnePosition)
                .collect(toList());
        return PlayReport.of(results);
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}
