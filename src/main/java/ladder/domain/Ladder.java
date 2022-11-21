package ladder.domain;

import ladder.strategy.ConnectionStrategy;

import java.util.*;

public class Ladder {
    private static final String ALL_PLAYER = "all";

    private final Players players;
    private final Lines lines;
    private final Results results;

    public Ladder(int height, ConnectionStrategy connection, Players players, Results results) {
        this.lines = new Lines(players.playerSize(), height, connection);
        this.players = players;
        this.results = results;
    }

    public List<Line> lines() {
        return this.lines.getLines();
    }

    public List<String> names() {
        return this.players.names();
    }

    public List<String> results() {
        return this.results.results();
    }

    public LadderResult findLadderResult(String playerName) {
        Players players = findPlayers(playerName);
        Results results = findResults(players);
        return new LadderResult(players, results);
    }

    private Players findPlayers(String playerName) {
        if (Objects.equals(playerName, ALL_PLAYER)) {
            return this.players;
        }
        return new Players(List.of(this.players.findByName(playerName).name()));
    }

    private Results findResults(Players players) {
        List<String> result = new ArrayList<>();
        for (Player player : players.getPlayerList()) {
            int resultIndex = this.lines.nextIndex(player);
            result.add(this.results.findName(resultIndex));
        }
        return new Results(players, result);
    }
}
