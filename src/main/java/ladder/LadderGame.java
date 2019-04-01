package ladder;


public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(LadderGenerator ladderGenerator, Players players, int height) {
        this.players = players;
        this.ladder = ladderGenerator.generate(players.getCountOfPerson(), height);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }
}
