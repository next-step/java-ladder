package nextstep.ladder.domain.line;

import java.util.List;

public class Rewards {
    private final List<String> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    List<String> getReward() {
        return this.rewards;
    }
}
