package ladder.domain;

import ladder.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<String> result(String playerName) {
        if (!Objects.equals(playerName, ALL_PLAYER)) {
            return findResult(playerName);
        }
        return findResultAll();
    }

    private List<String> findResult(String playerName) {
        int playerIndex = this.players.findIndex(playerName);
        int resultIndex = this.lines.nextIndex(playerIndex);
        return List.of(this.results.findName(resultIndex));
    }

    private List<String> findResultAll() {
        List<String> resultList = new ArrayList<>();
        this.players.names()
                .forEach((name) -> resultList.addAll(findResult(name)));
        return resultList;
    }
}
