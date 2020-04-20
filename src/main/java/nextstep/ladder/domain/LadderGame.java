package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import nextstep.ladder.engine.LadderCreator;

public class LadderGame {
    private GameInfo gameInfo;
    private Ladder ladder;

    public LadderGame(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public LadderGame(String[] userNames, String[] results) {
        gameInfo = new GameInfo(new Users(userNames), new Results(results));
    }

    public UserResults generateResultsForAllPlayers() {
        List<LadderLine> ladder = this.ladder.getLadder();
        List<Result> results = gameInfo.getResults().getResults();

        Map<String, Result> userResults = new LinkedHashMap<>();
        int index = 0;
        for (User user : gameInfo.getUsers().getUsers()) {
            Result result = results.get(getIndex(ladder, index));
            userResults.put(user.getName(), result);
            ++index;
        }
        return new UserResults(userResults);
    }

    public void startGame(LadderCreator ladderFactory) {
        this.ladder = ladderFactory.create();
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
