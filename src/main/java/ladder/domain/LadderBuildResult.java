package ladder.domain;

public class LadderBuildResult {

    private Ladders ladders;
    private Players players;

    public LadderBuildResult(Ladders ladders, Players players){
        this.ladders = ladders;
        this.players = players;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public Players getPlayers() {
        return players;
    }
}
