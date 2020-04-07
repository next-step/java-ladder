package ladder.domain;

import lombok.Getter;

import java.util.List;

public class LadderReward {
    @Getter
    private List<String> rewards;

    public LadderReward(List<String> rewards) {
        this.rewards = rewards;
    }

    public String getReward(int index) {
        return rewards.get(index);
    }

    public boolean sameSize(int size) {
        return rewards.size() == size;
    }
}
