package nextstep.ladder.domain;

import java.util.ArrayList;
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

    public List<UserResult> generateResultsForAllPlayers() {
        List<LadderLine> ladder = this.ladder.getLadder();
        List<Result> results = gameInfo.getResults().getResults();

        List<UserResult> userResults = new ArrayList<>();
        int index = 0;
        for (User user : gameInfo.getUsers().getUsers()) {
            userResults.add(new UserResult(user, results.get(getIndex(ladder, index))));
            ++index;
        }
        return userResults;
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
