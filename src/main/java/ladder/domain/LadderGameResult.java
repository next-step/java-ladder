package ladder.domain;

public class LadderGameResult {

    private Ladders ladders;
    private Players players;

    public LadderGameResult(Ladders ladders, Players players){
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
