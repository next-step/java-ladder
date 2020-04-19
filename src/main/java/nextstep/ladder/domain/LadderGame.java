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
        ladder = new Ladder(lines);
    }

    public void generateResultsForAllPlayers() {
        List<LadderLine> ladder = this.ladder.getLadder();
        List<Result> results = gameInfo.getResults().getResults();

        int index = 0;
        for (User user : gameInfo.getUsers().getUsers()) {
            user.setResult(results.get(getIndex(ladder, index)).getResult());
            ++index;
        }
    }

    private int getIndex(List<LadderLine> ladder, int index) {
        for (LadderLine ladderLine : ladder) {
            index = ladderLine.move(index);
        }
        return index;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
