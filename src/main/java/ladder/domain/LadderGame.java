package ladder.domain;

public class LadderGame {

    private GameInfo gameInfo;
    private Ladder ladder;

    public static LadderGame of(GameInfo gameInfo, Ladder ladder){
        LadderGame ladderGame = new LadderGame();
        ladderGame.gameInfo = gameInfo;
        ladderGame.ladder = ladder;
        return ladderGame;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
