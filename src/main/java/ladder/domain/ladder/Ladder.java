package ladder.domain.ladder;

import ladder.domain.line.Line;
import ladder.domain.line.Lines;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.List;

public class Ladder {

    private final Players players;
    private final Lines lines;

    private Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public static Ladder of(String playersName, int height) {
        Players players = Players.of(playersName);
        return of(playersName, Lines.of(height, players.size()));
    }

    public static Ladder of(String playersName, Lines lines) {
        return of(Players.of(playersName), lines);
    }

    public static Ladder of(Players players, Lines lines) {
        return new Ladder(players, lines);
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public List<Line> getLines() {
        return lines.getLines();
    }

}
