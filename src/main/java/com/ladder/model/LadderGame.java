package com.ladder.model;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LadderGame {

    private final Lines ladder;

    LadderGame(Lines ladder) {
        this.ladder = ladder;
    }

    public static LadderGame generate(int numberOfColumns, int numberOfPlayers) {
        return new LadderGame(Lines.of(numberOfColumns, numberOfPlayers));
    }

    public PlayReport play(Result result) {
        return PlayReport.of(IntStream.range(0, result.countOfPlayers())
                .mapToObj(Position::of)
                .collect(toMap(result::findByPlayer, result::findByReward)));
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}