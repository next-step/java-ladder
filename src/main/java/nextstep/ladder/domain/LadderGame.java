package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Lines lines;

    private LadderGame(final Players players, final Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public static LadderGame of(List<String> playerNames, int height) {
        Players players = Players.of(playerNames);
        Lines lines = Lines.of(players.count(), height);

        return new LadderGame(players, lines);
    }

    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }
}
