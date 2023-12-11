package nextstep.ladder.domain;

import java.util.List;

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

    public List<String> toStringPlayers() {
        return this.players.toStringList();
    }

}
