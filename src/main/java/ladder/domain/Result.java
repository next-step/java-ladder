package ladder.domain;

public class Result {
    private final Players players;

    private final Ladders ladders;

    public Result(final Players players, final Ladders ladders) {
        this.players = players;
        this.ladders = ladders;
    }

    public Players getPlayers() {
        return players;
    }

    public Ladders getLadders() {
        return ladders;
    }
}
