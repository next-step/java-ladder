package nextstep.ladder.domain;

public class LadderGame {
    private GameInfo gameInfo;
    private Ladder ladder;

    public LadderGame(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public LadderGame(Users users, Results results, int ladderHeight) {
        gameInfo = new GameInfo(users, results);
        ladder = new Ladder(users.getCountOfPerson(), ladderHeight);
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
