package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Lines lines;

    private LadderGame(final Players players, final Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public static LadderGame start(List<String> playerNames, int height) {
        Players players = Players.of(playerNames);
        LinesGenerator linesGenerator = new RandomLinesGenerator(players.count(), height);

        return new LadderGame(players, linesGenerator.generate());
    }

    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }
}
