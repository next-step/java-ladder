package nextstep.ladder;

import java.util.List;

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
}
