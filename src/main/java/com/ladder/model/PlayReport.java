package com.ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayReport {

    private Map<Position, Position> playResult;

    private PlayReport(Map<Position, Position> playResult) {
        this.playResult = playResult;
    }

    static PlayReport of(List<Position> results) {
        Map<Position, Position> playResults = new HashMap<>();
        for (int startPosition = 0; startPosition < results.size(); startPosition++) {
            playResults.put(Position.of(startPosition), results.get(startPosition));
        }
        return new PlayReport(playResults);
    }

    Position getPlayResult(Position startPosition) {
        return playResult.get(startPosition);
    }
}
