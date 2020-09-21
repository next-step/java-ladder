package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRewards {
    private final List<LadderReward> ladderRewards;

    public static LadderRewards of(final String rewardNames, final String separator) {
        return Stream.of(rewardNames.split(separator))
                .map(LadderReward::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderRewards::new));
    }

    public LadderRewards(final List<LadderReward> ladderRewards) {
        this.ladderRewards = new ArrayList<>(Collections.unmodifiableList(ladderRewards));
    }

    public int size() {
        return ladderRewards.size();
    }

    public LadderReward getReward(Location rewardLocation) {
        return ladderRewards.get(rewardLocation.toInt());
    }
}
