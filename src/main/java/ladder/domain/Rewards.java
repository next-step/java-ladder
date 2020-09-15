package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Rewards {
    public static final String COMMA_SEPARATOR = ",";
    private List<Reward> rewardList;

    public Rewards(String results, int userCount) {
        rewardList = splitToRewardList(results);
        userEqualReward(rewardList.size(), userCount);
    }

    private List<Reward> splitToRewardList(String value) {
        AtomicInteger index = new AtomicInteger();

        return Arrays.stream(value.split(COMMA_SEPARATOR))
                .map(v -> new Reward(index.getAndIncrement(), v))
                .collect(Collectors.toList());
    }

    private void userEqualReward(int resultCount, int userCount) {
        if(resultCount != userCount){
            throw new IllegalArgumentException("사용자의 수와 결과의 수가 다릅니다.");
        }
    }

    public List<Reward> getRewards() {
        return rewardList;
    }

    public Reward getSamePosition(int position) {
        return rewardList.stream()
                .filter(reward -> reward.equalPosition(position))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

}
