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
        List<String> resultList = new ArrayList<>();
        int playerIndex = this.players.findIndex(playerName);
        for (Line line : lines) {
            playerIndex = line.nextIndex(playerIndex);
        }
        resultList.add(this.results.findName(playerIndex));
        return resultList;
    }

    private List<String> findResultAll() {
        List<String> resultList = new ArrayList<>();
        this.players.names()
                .forEach((name) -> resultList.addAll(findResult(name)));
        return resultList;
    }
}
