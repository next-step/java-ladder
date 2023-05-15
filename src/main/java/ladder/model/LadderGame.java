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
            int lastPosition = calculateLastPositionOfUser(i);

            GameResult gameResult = new GameResult(users.getUserNameByIndex(i), rewards.getRewardByIndex(lastPosition));
            gameResults.add(gameResult);
        }
        return gameResults;
    }

    public int calculateLastPositionOfUser(int index) {
        for (int height = 0; height < ladder.height(); height++) {
            Line line = ladder.getLineByHeight(height);
            index = line.move(index);
        }
        return index;
    }
}
