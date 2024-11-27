package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.List;

public class Ladder {
    private final Players players;
    private final Lines lines;

    public Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public Ladder(Players players, int ladderHeight) {
        this(players, new Lines(ladderHeight, players.playerCount()));
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
