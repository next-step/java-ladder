package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rewards {
    public static final String REWARD_SPLITTER = ",";
    private final List<String> rewards;

    public Rewards(String rewards) {
        this(Stream.of(rewards.split(REWARD_SPLITTER))
                .map(String::new)
                .collect(Collectors.toList()));
    }

    public Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public String getReward(int idx) {
        return rewards.get(idx);
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
