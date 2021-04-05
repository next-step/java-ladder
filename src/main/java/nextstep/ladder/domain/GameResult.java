package nextstep.ladder.domain;

public class GameResult {
    private final Ladder ladder;
    private final Players players;

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
