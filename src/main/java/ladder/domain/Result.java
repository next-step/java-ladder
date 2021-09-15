package ladder.domain;

public class Result {
    private final Players players;

    private final Ladders ladders;

    private final PlayResults playResults;

    private final LadderResult ladderResult;

    public Result(final Players players, final Ladders ladders, final PlayResults playResults, final LadderResult ladderResult) {
        this.players = players;
        this.ladders = ladders;
        this.playResults = playResults;
        this.ladderResult = ladderResult;
    }

    public Players getPlayers() {
        return players;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public PlayResults getPlayResults() {
        return playResults;
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }

    public PlayResult findPlayResult(final String playerName) {
        return ladderResult.find(players.find(new Name(playerName)));
    }
}
