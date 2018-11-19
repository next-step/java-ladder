package ladder.domain;

public class LadderGame {
    private final Players players;
    private final Results results;
    private Ladder ladder;

    public LadderGame(Players players, Results results) {
        this.players = players;
        this.results = results;
    }

    public Ladder makeLadder(int height) {
        return this.ladder = Ladder.of(height, players.getCountOfPlayer());
    }

    public LadderResult start() {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < players.getCountOfPlayer(); i++) {
            ladderResult.put(players.getPlayer(i), results.getResult(ladder.move(i)));
        }
        return ladderResult;
    }
}
