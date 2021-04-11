package nextstep.ladder.domain.reward;

import nextstep.ladder.domain.ladder.Lane;
import nextstep.ladder.dto.RewardsDto;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rewards {

    private final List<Reward> rewardList;

    private Rewards(List<Reward> rewardList) {
        this.rewardList = rewardList;
    }

    public static Rewards of(List<String> rewardStringList) {
        return rewardStringList.stream()
                               .map(Reward::of)
                               .collect(collectingAndThen(toList(), Rewards::new));
    }

    public Reward getReward(Lane lane) {
        return rewardList.get(lane.unwrap());
    }

    public RewardsDto export() {
        return rewardList.stream()
                         .map(Reward::export)
                         .collect(collectingAndThen(toList(), RewardsDto::new));
    }


}
