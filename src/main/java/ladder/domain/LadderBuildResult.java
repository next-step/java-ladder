package ladder.domain;

public class LadderBuildResult {

    private Ladder ladder;
    private Players players;

    public LadderBuildResult(Ladder ladder, Players players){
        this.ladder = ladder;
        this.players = players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }
}
