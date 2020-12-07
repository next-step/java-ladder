package ladder.dto;

import java.util.Collections;
import java.util.List;

public class RewardsDTO {

    private final List<String> rewards;

    public RewardsDTO(List<String> rewards) {
        this.rewards = rewards;
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
