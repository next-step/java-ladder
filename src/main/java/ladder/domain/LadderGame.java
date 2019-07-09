package ladder.domain;

public class LadderGame {

    private final GameInfo gameInfo;
    private final Ladder ladder;

    private LadderGame(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public static LadderGame of(GameInfo gameInfo, Ladder ladder) {
        return new LadderGame(gameInfo, ladder);
    }
}
