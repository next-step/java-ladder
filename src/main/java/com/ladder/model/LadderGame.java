package com.ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Lines ladder;

    LadderGame(Lines ladder) {
        this.ladder = ladder;
    }

    public static LadderGame generate(int numberOfColumns, int numberOfPlayers) {
        return new LadderGame(Lines.of(numberOfColumns, numberOfPlayers));
    }

    public PlayReport play(Result result) {
        Map<Player, Reward> playingResults = new HashMap<>();
        for (int index = 0; index < result.countOfPlayers(); index++) {
            Position position = Position.of(index);

            Player player = result.findByPlayer(position);
            Position endPoint = ladder.playByOnePosition(position);
            Reward reward = result.findByReward(endPoint);

            playingResults.put(player, reward);
        }
        return PlayReport.of(playingResults);
    }

    public List<Line> getLadder() {
        return ladder.getLines();
    }
}