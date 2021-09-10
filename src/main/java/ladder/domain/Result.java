package ladder.domain;

public class Result {
    private final Players players;

    private final Ladders ladders;

    private final PlayResults playResults;

    public Result(final Players players, final Ladders ladders, final PlayResults playResults) {
        this.players = players;
        this.ladders = ladders;
        this.playResults = playResults;
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

    public String findPlayer(final String playerName) {
        return String.valueOf(players.find(new Name(playerName)));
    }
}
