package ladder.domain;

import ladder.strategy.ConnectionStrategy;

import java.util.*;

public class Ladder {
    private static final String ALL_PLAYER = "all";

    private final Players players;
    private final Lines lines;
    private final Results results;

    public Ladder(int size, int height, ConnectionStrategy connection, Players players, Results results) {
        this.lines = new Lines(size, height, connection);
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

    public Map<String, String> result(String playerName) {
        if (!Objects.equals(playerName, ALL_PLAYER)) {
            return findResult(playerName);
        }
        return findResultAll();
    }

    private Map<String, String> findResult(String playerName) {
        Player player = this.players.findByName(playerName);
        int playerIndex = this.players.findIndex(playerName);
        int resultIndex = this.lines.nextIndex(playerIndex);
        String result = this.results.findName(resultIndex);
        return makeResultMap(player, result);
    }

    private Map<String, String> findResultAll() {
        Map<String,String> resultMap = new HashMap<>();
        this.players.names()
                .forEach((name) -> resultMap.putAll(findResult(name)));
        return resultMap;
    }

    private Map<String, String> makeResultMap(Player player, String result) {
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put(player.name(), result);
        return resultMap;
    }
}
