package ladder.domain;

public class LadderGame {

    private final Players players;
    private final Lines lines;

    public LadderGame(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public static LadderGame of(Players players, int height) {
        Lines lines = Lines.of(players.getPlayersCount(), height);

        return new LadderGame(players, lines);
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }
}
