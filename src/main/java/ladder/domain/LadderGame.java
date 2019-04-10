package ladder.domain;

public class LadderGame {
    private final Players players;
    private final Lines lines;

    private LadderGame(final Players players, final Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public LadderGame(final String[] playerNames, final LinesGenerator linesGenerator) {
        this(new Players(playerNames), linesGenerator.generate());
    }

    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }
}
