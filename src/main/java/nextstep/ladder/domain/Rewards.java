package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = new ArrayList<>(rewards);
    }

    public static Rewards from(List<String> rewards) {
        return new Rewards(rewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList()));
    }

    public static Rewards of(Rewards rewards, List<Integer> positionOfAllResult) {
        List<Reward> rewardList = new ArrayList<>();
        for (int position : positionOfAllResult) {
            rewardList.add(rewards.positionOfReward(position));
        }
        return new Rewards(rewardList);
    }

    public Reward positionOfReward(int positionOfResult) {
        return rewards.get(positionOfResult);
    }

    public List<Reward> readOnlyRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public int countOfReward() {
        return rewards.size();
    }
}
