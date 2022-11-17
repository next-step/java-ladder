package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Ladder {
    private final Players players;
    private final List<Line> lines = new ArrayList<>();
    private final Results results;

    public Ladder(int size, int height, Players players, Results results) {
        IntStream.range(0, height)
                .forEach((i) -> lines.add(new Line(size, new RandomUtil())));
        this.players = players;
        this.results = results;
    }

    public List<Line> lines() {
        return lines;
    }

    public List<String> names() {
        return this.players.names();
    }

    public List<String> result(String playerName) {
        if (!Objects.equals(playerName, "all")) {
            return findResult(playerName);
        }
        return findResultAll();
    }

    private List<String> findResult(String playerName) {
        int playerIndex = this.players.findIndex(playerName);
        int resultIndex = getResultIndex(playerIndex);
        return List.of(this.results.findName(resultIndex));
    }

    private int getResultIndex(int playerIndex) {
        int resultIndex = playerIndex;
        for (Line line : lines) {
            resultIndex = line.nextIndex(playerIndex);
        }
        return resultIndex;
    }

    private List<String> findResultAll() {
        List<String> resultList = new ArrayList<>();
        this.players.names()
                .forEach((name) -> resultList.addAll(findResult(name)));
        return resultList;
    }
}
