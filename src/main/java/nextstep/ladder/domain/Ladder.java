package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final Players players;
    private final List<Line> lines;

    public Ladder(Players players, List<Line> lines) {
        this.players = players;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public String toStringResult() {
        StringBuilder result = new StringBuilder();

        result.append(players.toStringList()
                .stream()
                .map(p -> String.format("%-6s", p))
                .collect(Collectors.joining("")));

        result.append("\n");

        for (Line line : this.lines) {
            result.append(line.toString());
        }

        return result.toString();

    }

}
