package ladder;

public class GameResult {

    private final Players players;
    private final LadderLines ladderLines;

    public GameResult(Players players, LadderLines ladderLines) {
        this.players = players;
        this.ladderLines = ladderLines;
    }

    public Players getPlayers() {
        return players;
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }
}
