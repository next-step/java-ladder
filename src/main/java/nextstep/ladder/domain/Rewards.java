package nextstep.ladder.domain;

import nextstep.ladder.dto.RewardsDto;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rewards {

    private final List<Reward> rewardList;

    private Rewards(List<Reward> rewardList) {
        this.rewardList = rewardList;
    }

    public static Rewards of(List<String> rewardStrStringList) {
        return rewardStrStringList.stream()
                                  .map(Reward::new)
                                  .collect(collectingAndThen(toList(), Rewards::new));
    }

    public Reward getReward(int position) {
        return rewardList.get(position);
    }

    public int getSize() {
        return rewardList.size();
    }

    public RewardsDto export() {
        return rewardList.stream()
                         .map(Reward::export)
                         .collect(collectingAndThen(toList(), RewardsDto::new));
    }

}
