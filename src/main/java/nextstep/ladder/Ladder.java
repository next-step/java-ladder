package nextstep.ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final Players players;
    private final Lines lines;

    public Ladder(List<String> players, int height) {
        this.players = Players.from(players);
        this.lines = Lines.of(height, players.size());
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }

    public Map<String, String> calculateResults(List<String> results) {
        Map<String, String> resultMap = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            String playerName = players.getPlayersNames().get(i);
            var cursor = i;
            cursor = lines.calculateLastPosition(cursor);
            resultMap.put(playerName, results.get(cursor));
        }
        return resultMap;
    }

    public Report report(List<String> results) {
        return new Report(calculateResults(results));
    }
}
