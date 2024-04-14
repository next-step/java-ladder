package ladder.domain.ladders.reward;

import ladder.domain.participants.Position;
import ladder.domain.result.factory.GameResultFactory;
import ladder.exception.RewardNotFoundException;
import ladder.utils.SplitUtils;

import java.util.List;

public class GameRewards {

    private final List<Reward> rewards;

    public GameRewards(String inputText) {
        this(SplitUtils.split(inputText));
    }

    public GameRewards(String[] items) {
        this(GameResultFactory.createRewards(items));
    }

    public GameRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<Reward> getRewords() {
        return rewards;
    }

    public Prize getRewardByPosition(Position move) {
        return rewards.stream()
                .filter(reward -> reward.isSamePosition(move))
                .findFirst()
                .orElseThrow(() -> new RewardNotFoundException(move))
                .getPrize();
    }
}
