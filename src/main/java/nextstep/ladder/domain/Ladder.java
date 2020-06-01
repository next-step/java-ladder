package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.line.Line;

public class Ladder {

    private List<Line> lines;
    private List<Player> players;

    public Ladder(List<Line> lines, List<Player> players) {
        validate(lines, players);

        this.lines = lines;
        this.players = players;
    }

    private void validate(List<Line> lines, List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("min player is 2");
        }
        if (lines.size() < 1) {
            throw new IllegalArgumentException("min height is 1");
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }
}
