package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private GameInfo gameInfo;
    private Ladder ladder;

    public LadderGame(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public LadderGame(Users users, Results results, List<LadderLine> lines) {
        gameInfo = new GameInfo(users, results);
        this.ladder = new Ladder(lines);
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
