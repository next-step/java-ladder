package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;
    private final Rewards rewards;

    public LadderGame(Ladder ladder, Users users, Rewards rewards) {
        this.ladder = ladder;
        this.users = users;
        this.rewards = rewards;
    }

    public List<GameResult> play() {
        List<GameResult> gameResults = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            int lastPosition = ladder.calculateLastPositionByIndex(i);

            GameResult gameResult = new GameResult(users.getUserNameByIndex(i), rewards.getRewardByIndex(lastPosition));
            gameResults.add(gameResult);
        }
        return gameResults;
    }
}
