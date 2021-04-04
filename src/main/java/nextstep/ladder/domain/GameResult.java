package nextstep.ladder.domain;

public class GameResult {
    private Ladder ladder;
    private Players players;

    public GameResult(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public Players players() {
        return players;
    }

    public Ladder ladder() {
        return ladder;
    }
}
