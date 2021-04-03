package nextstep.ladder.domain;

public class GameResult {
    private Ladder ladder;
    private Players players;

    public GameResult(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public String playersNames() {
        return players.names();
    }

    public String ladder() {
        return ladder.toString();
    }
}
