package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final Players players;
    private final List<Line> lines;
    private final List<String> results;

    public Ladder(Players players, List<Line> lines, List<String> results) {
        this.players = players;
        this.lines = lines;
        this.results = results;
    }

    public void run() {
        players.run(this.lines);
    }

    public String getGameResultPerPlayer(String name) {
        if("all".equals(name)) {
            return this.players.gameResults(results);
        }
        return this.players.gameResult(new Player(name), results);
    }

    public List<Line> getLines() {
        return lines;
    }

    public String toStringResult() {
        StringBuilder result = new StringBuilder();

        result.append(players.toStringPlayers()
                .stream()
                .map(p -> String.format("%-6s", p))
                .collect(Collectors.joining("")));

        result.append("\n");

        for (Line line : this.lines) {
            result.append(line.toString());
        }

        result.append(this.results
                .stream()
                .map(p -> String.format("%-6s", p))
                .collect(Collectors.joining("")));

        return result.toString();

    }
}
